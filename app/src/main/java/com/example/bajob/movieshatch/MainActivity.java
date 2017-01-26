package com.example.bajob.movieshatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;

import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;
import com.example.bajob.movieshatch.Pojo.TvShowInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Realm realmUi;
    private RealmResults<TopRatedTvShows> topRatedMovies;
    private Subscription subscription;
    private boolean loading = false;
    private Integer page = 1;
    //just initial value,set on first load with true value from server
    private Integer totalPages = 100000;
    private RealmChangeListener<RealmResults<TopRatedTvShows>> trmChangeListener = new RealmChangeListener<RealmResults<TopRatedTvShows>>() {
        @Override
        public void onChange(RealmResults<TopRatedTvShows> element) {
            adapter.notifyDataSetChanged();
        }
    };
    private RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            final LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            final int itemCount = layoutManager.getItemCount();
            //only for LinearLayoutManager
            final int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            if (!loading && ((itemCount - lastVisibleItemPosition) <= 5) && (page + 1) < totalPages) {
                loading = true;
                loadData(page + 1);
            }
        }
    };

  private TdbMoviesAdapter.TvShowIdDelegate tvShowIdDelegate = new TdbMoviesAdapter.TvShowIdDelegate() {
      @Override
      public void handleClickPosition(int tvShowId) {
          Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
          //detailIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
          detailIntent.putExtra("showId", tvShowId);
          startActivity(detailIntent);
          finish();
      }
  };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            page = savedInstanceState.getInt("page", 1);
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initRealm();
        setupRecyclerView();
        loadData(page);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("page", page);
    }

    private void initRealm() {
        realmUi = Realm.getDefaultInstance();
        topRatedMovies = realmUi.where(TopRatedTvShows.class)/*.equalTo("page", page)*/.findAllAsync();
        topRatedMovies.addChangeListener(trmChangeListener);
    }

    @Override
    protected void onDestroy() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
        topRatedMovies.removeChangeListener(trmChangeListener);
        realmUi.close();
        super.onDestroy();
    }

    private void loadData(final Integer page) {
        final Observable<TopRatedTvShows> movies = ((MoviesHatchApp) getApplication()).getApiService().getTopRateedTvShows(null, page);
        subscription = movies
                .zipWith(((MoviesHatchApp) getApplication()).getApiService().getImageConfiguration(), this::getFullPosterPath)
                .map(this::writeToRealm)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pg -> {
                        },
                        throwable -> Log.e(TAG, "onError: ", throwable),
                        () -> {
                            stopLoading();
                            MainActivity.this.page = page;
                        }
                );
    }

    private boolean stopLoading() {
        return loading = false;
    }

    @NonNull
    private TopRatedTvShows getFullPosterPath(TopRatedTvShows topRatedMovies, ImageConfiguration imageConfiguration) {
        for (int i = 0; i < topRatedMovies.getResults().size(); i++) {
            TvShowInfo info = topRatedMovies.getResults().get(i);
            String posterPath = info.getPosterPath();
            String baseUrl = imageConfiguration.getImages().getBaseUrl();
            final List<String> posterSizes = imageConfiguration.getImages().getPosterSizes();
            if (posterSizes != null && posterSizes.size()>0) {
                String finalValue = baseUrl + posterSizes.get(1) + posterPath;
                info.setPosterPath(finalValue);
            }
        }
        return topRatedMovies;
    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new TdbMoviesAdapter(topRatedMovies,tvShowIdDelegate);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(scrollListener);
    }

    private Integer writeToRealm(final TopRatedTvShows movies) {
        final Realm currentThreadRealm = Realm.getDefaultInstance();
        try {
            currentThreadRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.copyToRealmOrUpdate(movies);
                }
            });
            return movies.getPage();
        } finally {
            currentThreadRealm.close();
        }

    }

   /* private TopRatedTvShows readFromRealm(final Integer integer) {
        TopRatedTvShows topRatedMovies;
        topRatedMovies = realmUi.where(TopRatedTvShows.class).equalTo("page", integer).findFirst();
        return topRatedMovies;

    }*/
}
