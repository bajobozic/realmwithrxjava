package com.example.bajob.movieshatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bajob.movieshatch.MvpDetail.DetailPresenter;
import com.example.bajob.movieshatch.MvpDetail.MvpDetailContract;
import com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements MvpDetailContract.MvpDetailView {
    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;
    private int tvShowId = -1;
    @Inject
    DetailPresenter detailPresenter;
    @BindView(R.id.detail_app_bar_image)
    ImageView imageView;
    @BindView(R.id.name)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        DaggerActivityDetailComponent.builder().applicationComponent(((MoviesHatchApp) getApplication()).getApplicationComponent()).build().inject(DetailActivity.this);
        ((MoviesHatchApp)getApplication()).getApplicationComponent().inject(DetailActivity.this);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
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

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showData(TvShowDetailedInfo tvShowDetailedInfo) {
        Picasso.with(this).load(tvShowDetailedInfo.getPosterPath()).fit().centerCrop().placeholder(R.mipmap.ic_launcher).into(imageView);
        textView.setText(tvShowDetailedInfo.getOverview());
    }

}
