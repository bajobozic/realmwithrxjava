package com.example.bajob.movieshatch.MvpDetail;

import com.example.bajob.movieshatch.ActivityScoped;
import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo;
import com.example.bajob.movieshatch.Retrofit.ApiService;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by bajob on 2/24/2017.
 */
@ActivityScoped
public class DataDetailManager {
    private final ApiService apiService;
    private final Realm realmUi;
    private Observable<TvShowDetailedInfo> showInfoObservable = null;

    @Inject
    public DataDetailManager(ApiService apiService, Realm realmUi) {
        this.apiService = apiService;
        this.realmUi = realmUi;
    }

    public Observable<TvShowDetailedInfo> loadData(int showId) {
        initRealm(showId);
        return Observable.mergeDelayError(Observable.zip(apiService.getTvShowDetailedInfo(showId, null, null), apiService.getImageConfiguration(), this::addPosterPath)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(this::writeToRealm)
                , showInfoObservable)
                .takeFirst(tvShowDetailedInfo -> tvShowDetailedInfo != null);
    }

    private void initRealm(int showId) {
        if (showInfoObservable == null) {
            showInfoObservable = realmUi
                    .where(TvShowDetailedInfo.class)
                    .equalTo("id", showId)
                    .findFirstAsync()
                    .<TvShowDetailedInfo>asObservable()
                    .filter(tvShowDetailedInfo -> tvShowDetailedInfo.isLoaded())
                    .filter(tvShowDetailedInfo -> tvShowDetailedInfo.isValid());
        }
    }

    public void closeRealm() {
        if (realmUi != null || !realmUi.isClosed()) {
            realmUi.close();
//            realmUi = null;
        }
    }

    private TvShowDetailedInfo writeToRealm(TvShowDetailedInfo tvShowDetailedInfo) {
        realmUi.executeTransactionAsync(realm -> realm.copyToRealmOrUpdate(tvShowDetailedInfo));
        return tvShowDetailedInfo;
    }

    private TvShowDetailedInfo addPosterPath(Response<TvShowDetailedInfo> t1, Response<ImageConfiguration> t2) {
        try {
            final String baseUrl = t2.body().getImages().getBaseUrl();
            final String posterSize = t2.body().getImages().getPosterSizes().get(1);
            final String backdropPath = t1.body().getBackdropPath();
            final String fullPath = baseUrl + posterSize + backdropPath;
            t1.body().setPosterPath(fullPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return t1.body();
    }
}
