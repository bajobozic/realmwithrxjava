package com.example.bajob.movieshatch.DependencyInjection;

import android.text.TextUtils;

import com.example.bajob.movieshatch.BuildConfig;
import com.example.bajob.movieshatch.Retrofit.ApiService;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.RealmObject;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by bajob on 1/26/2017.
 */
@Module
public class NetworkModule {
    String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Singleton
    @Provides
    @Named("fullBody")
    public OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl httpUrl = request.url().newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY).build();
                        Request newRequest = request.newBuilder().url(httpUrl).build();
                        return chain.proceed(newRequest);
                    }
                }).build();
    }

    @Singleton
    @Provides
    @Named("noneBody")
    public OkHttpClient getNoneOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl httpUrl = request.url().newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY).build();
                        Request newRequest = request.newBuilder().url(httpUrl).build();
                        return chain.proceed(newRequest);
                    }
                }).build();
    }

    @Singleton
    @Provides
    public Gson getGson() {
        return new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getDeclaringClass().equals(RealmObject.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        }).registerTypeAdapter(String.class, new JsonDeserializer<String>() {
            @Override
            public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                String result = null;
                if (json.isJsonArray()) {
                    final JsonArray asJsonArray = json.getAsJsonArray();
                    List<String> list = new ArrayList<>();
                    Iterator<JsonElement> elementIterator = asJsonArray.iterator();
                    while (elementIterator.hasNext()) {
                        JsonElement element = elementIterator.next();
                        if (element.isJsonPrimitive()) {
                            if (element.getAsJsonPrimitive().isString()) {
                                final String asString = element.getAsString();
                                list.add(asString);
                            } else if (element.getAsJsonPrimitive().isNumber()) {
                                list.add(element.getAsNumber().toString());
                            }
                        } else if (element.isJsonObject()) {
                            return element.getAsString();
                        }
                    }
                    result = TextUtils.join(", ", list);
                } else {
                    result = json.getAsString();
                }
                return result;
            }
        }).create();
    }

    @Singleton
    @Provides
    public Retrofit getRetrofit(Gson gson, @Named("fullBody") OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    public ApiService getApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    //in case we nedd some of above provided element to not be sigleton
    //then just remove scope annotation and we get on every inject new instanc of that object
    /*
    @Provides
    public ApiService getApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }*/

}
