package com.example.bajob.movieshatch.MvpDetail;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by bajob on 2/24/2017.
 */
public class DetailPresenter implements MvpDetailContract.MvpDetailPresenter<MvpDetailView> {
    private MvpDetailView mvpDetailView;
    private DataDetailManager dataDetailManager;
    private Subscription subscription = Subscriptions.empty();

    @Inject
    public DetailPresenter(DataDetailManager dataDetailManager) {
        this.dataDetailManager = dataDetailManager;
    }

    @Override
    public void loadData(final int showId) {
        mvpDetailView.showProgress();
        subscription = dataDetailManager
                .loadData(showId)
                .subscribe(tvShowDetailedInfo -> {
                            mvpDetailView.hideProgress();
                            mvpDetailView.showData(tvShowDetailedInfo);
                        }
                        , throwable -> {mvpDetailView.hideProgress();
                          throwable.printStackTrace();}
                        , () -> {
                            mvpDetailView.hideProgress();
                        });
    }

    @Override
    public void bindView(MvpDetailView view) {
        this.mvpDetailView = view;
    }


    @Override
    public void unbindView() {
        this.mvpDetailView = null;
        subscription.unsubscribe();
    }

    @Override
    public void closeRealm() {
        dataDetailManager.closeRealm();
    }
}
