package com.example.bajob.movieshatch.DependencyInjection;

import com.example.bajob.movieshatch.DetailActivity;
import com.example.bajob.movieshatch.DetailActivity_MembersInjector;
import com.example.bajob.movieshatch.MainActivity;
import com.example.bajob.movieshatch.MainActivity_MembersInjector;
import com.example.bajob.movieshatch.Mvp.DataSourceManager;
import com.example.bajob.movieshatch.Mvp.DataSourceManager_Factory;
import com.example.bajob.movieshatch.Mvp.TvShowsPresenterImp;
import com.example.bajob.movieshatch.Mvp.TvShowsPresenterImp_Factory;
import com.example.bajob.movieshatch.MvpDetail.DataDetailManager;
import com.example.bajob.movieshatch.MvpDetail.DataDetailManager_Factory;
import com.example.bajob.movieshatch.MvpDetail.DetailPresenter;
import com.example.bajob.movieshatch.MvpDetail.DetailPresenter_Factory;
import com.example.bajob.movieshatch.Retrofit.ApiService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.realm.Realm;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<ApiService> getApiServiceProvider;

  private Provider<Realm> getRealmProvider;

  private Provider<DataSourceManager> dataSourceManagerProvider;

  private Provider<TvShowsPresenterImp> tvShowsPresenterImpProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private Provider<DataDetailManager> dataDetailManagerProvider;

  private Provider<DetailPresenter> detailPresenterProvider;

  private MembersInjector<DetailActivity> detailActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getApiServiceProvider =
        new Factory<ApiService>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public ApiService get() {
            return Preconditions.checkNotNull(
                applicationComponent.getApiService(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.getRealmProvider =
        DoubleCheck.provider(ActivityModule_GetRealmFactory.create(builder.activityModule));

    this.dataSourceManagerProvider =
        DoubleCheck.provider(
            DataSourceManager_Factory.create(getApiServiceProvider, getRealmProvider));

    this.tvShowsPresenterImpProvider =
        TvShowsPresenterImp_Factory.create(dataSourceManagerProvider);

    this.mainActivityMembersInjector =
        MainActivity_MembersInjector.create(tvShowsPresenterImpProvider);

    this.dataDetailManagerProvider =
        DoubleCheck.provider(
            DataDetailManager_Factory.create(getApiServiceProvider, getRealmProvider));

    this.detailPresenterProvider = DetailPresenter_Factory.create(dataDetailManagerProvider);

    this.detailActivityMembersInjector =
        DetailActivity_MembersInjector.create(detailPresenterProvider);
  }

  @Override
  public void inject(MainActivity activity) {
    mainActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(DetailActivity activity) {
    detailActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        this.activityModule = new ActivityModule();
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
