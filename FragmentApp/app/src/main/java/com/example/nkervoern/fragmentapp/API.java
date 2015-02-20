package com.example.nkervoern.fragmentapp;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by nkervoern on 19/02/15.
 */
public interface API {
    @GET("/weather")
    Response getLastMessage(@Query("q") String cityName);
}
