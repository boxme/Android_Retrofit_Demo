package com.desmond.android_retrofit_demo.rest;

import com.desmond.android_retrofit_demo.rest.service.IVehicleAPI;

import retrofit.Retrofit;

/**
 * Created by desmond on 13/9/15.
 */
public class VehicleAPI {

    private final Retrofit mRetrofit = VehicleAPI.getRetroFit();
    private IVehicleAPI mService = this.mRetrofit.create(IVehicleAPI.class);

    private static Retrofit getRetroFit() {
        return new Retrofit.Builder()
                .baseUrl("http://marketplace.caarly.com/api/")
                .build();
    }
}
