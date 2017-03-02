package com.example.bajob.movieshatch.DependencyInjection;

import android.support.annotation.MainThread;

import com.example.bajob.movieshatch.ActivityScoped;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by bajob on 3/2/2017.
 */
@Module
public class ActivityModule {
    @ActivityScoped
    @Provides
    public Realm getRealm() {
        return Realm.getDefaultInstance();
    }
}
