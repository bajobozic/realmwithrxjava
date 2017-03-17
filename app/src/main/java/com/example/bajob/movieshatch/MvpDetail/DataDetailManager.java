package com.example.bajob.movieshatch.MvpDetail;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.bajob.movieshatch.ActivityScoped;
import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo;
import com.example.bajob.movieshatch.Retrofit.ApiService;
import com.squareup.haha.trove.THash;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.realm.Realm;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Created by bajob on 2/24/2017.
 */
@ActivityScoped
public class DataDetailManager {
    private final ApiService apiService;
    private final Realm realmUi;
    private final int timeoutTreshold = 500;//in this time range we should hopefully load data from realm else just pull from network
    private Observable<TvShowDetailedInfo> showInfoObservable = null;

    @Inject
    public DataDetailManager(ApiService apiService, Realm realmUi) {
        this.apiService = apiService;
        this.realmUi = realmUi;
    }

    public Observable<TvShowDetailedInfo> loadData(int showId) {
        initRealm(showId);
        return showInfoObservable.timeout(timeoutTreshold, TimeUnit.MILLISECONDS, Observable.empty())
                .observeOn(AndroidSchedulers.mainThread())
                .concatWith(Observable.zip(apiService.getTvShowDetailedInfo(showId, null, null).flatMap(handleShowErrorResponse()), apiService.getImageConfiguration().flatMap(handleImageErrorResponse()), this::addPosterPath)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(this::writeToRealm))
                .first();
    }

    @NonNull
    private Func1<Response<TvShowDetailedInfo>, Observable<? extends Response<TvShowDetailedInfo>>> handleShowErrorResponse() {
        return response -> (response.isSuccessful() && response.code() < 300) ? Observable.just(response) : Observable.error(new HttpException(response));
    }

    @NonNull
    private Func1<Response<ImageConfiguration>, Observable<? extends Response<ImageConfiguration>>> handleImageErrorResponse() {
        return response -> (response.isSuccessful() && response.code() < 300) ? Observable.just(response) : Observable.error(new HttpException(response));
    }

    private void initRealm(int showId) {
        if (showInfoObservable == null) {
            showInfoObservable = realmUi
                    .where(TvShowDetailedInfo.class)
                    .equalTo("id", showId)
                    .findFirstAsync().<TvShowDetailedInfo>asObservable()//never fires onError or onCompleted notification,basically this is infinite observable
                    .filter(tvShowDetailedInfo -> tvShowDetailedInfo.isLoaded())//so in case there is no data for given id in realm database we must use timeout operator to send onCompleted event
                    .filter(tvShowDetailedInfo -> tvShowDetailedInfo.isValid());//and switch to network source for data
        }
    }

    public void closeRealm() {
        if (realmUi != null || !realmUi.isClosed()) {
            realmUi.close();
        }
    }

    private void writeToRealm(TvShowDetailedInfo tvShowDetailedInfo) {
        if (tvShowDetailedInfo != null) {
            realmUi.executeTransactionAsync(realm -> realm.insertOrUpdate(tvShowDetailedInfo));
        }
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
