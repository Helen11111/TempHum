package com.example.temphum.domain;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

import com.example.temphum.model.TempAnswer;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TemperatureRepository {

    private final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

    private final ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://185.84.34.222:8092")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor.setLevel(BODY))
                    .build()
            )
            .build()
            .create(ApiService.class);

    public Observable<TempAnswer> getTemperature() {
        return apiService.getTemp();
    }
}
