package com.example.bajob.movieshatch.Mvp;

import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;

/**
 * Created by bajob on 1/27/2017.
 */
 public interface TvShowsView extends MvpContract.MvpView {
    void updateTvShowsList(final TopRatedTvShows topRatedTvShows);
    void showDetailActivity();
}
