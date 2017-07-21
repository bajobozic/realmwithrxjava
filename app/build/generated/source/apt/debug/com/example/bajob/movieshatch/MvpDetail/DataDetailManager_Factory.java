package com.example.bajob.movieshatch.MvpDetail;

import com.example.bajob.movieshatch.Retrofit.ApiService;
import dagger.internal.Factory;
import io.realm.Realm;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataDetailManager_Factory implements Factory<DataDetailManager> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<Realm> realmUiProvider;

  public DataDetailManager_Factory(
      Provider<ApiService> apiServiceProvider, Provider<Realm> realmUiProvider) {
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
    assert realmUiProvider != null;
    this.realmUiProvider = realmUiProvider;
  }

  @Override
  public DataDetailManager get() {
    return new DataDetailManager(apiServiceProvider.get(), realmUiProvider.get());
  }

  public static Factory<DataDetailManager> create(
      Provider<ApiService> apiServiceProvider, Provider<Realm> realmUiProvider) {
    return new DataDetailManager_Factory(apiServiceProvider, realmUiProvider);
  }
}
