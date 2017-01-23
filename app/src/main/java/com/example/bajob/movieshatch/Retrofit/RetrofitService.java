package com.example.bajob.movieshatch.Retrofit;

import com.example.bajob.movieshatch.BuildConfig;
import com.example.bajob.movieshatch.Pojo.RealmDouble;
import com.example.bajob.movieshatch.Pojo.RealmInteger;
import com.example.bajob.movieshatch.Pojo.RealmString;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;

import io.realm.RealmList;
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
 * Created by bajob on 1/18/2017.
 */

public class RetrofitService {
    private ApiService apiService;

    private Retrofit createRetrofit() {

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl httpUrl = request.url().newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY).build();
                        Request newRequest = request.newBuilder().url(httpUrl).build();
                        return chain.proceed(newRequest);
                    }
                });
        Type typeString = new TypeToken<RealmList<RealmString>>() {
        }.getType();
        Type typeInteger = new TypeToken<RealmList<RealmInteger>>() {
        }.getType();
        Type typeDouble = new TypeToken<RealmList<RealmDouble>>() {
        }.getType();
        GsonBuilder gsonBuilder = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getDeclaringClass().equals(RealmObject.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        })
                .registerTypeAdapter(typeString, new TypeAdapter<RealmList<RealmString>>() {

                    @Override
                    public void write(JsonWriter out, RealmList<RealmString> value) throws IOException {

                    }

                    @Override
                    public RealmList<RealmString> read(JsonReader in) throws IOException {
                        RealmList<RealmString> result = new RealmList<>();
                        in.beginArray();
                        while (in.hasNext()) {
                            RealmString val = new RealmString(in.nextString());
                            result.add(val);
                        }
                        in.endArray();
                        return result;
                    }
                }).registerTypeAdapter(typeInteger, new TypeAdapter<RealmList<RealmInteger>>() {
                    @Override
                    public void write(JsonWriter out, RealmList<RealmInteger> value) throws IOException {

                    }

                    @Override
                    public RealmList<RealmInteger> read(JsonReader in) throws IOException {
                        RealmList<RealmInteger> result = new RealmList<RealmInteger>();
                        in.beginArray();
                        while (in.hasNext()) {
                            RealmInteger val = new RealmInteger(in.nextInt());
                            result.add(val);
                        }
                        in.endArray();
                        return result;
                    }
                })
                .registerTypeAdapter(typeDouble, new TypeAdapter<RealmList<RealmDouble>>() {
                    @Override
                    public void write(JsonWriter out, RealmList<RealmDouble> value) throws IOException {

                    }

                    @Override
                    public RealmList<RealmDouble> read(JsonReader in) throws IOException {
                        RealmList<RealmDouble> result = new RealmList<RealmDouble>();
                        in.beginArray();
                        while (in.hasNext()) {
                            RealmDouble val = new RealmDouble(in.nextDouble());
                            result.add(val);
                        }
                        in.endArray();
                        return result;
                    }
                });


        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    public ApiService createApiService() {
        if (apiService == null) {
            apiService = createRetrofit().create(ApiService.class);
        }
        return apiService;
    }


}
