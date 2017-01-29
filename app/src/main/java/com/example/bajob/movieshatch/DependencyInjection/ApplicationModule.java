package com.example.bajob.movieshatch.DependencyInjection;

import android.app.Application;

import com.example.bajob.movieshatch.MoviesHatchApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by bajob on 1/26/2017.
 */
@Module
public class ApplicationModule {
    Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Application getApplication() {
        return application;
    }

    @Provides
    public Realm getRealmUi() {
        return Realm.getDefaultInstance();
    }
}
