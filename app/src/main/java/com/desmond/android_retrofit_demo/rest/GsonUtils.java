package com.desmond.android_retrofit_demo.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by desmond on 13/9/15.
 */
public class GsonUtils {
    private static final Gson GSON = new GsonBuilder().create();

    private GsonUtils() {

    }

    public static Gson getGson() {
        return GsonUtils.GSON;
    }
}
