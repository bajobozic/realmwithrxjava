package com.example.bajob.movieshatch;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bajob.movieshatch.MvpDetail.DetailPresenter;
import com.example.bajob.movieshatch.MvpDetail.MvpDetailContract;
import com.example.bajob.movieshatch.MvpDetail.MvpDetailView;
import com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements MvpDetailView {
    private int tvShowId = -1;
    @BindView(R.id.detail_colapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;
    @BindView(R.id.detail_app_bar_image)
    ImageView imageView;
    @BindView(R.id.name)
    TextView textView;
    @BindView(R.id.detail_progress_bar)
    ProgressBar progressBar;

    @Inject
    DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MoviesHatchApp)getApplication()).getApplicationComponent().inject(DetailActivity.this);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        collapsingToolbarLayout.setTitle("");
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailPresenter.bindView(this);
        if (getIntent() != null) {
            if (getIntent().hasExtra("showId")) {
                tvShowId = getIntent().getIntExtra("showId", -1);
                detailPresenter.loadData(tvShowId);
            }
        }
    }

    @Override
    protected void onDestroy() {
        detailPresenter.unbindView();
        super.onDestroy();
    }

    @Override
    protected void closeRealmInstance() {
        detailPresenter.closeRealm();
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
    public void showError(String message) {
        showErrorDialog(message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }

    @Override
    public void showData(TvShowDetailedInfo tvShowDetailedInfo) {
        collapsingToolbarLayout.setTitle(tvShowDetailedInfo.getOriginalName());
        Picasso.with(this).load(tvShowDetailedInfo.getPosterPath()).fit().centerInside().placeholder(R.mipmap.ic_launcher).into(imageView);
        textView.setText(tvShowDetailedInfo.getOverview());
    }

}
