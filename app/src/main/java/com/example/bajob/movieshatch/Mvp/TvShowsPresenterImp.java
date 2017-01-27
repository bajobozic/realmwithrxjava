package com.example.bajob.movieshatch.Mvp;

/**
 * Created by bajob on 1/27/2017.
 */
public class TvShowsPresenterImp<TvShowsView> implements TvShowsPresenter {
    MvpContract.MvpView tvShowsView;

    @Override
    public void loadData(Integer page) {

    }

    @Override
    public void bindView(MvpContract.MvpView mvpView) {
        this.tvShowsView = mvpView;
    }

    @Override
    public void unbindView() {
        this.tvShowsView = null;

    }
}
