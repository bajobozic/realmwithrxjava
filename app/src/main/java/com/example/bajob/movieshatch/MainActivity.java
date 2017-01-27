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
import android.view.View;
import android.widget.ProgressBar;

import com.example.bajob.movieshatch.Mvp.TvShowsPresenterImp;
import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;
import com.example.bajob.movieshatch.Pojo.TvShowInfo;
import com.example.bajob.movieshatch.Retrofit.ApiService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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
    @BindView(R.id.tv_show_progress_bar)
    ProgressBar progressBar;

    @Inject
    @Named("instanceRealm")
    Realm realmUi;

    @Inject
    ApiService apiService;

    private RecyclerView.Adapter adapter;

    private RealmResults<TopRatedTvShows> topRatedTvShows;
    private Subscription subscription;
    private boolean loading = false;
    private Integer page = 1;
    //just initial value,set on first load with true value from server
    private Integer totalPages = 100000;
    private RealmChangeListener<RealmResults<TopRatedTvShows>> trmChangeListener = new RealmChangeListener<RealmResults<TopRatedTvShows>>() {
        @Override
        public void onChange(RealmResults<TopRatedTvShows> element) {
            if (totalPages == 100000 && element.size()>0)
                totalPages = element.get(0).getTotalPages();
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
        ((MoviesHatchApp)getApplication()).getApplicationComponent().inject(this);
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
        topRatedTvShows = realmUi.where(TopRatedTvShows.class).findAllAsync();
        topRatedTvShows.addChangeListener(trmChangeListener);
    }

    @Override
    protected void onDestroy() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
        topRatedTvShows.removeChangeListener(trmChangeListener);
        realmUi.close();
        super.onDestroy();
    }

    private void loadData(final Integer page) {
        progressBar.setVisibility(View.VISIBLE);
        final Observable<TopRatedTvShows> movies = apiService.getTopRateedTvShows(null, page);
        subscription = movies
                .zipWith(apiService.getImageConfiguration(), this::getFullPosterPath)
                .map(this::writeToRealm)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pg -> {
                        },
                        throwable -> {
                            stopLoading();
                            Log.e(TAG, "onError: ", throwable);},
                        () -> {
                            stopLoading();
                            MainActivity.this.page = page;
                        }
                );
    }

    private void stopLoading() {
        progressBar.setVisibility(View.GONE);
        loading = false;
    }

    @NonNull
    private TopRatedTvShows getFullPosterPath(TopRatedTvShows topRatedTvShows, ImageConfiguration imageConfiguration) {
        for (int i = 0; i < topRatedTvShows.getResults().size(); i++) {
            TvShowInfo info = topRatedTvShows.getResults().get(i);
            String posterPath = info.getPosterPath();
            String baseUrl = imageConfiguration.getImages().getBaseUrl();
            final List<String> posterSizes = imageConfiguration.getImages().getPosterSizes();
            if (posterSizes != null && posterSizes.size()>0) {
                String finalValue = baseUrl + posterSizes.get(1) + posterPath;
                info.setPosterPath(finalValue);
            }
        }
        return topRatedTvShows;
    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new TdbMoviesAdapter(topRatedTvShows,tvShowIdDelegate);
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
        TopRatedTvShows topRatedTvShows;
        topRatedTvShows = realmUi.where(TopRatedTvShows.class).equalTo("page", integer).findFirst();
        return topRatedTvShows;

    }*/
}
