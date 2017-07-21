package com.example.bajob.movieshatch.DependencyInjection;

import android.app.Application;
import com.example.bajob.movieshatch.MoviesHatchApp;
import com.example.bajob.movieshatch.Retrofit.ApiService;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Application> getApplicationProvider;

  private Provider<Gson> getGsonProvider;

  private Provider<OkHttpClient> getOkHttpClientProvider;

  private Provider<Retrofit> getRetrofitProvider;

  private Provider<ApiService> getApiServiceProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getApplicationProvider =
        DoubleCheck.provider(
            ApplicationModule_GetApplicationFactory.create(builder.applicationModule));

    this.getGsonProvider =
        DoubleCheck.provider(NetworkModule_GetGsonFactory.create(builder.networkModule));

    this.getOkHttpClientProvider =
        DoubleCheck.provider(NetworkModule_GetOkHttpClientFactory.create(builder.networkModule));

    this.getRetrofitProvider =
        DoubleCheck.provider(
            NetworkModule_GetRetrofitFactory.create(
                builder.networkModule, getGsonProvider, getOkHttpClientProvider));

    this.getApiServiceProvider =
        DoubleCheck.provider(
            NetworkModule_GetApiServiceFactory.create(builder.networkModule, getRetrofitProvider));
  }

  @Override
  public void inject(MoviesHatchApp app) {
    MembersInjectors.<MoviesHatchApp>noOp().injectMembers(app);
  }

  @Override
  public Application getApplication() {
    return getApplicationProvider.get();
  }

  @Override
  public ApiService getApiService() {
    return getApiServiceProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private NetworkModule networkModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      if (networkModule == null) {
        throw new IllegalStateException(NetworkModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }
  }
}
