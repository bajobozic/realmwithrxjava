package com.example.bajob.movieshatch.Mvp;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TvShowsPresenterImp_Factory implements Factory<TvShowsPresenterImp> {
  private final Provider<DataSourceManager> dataSourceManagerProvider;

  public TvShowsPresenterImp_Factory(Provider<DataSourceManager> dataSourceManagerProvider) {
    assert dataSourceManagerProvider != null;
    this.dataSourceManagerProvider = dataSourceManagerProvider;
  }

  @Override
  public TvShowsPresenterImp get() {
    return new TvShowsPresenterImp(dataSourceManagerProvider.get());
  }

  public static Factory<TvShowsPresenterImp> create(
      Provider<DataSourceManager> dataSourceManagerProvider) {
    return new TvShowsPresenterImp_Factory(dataSourceManagerProvider);
  }
}
