package com.desmond.android_retrofit_demo.rest.utils.gson;

import com.desmond.android_retrofit_demo.rest.model.Vehicle;
import com.desmond.android_retrofit_demo.rest.model.VehicleList;
import com.desmond.android_retrofit_demo.rest.utils.DateTimeUtility;
import com.desmond.android_retrofit_demo.rest.utils.GsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by desmond on 13/9/15.
 */
public class VehicleListDeserializer implements JsonDeserializer<VehicleList> {

    public static final String TAG = VehicleListDeserializer.class.getSimpleName();

    @Override
    public VehicleList deserialize(JsonElement json, Type typeOfT,
                               JsonDeserializationContext context) throws JsonParseException {
        List<Vehicle> list = new ArrayList<>();
        JsonArray array = json.getAsJsonObject().getAsJsonArray("results");
        final Gson gson = GsonUtils.getGson();

        Vehicle vehicle;
        for (JsonElement jsonElement : array) {
            vehicle = gson.fromJson(jsonElement, Vehicle.class);
            vehicle.setRegistrationDate(DateTimeUtility.convertDate(vehicle.getRegistrationDate()));
            vehicle.setPremiumExpiry(DateTimeUtility.convertDate(vehicle.getPremiumExpiry()));
            vehicle.setCreated(DateTimeUtility.convertDate(vehicle.getCreated()));
            list.add(vehicle);
        }

        VehicleList vehicleList = new VehicleList();
        vehicleList.setTotal(json.getAsJsonObject().getAsJsonPrimitive("total").getAsInt());
        vehicleList.setVehicleList(list);

        return vehicleList;
    }
}
