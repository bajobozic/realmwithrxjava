package com.example.bajob.movieshatch.Mvp;

import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;
import com.example.bajob.movieshatch.Pojo.TvShowInfo;
import com.example.bajob.movieshatch.Retrofit.ApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by bajob on 1/27/2017.
 */
@Singleton
public class DataSourceManager {
    private final Observable<RealmResults<TopRatedTvShows>> realmResultsObservable;
    private final ApiService apiService;

    private final Realm realmUi;

    @Inject
    public DataSourceManager(Realm realmUi, ApiService apiService) {
        this.realmUi = realmUi;
        this.apiService = apiService;
        this.realmResultsObservable = realmUi.where(TopRatedTvShows.class).findAllAsync().asObservable();

    }

    public Observable<RealmResults<TopRatedTvShows>> loadData(Integer page) {
        Observable.zip(apiService.getTopRateedTvShows(null, page), apiService.getImageConfiguration(), this::addPosterPath)
                .observeOn(AndroidSchedulers.mainThread())
                .map(this::writeToRealm)
                .subscribe(new Observer<TopRatedTvShows>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TopRatedTvShows topRatedTvShows) {

                    }
                });
        return realmResultsObservable;
    }

    private TopRatedTvShows writeToRealm(TopRatedTvShows topRatedTvShows) {
        boolean loaded;
        realmUi.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(topRatedTvShows);
            }
        });
        return topRatedTvShows;
    }

    private TopRatedTvShows addPosterPath(TopRatedTvShows t1, ImageConfiguration t2) {
        final String baseUrl = t2.getImages().getBaseUrl();

        for (int i = 0; i < t1.getResults().size(); i++) {
            final String posterPath = t1.getResults().get(i).getPosterPath();
            final String fullPath = baseUrl + posterPath;
            t1.getResults().get(i).setPosterPath(fullPath);
        }
        return t1;
    }

    public Observable<RealmResults<TopRatedTvShows>> getRealmResultsObservable() {
        return realmResultsObservable;
    }
}
