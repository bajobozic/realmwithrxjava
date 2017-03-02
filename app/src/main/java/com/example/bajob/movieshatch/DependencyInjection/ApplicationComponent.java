package com.example.bajob.movieshatch.DependencyInjection;

import android.app.Application;

import com.example.bajob.movieshatch.MoviesHatchApp;
import com.example.bajob.movieshatch.Retrofit.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by bajob on 1/26/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    void inject(MoviesHatchApp app);

    //expose class that we will be using in downstreame
    //components
    Application getApplication();

    ApiService getApiService();

}
