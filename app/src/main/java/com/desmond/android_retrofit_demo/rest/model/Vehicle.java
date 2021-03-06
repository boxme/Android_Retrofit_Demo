package com.desmond.android_retrofit_demo.rest.model;

import com.desmond.android_retrofit_demo.rest.utils.GsonUtils;

/**
 * Created by desmond on 13/9/15.
 */
public class Vehicle {
    private int cdUsedcarId;
    private int cmUsedcarId;
    private VehTypeEnum type;
    private String price;
    private String registrationDate;
    private String monthly;
    private String depreciation;
    private String created;
    private boolean isPremium;
    private String premiumExpiry;

    /* Setter */
    public void setCdUsedcarId(final int cdUsedcarId) {
        this.cdUsedcarId =  cdUsedcarId;
    }

    public void setCmUsedcarId(final int cmUsedcarId) {
        this.cmUsedcarId = cmUsedcarId;
    }

    public void setType(final VehTypeEnum type) {
        this.type = type;
    }

    public void setPrice(final String price) {
        this.price = price;
    }

    public void setRegistrationDate(final String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setMonthly(final String monthly) {
        this.monthly = monthly;
    }

    public void setDepreciation(final String depreciation) {
        this.depreciation = depreciation;
    }

    public void setCreated(final String created) {
        this.created = created;
    }

    public void setPremium(final boolean isPremium) {
        this.isPremium = isPremium;
    }

    public void setPremiumExpiry(final String premiumExpiry) {
        this.premiumExpiry = premiumExpiry;
    }

    /* Getter */
    public int getCdUsedcarId() { return this.cdUsedcarId; }
    public int getCmUsedcarId() { return this.cmUsedcarId; }
    public VehTypeEnum getType() { return this.type; }
    public String getPrice() { return this.price; }
    public String getRegistrationDate() { return this.registrationDate; }
    public String getMonthly() { return this.monthly; }
    public String getDepreciation() { return this.depreciation; }
    public String getCreated() { return this.created; }
    public boolean isPremium() { return this.isPremium; }
    public String getPremiumExpiry() { return this.premiumExpiry; }

    public String toJsonString() {
        return GsonUtils.getGson().toJson(this, Vehicle.class);
    }

    public static Vehicle fromJsonString(final String json) {
        return GsonUtils.getGson().fromJson(json, Vehicle.class);
    }
}
