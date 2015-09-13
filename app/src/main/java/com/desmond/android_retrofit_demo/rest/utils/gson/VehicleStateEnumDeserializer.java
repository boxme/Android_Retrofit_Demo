package com.desmond.android_retrofit_demo.rest.utils.gson;

import com.desmond.android_retrofit_demo.rest.model.VehStatusEnum;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by desmond on 13/9/15.
 */
public class VehicleStateEnumDeserializer implements JsonDeserializer<VehStatusEnum> {

    @Override
    public VehStatusEnum deserialize(final JsonElement json, final Type typeOfT,
                                     final JsonDeserializationContext context) throws JsonParseException {
        try {
            final String type = json.getAsString();
            return VehStatusEnum.getByString(type);
        } catch (final ClassCastException e) {
            throw new JsonParseException("Unparseable VehStatusEnum: " + json.getAsString()
                    + " \nException: " + e.getMessage());
        } catch (final IllegalStateException e) {
            throw new JsonParseException("Unparseable VehStatusEnum: " + json.getAsString()
                    + "\nException: " + e.getMessage());
        }
    }
}
