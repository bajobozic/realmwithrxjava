package com.example.bajob.movieshatch.Mvp;

import android.support.annotation.NonNull;

import com.example.bajob.movieshatch.ActivityScoped;
import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.TopRatedSearchTvShows;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;
import com.example.bajob.movieshatch.Retrofit.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/**
 * Created by bajob on 1/27/2017.
 */
@ActivityScoped
public class DataSourceManager {
    private final ApiService apiService;
    private final BehaviorSubject<Integer> subject;
    private final BehaviorSubject<String> searchSubject;
    private final Realm realmUi;
    private Observable<RealmResults<TopRatedTvShows>> realmResults = null;
    private Observable<RealmResults<TopRatedSearchTvShows>> searchResults = null;

    @Inject
    public DataSourceManager(ApiService apiService, Realm realmUi) {
        this.apiService = apiService;
        this.realmUi = realmUi;
        this.subject = BehaviorSubject.create(1);
        searchSubject = BehaviorSubject.create();
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
                .flatMap(this::getRealmResultSize)
                .flatMap(integer -> (integer != -1) ? getRealmResults(integer)/*.onErrorResumeNext(throwable -> realmResults)*/ : realmResults);
    }

    public void nextPage(int page) {
        subject.onNext(page);
    }

    public void closeRealm() {
        if (realmUi != null && !realmUi.isClosed()) {
            realmUi.close();
        }
    }

    private Observable<RealmResults<TopRatedTvShows>> getRealmResults(Integer integer) {
        return Observable.zip(apiService.getTopRateedTvShows(null, integer).flatMap(handleErrorTvShows())
                , apiService.getImageConfiguration().flatMap(handleImageResponseError())
                , this::addPosterPath)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(this::writeToRealm)
                .flatMap(topRatedTvShows -> realmResults);
    }

    @NonNull
    private Func1<Response<ImageConfiguration>, Observable<? extends Response<ImageConfiguration>>> handleImageResponseError() {
        return response -> (response.isSuccessful() && response.code() < 300) ? Observable.just(response) : Observable.error(new HttpException(response));
    }

    @NonNull
    private Func1<Response<TopRatedTvShows>, Observable<? extends Response<TopRatedTvShows>>> handleErrorTvShows() {
        return response -> (response.isSuccessful() && response.code() < 300) ? Observable.just(response) : Observable.error(new HttpException(response));
    }

    @NonNull
    private Observable<Integer> getRealmResultSize(Integer integer) {
        return realmResults.map(RealmResults::size).map(integer1 -> (integer1 < integer) ? integer : -1);
    }

    private void writeToRealm(TopRatedTvShows topRatedTvShows) {
        if (topRatedTvShows != null) {
            realmUi.executeTransactionAsync(realm -> realm.insertOrUpdate(topRatedTvShows));
        }
    }
    private void writeToRealmSearch(TopRatedSearchTvShows topRatedTvShows) {
        if (topRatedTvShows != null) {
            realmUi.executeTransactionAsync(realm -> realm.copyToRealmOrUpdate(topRatedTvShows));
        }
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
    private TopRatedSearchTvShows addPosterPathSearch(Response<TopRatedSearchTvShows> t1, Response<ImageConfiguration> t2) {
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

    public Observable<RealmResults<TopRatedSearchTvShows>> loadSearchData(String charSequence) {
        if (searchResults == null) {
            searchResults = realmUi
                    .where(TopRatedSearchTvShows.class)
                    .findAllAsync()
                    .asObservable()
                    .filter(RealmResults::isLoaded)
                    .filter(RealmResults::isValid);
        }
        return searchSubject
                .filter(s -> s.length() > 2)
                .distinctUntilChanged()
                .debounce(350,TimeUnit.MILLISECONDS)
                .switchMap(s -> Observable.zip(apiService.searchTvShows(s), apiService.getImageConfiguration(), this::addPosterPathSearch).observeOn(AndroidSchedulers.mainThread()))
                .doOnNext(this::writeToRealmSearch)
                .flatMap(topRatedSearchTvShows -> searchResults);

    }

    public void loadNextSearchQuery(String charSequence) {
        searchSubject.onNext(charSequence);
    }
}
