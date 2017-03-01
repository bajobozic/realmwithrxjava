package com.example.bajob.movieshatch.MvpDetail;

import com.example.bajob.movieshatch.Mvp.MvpContract;
import com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo;

/**
 * Created by bajob on 2/24/2017.
 */

public interface MvpDetailContract {
    interface MvpView {
        void showProgress();

        void hideProgress();

        void showError(final String message);

    }

    interface MvpDetailPresenter<T extends MvpView> {
        void loadData(final int showId);

        void bindView(final T view);

        void unbindView();

        void closeRealm();
    }

}
