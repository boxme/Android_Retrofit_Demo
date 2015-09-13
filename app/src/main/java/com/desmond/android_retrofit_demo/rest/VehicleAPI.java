package com.desmond.android_retrofit_demo.rest;

import android.text.TextUtils;
import android.util.Log;

import com.desmond.android_retrofit_demo.rest.model.Vehicle;
import com.desmond.android_retrofit_demo.rest.model.VehicleList;
import com.desmond.android_retrofit_demo.rest.service.IVehicleAPI;
import com.desmond.android_retrofit_demo.rest.utils.GsonUtils;

import java.io.IOException;
import java.util.List;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by desmond on 13/9/15.
 */
public class VehicleAPI {

    public static final String TAG = VehicleAPI.class.getSimpleName();

    private static final Object obj = new Object();
    private static VehicleAPI sInstance;

    private final Retrofit mRetrofit = VehicleAPI.getRetroFit();
    private IVehicleAPI mService = this.mRetrofit.create(IVehicleAPI.class);

    private VehicleAPI() {}

    public static VehicleAPI getInstance() {
        if (sInstance == null) {
            synchronized (obj) {
                if (sInstance == null) {
                    sInstance = new VehicleAPI();
                }
            }
        }

        return sInstance;
    }

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

        this.mService.getUsedVehicle(offset, limit, type).enqueue(new Callback<VehicleList>() {
            @Override
            public void onResponse(Response<VehicleList> response) {
                // Check response code
                final int responseCode = response.code();
                if (responseCode != 200) {
                    try {
                        final String error = response.errorBody().string();
                        Log.d(TAG, "error: " + error + " code : " + responseCode);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }

                final VehicleList vehicles = response.body();
                if (vehicles == null) {
                    Log.d(TAG, "Fetched response cannot be parsed to the defined object");
                } else {
                    final List<Vehicle> vehicleList  = vehicles.getVehicleList();
                    if (vehicleList != null) {
                        for (Vehicle vehicle : vehicleList) {
                            Log.d(TAG, vehicle.toJsonString() + "\n");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, "Failure:\n"  + t.toString());
            }
        });
    }
}
