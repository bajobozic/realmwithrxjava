package com.example.bajob.movieshatch.MvpDetail;

import com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo;
import com.example.bajob.movieshatch.Retrofit.ApiService;

import javax.inject.Singleton;

import io.realm.Realm;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by bajob on 2/24/2017.
 */
@Singleton
public class DataDetailManager {

    private ApiService apiService;
    private Realm realmUi;
    private Observable<TvShowDetailedInfo> showInfoObservable;
    private Subscription subscription = Subscriptions.empty();

    public DataDetailManager(ApiService apiService) {
        this.apiService = apiService;
        realmUi = Realm.getDefaultInstance();
        showInfoObservable = realmUi
                .where(TvShowDetailedInfo.class)
                .findFirstAsync()
                .asObservable();
    }

    public Observable<TvShowDetailedInfo> loadData(int showId) {
        if (realmUi == null || realmUi.isClosed()) {
            realmUi = Realm.getDefaultInstance();
            showInfoObservable = realmUi
                    .where(TvShowDetailedInfo.class)
                    .equalTo("id", showId)
                    .findFirstAsync()
                    .asObservable();
        }
        subscription = apiService
                .getTvShowDetailedInfo(showId, null, null)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(response -> {
                    realmUi.executeTransactionAsync(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.copyToRealmOrUpdate(response.body());
                        }
                    });
                })
                .subscribe();
        return showInfoObservable;
    }

    public void closeRealm() {
        if (realmUi != null || !realmUi.isClosed()) {
            realmUi.close();
            realmUi = null;
        }
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
