package com.example.bajob.movieshatch.Mvp;

/**
 * Created by bajob on 1/27/2017.
 */

public interface MvpContract {
    interface MvpView {
        void showProgress();
        void hideProgress();

    }

     interface MvpPresenter<V extends MvpView> {
        void bindView(V v);
        void unbindView();
    }

}
