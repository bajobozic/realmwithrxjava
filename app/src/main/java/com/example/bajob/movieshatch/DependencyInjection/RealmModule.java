package com.example.bajob.movieshatch.DependencyInjection;

import android.app.Application;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by bajob on 1/26/2017.
 */
@Module
public class RealmModule {

    @Singleton
    @Provides
    @Named("singletonRealm")
    public Realm getSingeltonRealmUi(Application application) {
        Realm.init(application);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        return Realm.getDefaultInstance();
    }

    @Provides
    @Named("instanceRealm")
    public Realm getInstanceRealmUi(Application application) {
        Realm.init(application);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        return Realm.getDefaultInstance();
    }
}
