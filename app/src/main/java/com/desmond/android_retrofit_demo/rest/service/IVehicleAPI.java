package com.desmond.android_retrofit_demo.rest.service;

import com.desmond.android_retrofit_demo.rest.model.VehicleList;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by desmond on 13/9/15.
 */
public interface IVehicleAPI {

    @GET("usedcar/combined")
    Call<VehicleList> getUsedVehicle(@Query("offset") int offset, @Query("limit") int limit, @Query("type") String type);
}
