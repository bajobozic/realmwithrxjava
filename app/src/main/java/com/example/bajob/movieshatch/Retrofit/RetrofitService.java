package com.example.bajob.movieshatch.Retrofit;

import android.text.TextUtils;

import com.example.bajob.movieshatch.BuildConfig;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
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

        GsonBuilder gsonBuilder = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getDeclaringClass().equals(RealmObject.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        }).registerTypeAdapter(String.class, new PrimitiveListDeserializer());


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

    private static final class PrimitiveListDeserializer implements JsonDeserializer<String> {
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
    }


}
