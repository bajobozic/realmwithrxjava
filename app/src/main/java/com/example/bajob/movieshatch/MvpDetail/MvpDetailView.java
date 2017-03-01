package com.example.bajob.movieshatch.MvpDetail;

import com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo;

/**
 * Created by bajob on 2/25/2017.
 */

public interface MvpDetailView extends MvpDetailContract.MvpView {

    public void showData(TvShowDetailedInfo tvShowDetailedInfo);

}
