package com.example.bajob.movieshatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.bajob.movieshatch.DependencyInjection.ActivityComponent;
import com.example.bajob.movieshatch.Mvp.TvShowsPresenterImp;
import com.example.bajob.movieshatch.Mvp.TvShowsView;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity implements TvShowsView {
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
    private ActivityComponent activityComponent;
    private TdbMoviesAdapter.TvShowIdDelegate tvShowDelegate = new TdbMoviesAdapter.TvShowIdDelegate() {
        @Override
        public void handleClickPosition(int tvShowId) {
            Intent intent = new Intent(MainActivity.this,DetailActivity.class);
            intent.putExtra("showId", tvShowId);
            startActivity(intent);
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DaggerActivityComponent.builder().applicationComponent(((MoviesHatchApp) getApplication()).getApplicationComponent()).build().inject(MainActivity.this);
        ((MoviesHatchApp) getApplication()).getApplicationComponent().inject(MainActivity.this);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setUpRecyclerView();
        presenterImp.bindView(this);
        presenterImp.loadInitalListData();
    }

    private void setUpRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new TdbMoviesAdapter(null, tvShowDelegate);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                presenterImp.loadListDataOnScroll(recyclerView.getLayoutManager().getItemCount()
                        , ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        presenterImp.unbindView();
        super.onDestroy();
    }

    @Override
    protected void closeRealmInstance() {
        presenterImp.closeRealm();
    }

    @Override
    public void updateTvShowsList(RealmResults<TopRatedTvShows> topRatedTvShows) {
        hideProgress();
        ((TdbMoviesAdapter) adapter).setList(topRatedTvShows);
    }

    @Override
    public void showDetailActivity() {}

    @Override
    public void refreshList() {
        ((TdbMoviesAdapter) adapter).notifyDataSetChanged();
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
