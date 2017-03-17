package com.example.bajob.movieshatch.Mvp;

import com.example.bajob.movieshatch.Pojo.TopRatedInteface;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;

import io.realm.RealmResults;

/**
 * Created by bajob on 1/27/2017.
 */
 public interface TvShowsView extends MvpContract.MvpView {
    void showError(final Throwable throwable);
    void updateTvShowsList(final RealmResults<? extends TopRatedInteface> topRatedTvShows);
    void showDetailActivity();

    void refreshList();
}
