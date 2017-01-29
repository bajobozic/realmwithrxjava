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
import com.example.bajob.movieshatch.Mvp.TvShowsView;
import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;
import com.example.bajob.movieshatch.Pojo.TvShowInfo;
import com.example.bajob.movieshatch.Retrofit.ApiService;
import com.jakewharton.rxbinding.support.v7.widget.RxRecyclerView;
import com.jakewharton.rxbinding.view.RxView;

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
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity implements TvShowsView {
    private static final String TAG = "MainActivity";
    private CompositeSubscription recyclerSubscription = new CompositeSubscription();

    @Inject
    TvShowsPresenterImp presenterImp;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_show_progress_bar)
    ProgressBar progressBar;

    private RecyclerView.Adapter adapter;

    private boolean loading = false;
    private Integer page = 1;
    private Integer totalPages = 100000;

    protected void onCreate(Bundle savedInstanceState) {
        ((MoviesHatchApp) getApplication()).getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            page = savedInstanceState.getInt("page", 1);
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setupRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenterImp.bindView(this);
        presenterImp.loadListData(page);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("page", page);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /*private void loadData(final Integer page) {
        progressBar.setVisibility(View.VISIBLE);
        final Observable<TopRatedTvShows> movies = apiService.getTopRateedTvShows(null, page);
        subscription = movies
                .zipWith(apiService.getImageConfiguration(), this::getFullPosterPath)
                .observeOn(AndroidSchedulers.mainThread())
                .map(this::writeToRealm)
                .subscribe(pg -> {
                        },
                        throwable -> {
                            stopLoading();
                            Log.e(TAG, "onError: ", throwable);
                        },
                        () -> {
                            stopLoading();
                            MainActivity.this.page = page;
                        }
                );
    }*/

    private void stopLoading() {
        progressBar.setVisibility(View.GONE);
        loading = false;
    }

    /*@NonNull
    private TopRatedTvShows getFullPosterPath(TopRatedTvShows topRatedTvShows, ImageConfiguration imageConfiguration) {
        for (int i = 0; i < topRatedTvShows.getResults().size(); i++) {
            TvShowInfo info = topRatedTvShows.getResults().get(i);
            String posterPath = info.getPosterPath();
            String baseUrl = imageConfiguration.getImages().getBaseUrl();
            final List<String> posterSizes = imageConfiguration.getImages().getPosterSizes();
            if (posterSizes != null && posterSizes.size() > 0) {
                String finalValue = baseUrl + posterSizes.get(1) + posterPath;
                info.setPosterPath(finalValue);
            }
        }
        return topRatedTvShows;
    }
*/
    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new TdbMoviesAdapter(null /*topRatedTvShows*/, tvShowIdDelegate);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerSubscription.add(RxRecyclerView.scrollEvents(recyclerView).filter(event -> {
            final LinearLayoutManager localLayoutManager = (LinearLayoutManager) event.view().getLayoutManager();
            final int itemCount = localLayoutManager.getItemCount();
            final int lastVisibleItemPosition = localLayoutManager.findLastVisibleItemPosition();
            if (!loading && ((itemCount - lastVisibleItemPosition) <= 5) && (page + 1) < totalPages) {
                return loading = true;
            } else
                return loading = false;
        }).subscribe(recyclerViewScrollEvent -> presenterImp.loadListData(page + 1),
                e -> Log.e(TAG, "RecyclerView:" + e.getMessage(), e),
                () -> {
                }
        ));
        //recyclerView.addOnScrollListener(scrollListener);
    }

    /*private Integer writeToRealm(final TopRatedTvShows movies) {
        realmUi.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(movies);
            }
        });
        return movies.getPage();

    }*/

    private RealmChangeListener<RealmResults<TopRatedTvShows>> trmChangeListener = new RealmChangeListener<RealmResults<TopRatedTvShows>>() {
        @Override
        public void onChange(RealmResults<TopRatedTvShows> element) {
            if (totalPages == 100000 && element.size() > 0)
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

                presenterImp.loadListData(page + 1);
            }
        }
    };
    private TdbMoviesAdapter.TvShowIdDelegate tvShowIdDelegate = new TdbMoviesAdapter.TvShowIdDelegate() {
        @Override
        public void handleClickPosition(int tvShowId) {
            Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
            detailIntent.putExtra("showId", tvShowId);
            startActivity(detailIntent);
            finish();
        }
    };

    @Override
    public void updateTvShowsList(TopRatedTvShows topRatedTvShows) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDetailActivity() {

    }

    @Override
    public void showProgress() {
        loading = true;
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loading = false;
        progressBar.setVisibility(View.GONE);

    }
}
