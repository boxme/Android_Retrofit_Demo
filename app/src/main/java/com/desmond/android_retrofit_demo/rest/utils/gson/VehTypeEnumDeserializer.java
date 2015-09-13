package com.desmond.android_retrofit_demo.rest.utils.gson;

import android.util.Log;

import com.desmond.android_retrofit_demo.rest.model.VehTypeEnum;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by desmond on 13/9/15.
 */
public class VehTypeEnumDeserializer implements JsonDeserializer<VehTypeEnum> {

    public static final String TAG = VehTypeEnumDeserializer.class.getSimpleName();

    @Override
    public VehTypeEnum deserialize(JsonElement json, Type typeOfT,
                                   JsonDeserializationContext context) throws JsonParseException {
        try {
            final String type = json.getAsString();
            Log.d(TAG, type);
            return VehTypeEnum.getByString(type);
        } catch (final ClassCastException e) {
            throw new JsonParseException("Unparseable VehTypeEnum: " + json.getAsString()
                    + " \nException: " + e.getMessage());
        } catch (final IllegalStateException e) {
            throw new JsonParseException("Unparseable VehTypeEnum: " + json.getAsString()
                    + "\nException: " + e.getMessage());
        }
    }
}
