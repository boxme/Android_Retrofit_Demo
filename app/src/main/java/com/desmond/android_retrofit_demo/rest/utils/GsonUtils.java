package com.desmond.android_retrofit_demo.rest.utils;

import com.desmond.android_retrofit_demo.rest.utils.gson.VehicleStateEnumDeserializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by desmond on 13/9/15.
 */
public class GsonUtils {
    private static final Gson GSON = new GsonBuilder()
            .serializeNulls()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(VehicleStateEnumDeserializer.class, new VehicleStateEnumDeserializer())
            .create();


    private GsonUtils() {

    }

    public static Gson getGson() {
        return GsonUtils.GSON;
    }
}
