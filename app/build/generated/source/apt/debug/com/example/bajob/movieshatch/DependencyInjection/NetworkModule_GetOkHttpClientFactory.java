package com.example.bajob.movieshatch.DependencyInjection;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_GetOkHttpClientFactory implements Factory<OkHttpClient> {
  private final NetworkModule module;

  public NetworkModule_GetOkHttpClientFactory(NetworkModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.getOkHttpClient(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(NetworkModule module) {
    return new NetworkModule_GetOkHttpClientFactory(module);
  }
}
