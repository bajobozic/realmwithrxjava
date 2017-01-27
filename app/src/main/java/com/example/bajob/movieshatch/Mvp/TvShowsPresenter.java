package com.example.bajob.movieshatch.Mvp;

/**
 * Created by bajob on 1/27/2017.
 */

public interface TvShowsPresenter<V extends TvShowsView> extends MvpContract.MvpPresenter<V> {
    void loadData(Integer page);
}
