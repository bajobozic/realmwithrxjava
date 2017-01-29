package com.example.bajob.movieshatch.Mvp;

/**
 * Created by bajob on 1/27/2017.
 */

public interface TvShowsPresenter<T extends MvpContract.MvpView> extends MvpContract.MvpPresenter<T> {
    void loadListData(Integer page);
}
