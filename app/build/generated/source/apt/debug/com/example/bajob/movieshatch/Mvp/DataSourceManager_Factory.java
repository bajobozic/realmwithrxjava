package com.example.bajob.movieshatch.Mvp;

import com.example.bajob.movieshatch.Retrofit.ApiService;
import dagger.internal.Factory;
import io.realm.Realm;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataSourceManager_Factory implements Factory<DataSourceManager> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<Realm> realmUiProvider;

  public DataSourceManager_Factory(
      Provider<ApiService> apiServiceProvider, Provider<Realm> realmUiProvider) {
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
    assert realmUiProvider != null;
    this.realmUiProvider = realmUiProvider;
  }

  @Override
  public DataSourceManager get() {
    return new DataSourceManager(apiServiceProvider.get(), realmUiProvider.get());
  }

  public static Factory<DataSourceManager> create(
      Provider<ApiService> apiServiceProvider, Provider<Realm> realmUiProvider) {
    return new DataSourceManager_Factory(apiServiceProvider, realmUiProvider);
  }
}
