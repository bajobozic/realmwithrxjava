package com.example.bajob.movieshatch.MvpDetail;

import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;
import com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo;
import com.example.bajob.movieshatch.Retrofit.ApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by bajob on 2/24/2017.
 */
@Singleton
public class DataDetailManager {
    private final ApiService apiService;
    private Realm realmUi;
    private Observable<TvShowDetailedInfo> showInfoObservable;

    @Inject
    public DataDetailManager(ApiService apiService) {
        this.apiService = apiService;
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
        if (realmUi == null || realmUi.isClosed()) {
            realmUi = Realm.getDefaultInstance();
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
            realmUi = null;
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
