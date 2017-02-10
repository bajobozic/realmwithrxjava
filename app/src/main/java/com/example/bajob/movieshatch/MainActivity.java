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

    @Inject
    TvShowsPresenterImp presenterImp;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_show_progress_bar)
    ProgressBar progressBar;

    private RecyclerView.Adapter adapter;
    private Integer page = 1;
    private RealmResults<TopRatedTvShows> element;
    private TdbMoviesAdapter.TvShowIdDelegate tvShowDelegate = new TdbMoviesAdapter.TvShowIdDelegate() {
        @Override
        public void handleClickPosition(int tvShowId) {

        }
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MoviesHatchApp) getApplication()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new TdbMoviesAdapter(element, tvShowDelegate);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenterImp.bindView(this);
        presenterImp.loadListData(page);
    }

    @Override
    protected void onDestroy() {
        presenterImp.unbindView();
        super.onDestroy();
    }

    @Override
    public void updateTvShowsList(RealmResults<TopRatedTvShows> topRatedTvShows) {
        ((TdbMoviesAdapter)adapter).setList(topRatedTvShows);
        ((TdbMoviesAdapter)adapter).notifyDataSetChanged();
    }

    @Override
    public void showDetailActivity() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
