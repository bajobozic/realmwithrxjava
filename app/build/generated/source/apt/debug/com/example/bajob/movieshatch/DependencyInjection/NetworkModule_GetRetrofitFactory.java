package com.example.bajob.movieshatch.DependencyInjection;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_GetRetrofitFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<Gson> gsonProvider;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public NetworkModule_GetRetrofitFactory(
      NetworkModule module,
      Provider<Gson> gsonProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    assert module != null;
    this.module = module;
    assert gsonProvider != null;
    this.gsonProvider = gsonProvider;
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.getRetrofit(gsonProvider.get(), okHttpClientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit> create(
      NetworkModule module,
      Provider<Gson> gsonProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    return new NetworkModule_GetRetrofitFactory(module, gsonProvider, okHttpClientProvider);
  }
}
