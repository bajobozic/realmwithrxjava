package com.example.bajob.movieshatch.Mvp;

import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;

import javax.inject.Inject;

import io.realm.RealmResults;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by bajob on 1/27/2017.
 * this is not singleton instance
 */
public class TvShowsPresenterImp implements TvShowsPresenter<TvShowsView> {
    Subscription subscription;
    TvShowsView view;
    DataSourceManager dataSourceManager;

    @Inject
    public TvShowsPresenterImp(DataSourceManager dataSourceManager) {
        this.dataSourceManager = dataSourceManager;
    }

    @Override
    public void loadListData(Integer page) {
        view.showProgress();
        subscription = dataSourceManager.loadData(page).subscribe(new Observer<RealmResults<TopRatedTvShows>>() {
            @Override
            public void onCompleted() {
                view.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                view.hideProgress();
            }

            @Override
            public void onNext(RealmResults<TopRatedTvShows> topRatedTvShowses) {
                view.updateTvShowsList(topRatedTvShowses);
                view.hideProgress();
            }
        });
    }

    @Override
    public void bindView(TvShowsView tvShowsView) {
        this.view = tvShowsView;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }
}
