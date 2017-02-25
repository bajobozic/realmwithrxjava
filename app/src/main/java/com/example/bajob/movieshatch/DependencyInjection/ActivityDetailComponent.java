package com.example.bajob.movieshatch.DependencyInjection;

import com.example.bajob.movieshatch.ActivityScoped;
import com.example.bajob.movieshatch.DetailActivity;
import com.example.bajob.movieshatch.MainActivity;

import dagger.Component;

/**
 * Created by bajob on 2/25/2017.
 */
@ActivityScoped
@Component(dependencies = ApplicationComponent.class)
public interface ActivityDetailComponent {
    void inject(DetailActivity activity);
}
