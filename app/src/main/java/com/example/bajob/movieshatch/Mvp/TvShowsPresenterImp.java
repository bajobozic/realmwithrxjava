package com.example.bajob.movieshatch.Mvp;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by bajob on 1/27/2017.
 * this is not singleton instance
 */
public class TvShowsPresenterImp implements TvShowsPresenter<TvShowsView> {
    private Subscription subscription;
    private TvShowsView view;
    private final DataSourceManager dataSourceManager;
    private int page = 1;
    private boolean loading = false;

    @Inject
    public TvShowsPresenterImp(DataSourceManager dataSourceManager) {
        this.dataSourceManager = dataSourceManager;
    }

    @Override
    public void loadInitalListData() {
        view.showProgress();
        subscription = dataSourceManager.loadData()
                .doOnNext(topRatedTvShowses -> page = topRatedTvShowses.size())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(topRatedTvShowses -> {
                    view.hideProgress();
                    view.updateTvShowsList(topRatedTvShowses);
                    loading = false;
                    //this is called two times on app startup time and that is problem
                    //page is incremented twice so we skip page 2,after that everything is ok
                    // its more logical to call from here
                    //not from loadListDataOnScroll,but???
                    //++page;
                }, throwable -> {
                    if (page > 1) {
                        loading = false;
                        --page;
                    }
                    view.hideProgress();
                    throwable.printStackTrace();
                }, () -> {
                    view.hideProgress();
                });
    }

    @Override
    public void loadListDataOnScroll(int childCount, int lastVisibleChild) {
        if (!loading && (childCount - lastVisibleChild) <= 5) {
            loading = true;
            view.showProgress();
            dataSourceManager.nextPage(++page);
        }
    }

    @Override
    public void closeRealm() {
        dataSourceManager.closeRealm();
    }

    @Override
    public void bindView(TvShowsView tvShowsView) {
        this.view = tvShowsView;
    }

    @Override
    public void unbindView() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        this.view = null;
    }
}
