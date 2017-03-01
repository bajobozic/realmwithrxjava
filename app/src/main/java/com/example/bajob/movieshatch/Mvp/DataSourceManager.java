package com.example.bajob.movieshatch.Mvp;

import android.util.Log;

import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;
import com.example.bajob.movieshatch.Retrofit.ApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by bajob on 1/27/2017.
 */
@Singleton
public class DataSourceManager {
    private final ApiService apiService;
    private final BehaviorSubject<Integer> subject;
    private Realm realmUi;
    private Observable<RealmResults<TopRatedTvShows>> realmResults;
    private Subscription subscription;

    @Inject
    public DataSourceManager(ApiService apiService) {
        this.apiService = apiService;
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
        if (realmUi == null || realmUi.isClosed()) {
            realmUi = Realm.getDefaultInstance();
            this.realmResults = realmUi
                    .where(TopRatedTvShows.class)
                    .findAllAsync()
                    .asObservable()
                    .filter(RealmResults::isLoaded)
                    .filter(RealmResults::isValid);

        }
        subscription = subject
                .distinctUntilChanged()
                .flatMap(integer -> realmResults
                        .map(RealmResults::size)
                        .filter(integer1 -> integer1 < integer).map(integer1 -> integer)
                        .doOnNext(integer1 -> Log.d("PAGE", " nUMBER: " + integer)))
                .flatMap(integer -> Observable.zip(apiService.getTopRateedTvShows(null, integer),
                        apiService.getImageConfiguration(),
                        this::addPosterPath))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(this::writeToRealm)
                .subscribe(integer -> {
                }, Throwable::printStackTrace, () -> {
                });
        return realmResults;
    }

    void nextPage(int page) {
        subject.onNext(page);
    }

    void closeRealm() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        if (realmUi != null && !realmUi.isClosed()) {
            realmUi.close();
            realmUi = null;
        }
    }

    private Integer writeToRealm(TopRatedTvShows topRatedTvShows) {
        realmUi.executeTransactionAsync(realm -> realm.copyToRealmOrUpdate(topRatedTvShows));
        return topRatedTvShows.getPage();
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

    private <T> Observable.Transformer<T, T> printThread() {
        return tObservable -> tObservable.subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread());
    }
}
