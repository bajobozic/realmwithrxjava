package com.example.bajob.movieshatch.MvpDetail;

import com.example.bajob.movieshatch.Mvp.MvpContract;
import com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo;

/**
 * Created by bajob on 2/24/2017.
 */

public interface MvpDetailContract {
    interface MvpDetailView {
        void showProgress();

        void hideProgress();

        void showData(TvShowDetailedInfo tvShowDetailedInfo);

    }

    interface MvpDetailPresenter<T extends MvpDetailView> {
        void loadData(final int showId);

        void bindView(final MvpDetailView view);

        void unbindView();

        void closeRealm();
    }

}
