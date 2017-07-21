package com.example.bajob.movieshatch.DependencyInjection;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.realm.Realm;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RealmModule_GetInstanceRealmUiFactory implements Factory<Realm> {
  private final RealmModule module;

  private final Provider<Application> applicationProvider;

  public RealmModule_GetInstanceRealmUiFactory(
      RealmModule module, Provider<Application> applicationProvider) {
    assert module != null;
    this.module = module;
    assert applicationProvider != null;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Realm get() {
    return Preconditions.checkNotNull(
        module.getInstanceRealmUi(applicationProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Realm> create(
      RealmModule module, Provider<Application> applicationProvider) {
    return new RealmModule_GetInstanceRealmUiFactory(module, applicationProvider);
  }
}
