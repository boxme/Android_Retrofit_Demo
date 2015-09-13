package com.desmond.android_retrofit_demo.rest.model;

/**
 * Created by desmond on 13/9/15.
 */
public enum VehStatusEnum {

    UNKNOWN(0, "unknown"),
    AVAILABLE(1, "available"),
    SOLD(2, "sold");

    private final int    mValue;
    private final String mStatus;

    VehStatusEnum(final int value, final String status) {
        this.mValue = value;
        this.mStatus = status;
    }

    public int getValue() {
        return this.mValue;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public static VehStatusEnum getByValue(final int value) {
        final VehStatusEnum[] states = VehStatusEnum.values();
        final int size = states.length;
        for (int i = 0; i < size; i++) {
            if (states[i].getValue() == value) {
                return states[i];
            }
        }

        return UNKNOWN;
    }

    public static VehStatusEnum getByString(final String status) {
        final VehStatusEnum[] states = VehStatusEnum.values();
        final int size = states.length;
        for (int i = 0; i < size; i++) {
            if (states[i].getStatus().equalsIgnoreCase(status)) {
                return states[i];
            }
        }

        return UNKNOWN;
    }
}
