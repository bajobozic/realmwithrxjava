package com.example.bajob.movieshatch;

import android.app.Application;
import android.content.Context;

import com.example.bajob.movieshatch.DependencyInjection.ApplicationComponent;
import com.example.bajob.movieshatch.DependencyInjection.ApplicationModule;
import com.example.bajob.movieshatch.DependencyInjection.DaggerApplicationComponent;
import com.example.bajob.movieshatch.DependencyInjection.NetworkModule;
import com.example.bajob.movieshatch.DependencyInjection.RealmModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by bajob on 1/18/2017.
 */

public class MoviesHatchApp extends Application {
    private ApplicationComponent applicationComponent;

    public static RefWatcher getRefWatcher(Context context) {
        MoviesHatchApp application = (MoviesHatchApp) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        refWatcher = LeakCanary.install(this);
        //app code gose here
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(BuildConfig.BASE_URL))
                .realmModule(new RealmModule()).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
