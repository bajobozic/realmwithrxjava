package com.example.bajob.movieshatch;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bajob.movieshatch.DependencyInjection.ActivityComponent;
import com.example.bajob.movieshatch.DependencyInjection.ApplicationComponent;
import com.example.bajob.movieshatch.DependencyInjection.DaggerActivityComponent;
import com.example.bajob.movieshatch.Mvp.TvShowsPresenterImp;
import com.example.bajob.movieshatch.Mvp.TvShowsView;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity implements TvShowsView {
    private static final String TAG = "MainActivity";
    private ActivityComponent activityComponent;
    @Inject
    TvShowsPresenterImp presenterImp;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageView)
    ImageView searchImage;
    @BindView(R.id.searchText)
    EditText searchText;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_show_progress_bar)
    ProgressBar progressBar;
    private RecyclerView.Adapter adapter;
    private TdbMoviesAdapter.TvShowIdDelegate tvShowDelegate = new TdbMoviesAdapter.TvShowIdDelegate() {
        @Override
        public void handleClickPosition(int tvShowId) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("showId", tvShowId);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityCompat.startActivity(MainActivity.this,intent,ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
               // startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            } else {
                startActivity(intent);
            }

        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ApplicationComponent applicationComponent = ((MoviesHatchApp) getApplication()).getApplicationComponent();
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
//                .activityModule(new ActivityModule())//default constructor for module so we can skip this
                .build();
        activityComponent.inject(this);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setUpRecyclerView();
        setUpSearchToolbar();
        presenterImp.bindView(this);
        presenterImp.loadInitalListData();
    }

    private void setUpSearchToolbar() {
        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int translationXLeft = searchImage.getWidth() - toolbar.getWidth();
                if (searchText.getVisibility() == View.GONE) {
                    searchImage.animate().translationX(translationXLeft).setDuration(250).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            searchText.setVisibility(View.VISIBLE);
                            searchImage.setBackgroundColor(Color.WHITE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {}

                        @Override
                        public void onAnimationRepeat(Animator animator) {}
                    });
                    searchText.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

                        @Override
                        public void afterTextChanged(Editable editable) {}
                    });
                } else {
                    searchImage.animate().translationX(0.0f).setDuration(250).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {
                            searchImage.setBackgroundColor(Color.TRANSPARENT);
                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            searchText.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {}

                        @Override
                        public void onAnimationRepeat(Animator animator) {}
                    });
                    searchText.setVisibility(View.GONE);
                }
            }
        });
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
        activityComponent = null;
        super.onDestroy();
    }

    @Override
    protected void closeRealmInstance() {
        presenterImp.closeRealm();
    }

    @Override
    public void updateTvShowsList(RealmResults<TopRatedTvShows> topRatedTvShows) {
//        hideProgress();
        ((TdbMoviesAdapter) adapter).setList(topRatedTvShows);
    }

    @Override
    public void showDetailActivity() {
    }

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

    @Override
    public void showError(final Throwable throwable) {
        showErrorDialog(throwable, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }
}
