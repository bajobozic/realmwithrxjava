package com.example.bajob.movieshatch.Mvp;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by bajob on 1/27/2017.
 * this is not singleton instance
 */
public class TvShowsPresenterImp implements TvShowsPresenter<TvShowsView> {
    Subscription subscription;
    TvShowsView view;
    final DataSourceManager dataSourceManager;
    @Inject
    public TvShowsPresenterImp(DataSourceManager dataSourceManager) {
        this.dataSourceManager = dataSourceManager;
    }

    @Override
    public void loadListData(Integer page) {
        view.showProgress();
    }

    @Override
    public void bindView(TvShowsView tvShowsView) {
        this.view = tvShowsView;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }
}
