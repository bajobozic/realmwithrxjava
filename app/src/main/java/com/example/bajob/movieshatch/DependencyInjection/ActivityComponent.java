package com.example.bajob.movieshatch.DependencyInjection;

import com.example.bajob.movieshatch.ActivityScoped;
import com.example.bajob.movieshatch.DetailActivity;
import com.example.bajob.movieshatch.MainActivity;

import dagger.Component;

/**
 * Created by bajob on 3/2/2017.
 */
@ActivityScoped
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(DetailActivity activity);
    //in case that we need to expose to downstream component
    //we must also include not only provider from activity modul
    //but also providers that have constructor with @Inject annotations
    //DataDetailManager getDataDetailManager();
    // DataSourceManager getDataSourceManger();
    //XXXPresente getXXXPresenter(); etc.
}
