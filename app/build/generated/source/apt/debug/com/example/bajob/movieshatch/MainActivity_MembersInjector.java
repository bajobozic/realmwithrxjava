package com.example.bajob.movieshatch;

import com.example.bajob.movieshatch.Mvp.TvShowsPresenterImp;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<TvShowsPresenterImp> presenterImpProvider;

  public MainActivity_MembersInjector(Provider<TvShowsPresenterImp> presenterImpProvider) {
    assert presenterImpProvider != null;
    this.presenterImpProvider = presenterImpProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<TvShowsPresenterImp> presenterImpProvider) {
    return new MainActivity_MembersInjector(presenterImpProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenterImp = presenterImpProvider.get();
  }

  public static void injectPresenterImp(
      MainActivity instance, Provider<TvShowsPresenterImp> presenterImpProvider) {
    instance.presenterImp = presenterImpProvider.get();
  }
}
