package com.example.bajob.movieshatch;

import com.example.bajob.movieshatch.MvpDetail.DetailPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DetailActivity_MembersInjector implements MembersInjector<DetailActivity> {
  private final Provider<DetailPresenter> detailPresenterProvider;

  public DetailActivity_MembersInjector(Provider<DetailPresenter> detailPresenterProvider) {
    assert detailPresenterProvider != null;
    this.detailPresenterProvider = detailPresenterProvider;
  }

  public static MembersInjector<DetailActivity> create(
      Provider<DetailPresenter> detailPresenterProvider) {
    return new DetailActivity_MembersInjector(detailPresenterProvider);
  }

  @Override
  public void injectMembers(DetailActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.detailPresenter = detailPresenterProvider.get();
  }

  public static void injectDetailPresenter(
      DetailActivity instance, Provider<DetailPresenter> detailPresenterProvider) {
    instance.detailPresenter = detailPresenterProvider.get();
  }
}
