package com.example.bajob.movieshatch.Retrofit;

import com.example.bajob.movieshatch.Pojo.ImageConfiguration;
import com.example.bajob.movieshatch.Pojo.MovieDetailedInfo;
import com.example.bajob.movieshatch.Pojo.TopRatedMovies;
import com.example.bajob.movieshatch.Pojo.TopRatedTvShows;
import com.example.bajob.movieshatch.Pojo.TvShowDetailedInfo;
import com.example.bajob.movieshatch.Pojo.TvShowInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bajob on 1/18/2017.
 */

public interface ApiService {
    @GET("tv/top_rated")
    Observable<TopRatedTvShows> getTopRateedTvShows(@Query("language") String language, @Query("page") Integer page);
    //language=en-US&page=1

    @GET("tv/tv_id")
    Observable<TvShowDetailedInfo> getTvShowDetailedInfo(@Path("tv_id") String tvId, @Query("language") String language, @Query("append_to_response") String appendToRersponse);

    @GET("movie/top_rated")
    Observable<TopRatedMovies> getTopRateedMovies(@Query("language") String language, @Query("page") String page, @Query("regjion") String region);
    //language=en-US&page=1&region=

    @GET("movie/{movie_id}")
    Observable<MovieDetailedInfo> getMovieDetaildInfo(@Path("movie_id") Integer movieId, @Query("language") String language, @Query("append_to_response") String appendToRersponse);

    @GET("configuration")
    Observable<ImageConfiguration> getImageConfiguration();

}
