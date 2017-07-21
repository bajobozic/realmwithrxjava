package com.example.bajob.movieshatch.DependencyInjection;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_GetGsonFactory implements Factory<Gson> {
  private final NetworkModule module;

  public NetworkModule_GetGsonFactory(NetworkModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Gson get() {
    return Preconditions.checkNotNull(
        module.getGson(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Gson> create(NetworkModule module) {
    return new NetworkModule_GetGsonFactory(module);
  }
}
