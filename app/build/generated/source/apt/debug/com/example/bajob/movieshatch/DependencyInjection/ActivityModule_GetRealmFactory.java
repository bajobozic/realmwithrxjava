package com.example.bajob.movieshatch.DependencyInjection;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.realm.Realm;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_GetRealmFactory implements Factory<Realm> {
  private final ActivityModule module;

  public ActivityModule_GetRealmFactory(ActivityModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Realm get() {
    return Preconditions.checkNotNull(
        module.getRealm(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Realm> create(ActivityModule module) {
    return new ActivityModule_GetRealmFactory(module);
  }
}
