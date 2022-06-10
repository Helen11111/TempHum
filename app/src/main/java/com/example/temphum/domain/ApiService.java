package com.example.temphum.domain;


import com.example.temphum.model.TempAnswer;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/getTemp")
    Observable<TempAnswer> getTemp();
}
