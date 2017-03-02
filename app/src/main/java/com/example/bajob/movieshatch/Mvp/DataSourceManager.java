package com.example.bajob.movieshatch.Mvp;

import android.support.annotation.NonNull;

import com.example.bajob.movieshatch.ActivityScoped;
import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;
import com.example.bajob.movieshatch.Retrofit.ApiService;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by bajob on 1/27/2017.
 */
@ActivityScoped
public class DataSourceManager {
    private final ApiService apiService;
    private final BehaviorSubject<Integer> subject;
    private final Realm realmUi;
    private Observable<RealmResults<TopRatedTvShows>> realmResults = null;

    @Inject
    public DataSourceManager(ApiService apiService, Realm realmUi) {
        this.apiService = apiService;
        this.realmUi = realmUi;
        this.subject = BehaviorSubject.create(1);
    }

    /**
     * initial load of data,happens just once on app startup
     *
     * @return Observable
     */
    public Observable<RealmResults<TopRatedTvShows>> loadData() {
        //on rotation realm is closed so we reinstantiate new realm instance
        //and query realm db,other members are preserved because this is
        //singleton class
        if (realmResults == null) {
            this.realmResults = realmUi
                    .where(TopRatedTvShows.class)
                    .findAllAsync()
                    .asObservable()
                    .filter(RealmResults::isLoaded)
                    .filter(RealmResults::isValid);
        }
        return subject.asObservable()
                .distinctUntilChanged()
                .flatMap(this::getRealmResultSize)
                .flatMap(integer -> (integer != -1) ? getRealmResults(integer) : realmResults);
    }

    public void nextPage(int page) {
        subject.onNext(page);
    }

    public void closeRealm() {
        if (realmUi != null && !realmUi.isClosed()) {
            realmUi.close();
//            realmUi = null;
        }
    }

    private Observable<RealmResults<TopRatedTvShows>> getRealmResults(Integer integer) {
        return Observable.zip(apiService.getTopRateedTvShows(null, integer)
                , apiService.getImageConfiguration()
                , this::addPosterPath)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(this::writeToRealm)
                .flatMap(topRatedTvShows -> realmResults);
    }

    @NonNull
    private Observable<Integer> getRealmResultSize(Integer integer) {
        return realmResults.map(RealmResults::size).map(integer1 -> (integer1 < integer) ? integer : -1);
    }

    private void writeToRealm(TopRatedTvShows topRatedTvShows) {
        realmUi.executeTransactionAsync(realm -> realm.copyToRealmOrUpdate(topRatedTvShows));
    }

    private TopRatedTvShows addPosterPath(Response<TopRatedTvShows> t1, Response<ImageConfiguration> t2) {
        try {
            final String baseUrl = t2.body().getImages().getBaseUrl();
            final String posterSize = t2.body().getImages().getPosterSizes().get(1);
            for (int i = 0; i < t1.body().getResults().size(); i++) {
                final String posterPath = t1.body().getResults().get(i).getPosterPath();
                final String fullPath = baseUrl + posterSize + posterPath;
                t1.body().getResults().get(i).setPosterPath(fullPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t1.body();
    }
}
