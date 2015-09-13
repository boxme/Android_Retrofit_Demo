package com.desmond.android_retrofit_demo.rest.utils;

import com.desmond.android_retrofit_demo.rest.model.VehStatusEnum;
import com.desmond.android_retrofit_demo.rest.model.VehTypeEnum;
import com.desmond.android_retrofit_demo.rest.model.VehicleList;
import com.desmond.android_retrofit_demo.rest.utils.gson.VehStateEnumDeserializer;
import com.desmond.android_retrofit_demo.rest.utils.gson.VehTypeEnumDeserializer;
import com.desmond.android_retrofit_demo.rest.utils.gson.VehicleDeserializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by desmond on 13/9/15.
 */
public class GsonUtils {
    private static final Gson GSON = new GsonBuilder()
            .serializeNulls()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(VehStatusEnum.class, new VehStateEnumDeserializer())
            .registerTypeAdapter(VehTypeEnum.class, new VehTypeEnumDeserializer())
            .registerTypeAdapter(VehicleList.class, new VehicleDeserializer())
            .create();


    private GsonUtils() {

    }

    public static Gson getGson() {
        return GsonUtils.GSON;
    }
}
