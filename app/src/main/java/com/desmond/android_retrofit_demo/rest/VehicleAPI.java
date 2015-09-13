package com.desmond.android_retrofit_demo.rest;

import android.text.TextUtils;

import com.desmond.android_retrofit_demo.rest.model.Vehicle;
import com.desmond.android_retrofit_demo.rest.service.IVehicleAPI;
import com.desmond.android_retrofit_demo.rest.utils.GsonUtils;

import java.io.IOException;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
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
                .addConverterFactory(GsonConverterFactory.create(GsonUtils.getGson()))
                .build();
    }

    public void getUsedVeicle(final int offset, final int limit, final String type) {
        if (TextUtils.isEmpty(type)) {
            return;
        }

        this.mService.getUsedVehicle(offset, limit, type).enqueue(new Callback<Vehicle>() {
            @Override
            public void onResponse(Response<Vehicle> response) {

                // Check response code
                final int responseCode = response.code();
                if (responseCode != 200) {
                    try {
                        final String error = response.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }

                final Vehicle vehicle = response.body();
                if (vehicle == null) {
                    // Fetched response cannot be parsed to defined object
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }

        });
    }
}
