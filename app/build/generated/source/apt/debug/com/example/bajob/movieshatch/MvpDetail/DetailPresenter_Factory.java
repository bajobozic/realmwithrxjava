package com.example.bajob.movieshatch.MvpDetail;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DetailPresenter_Factory implements Factory<DetailPresenter> {
  private final Provider<DataDetailManager> dataDetailManagerProvider;

  public DetailPresenter_Factory(Provider<DataDetailManager> dataDetailManagerProvider) {
    assert dataDetailManagerProvider != null;
    this.dataDetailManagerProvider = dataDetailManagerProvider;
  }

  @Override
  public DetailPresenter get() {
    return new DetailPresenter(dataDetailManagerProvider.get());
  }

  public static Factory<DetailPresenter> create(
      Provider<DataDetailManager> dataDetailManagerProvider) {
    return new DetailPresenter_Factory(dataDetailManagerProvider);
  }
}
