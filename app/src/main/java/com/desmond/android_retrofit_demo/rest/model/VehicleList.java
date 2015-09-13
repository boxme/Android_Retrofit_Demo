package com.desmond.android_retrofit_demo.rest.model;

import java.util.List;

/**
 * Created by desmond on 13/9/15.
 */
public class VehicleList {

    private int total;
    private List<Vehicle> vehicleList;

    public void setTotal(final int total) {
        this.total = total;
    }

    public void setVehicleList(final List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public int getTotal() {
        return this.total;
    }

    public List<Vehicle> getVehicleList() {
        return this.vehicleList;
    }
}
