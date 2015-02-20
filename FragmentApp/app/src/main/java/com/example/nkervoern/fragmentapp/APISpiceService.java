package com.example.nkervoern.fragmentapp;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;

/**
 * Created by nkervoern on 19/02/15.
 */
public class APISpiceService extends RetrofitGsonSpiceService {
    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(API.class);
    }

    @Override
    protected String getServerUrl() {
        return " api.openweathermap.org/data/2.5";
    }
}
