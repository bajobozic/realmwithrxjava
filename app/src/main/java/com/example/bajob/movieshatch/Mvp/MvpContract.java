package com.example.bajob.movieshatch.Mvp;

/**
 * Created by bajob on 1/27/2017.
 */

public interface MvpContract {
    interface MvpView {
        void showProgress();

        void hideProgress();

        void showError(final Throwable throwable);

    }

    interface MvpPresenter<T extends MvpView> {
        void bindView(T t);

        void unbindView();
    }

}
