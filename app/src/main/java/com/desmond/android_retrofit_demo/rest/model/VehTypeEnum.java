package com.desmond.android_retrofit_demo.rest.model;

/**
 * Created by desmond on 13/9/15.
 */
public enum VehTypeEnum {

    UNKNOWN(0, "unknown"),
    CDUSEDCAR(1, "cdusedcar"),
    CDNEWCAR(2, "cdnewcar"),
    CMUSEDCAR(3, "cmusedcar"),
    CMNEWCAR(4, "cmnewcar");

    private final int    mValue;
    private final String mStatus;

    VehTypeEnum(final int value, final String status) {
        this.mValue = value;
        this.mStatus = status;
    }

    public int getValue() {
        return this.mValue;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public static VehTypeEnum getByValue(final int value) {
        final VehTypeEnum[] states = VehTypeEnum.values();
        final int size = states.length;
        for (int i = 0; i < size; i++) {
            if (states[i].getValue() == value) {
                return states[i];
            }
        }

        return UNKNOWN;
    }

    public static VehTypeEnum getByString(final String status) {
        final VehTypeEnum[] states = VehTypeEnum.values();
        final int size = states.length;
        for (int i = 0; i < size; i++) {
            if (states[i].getStatus().equalsIgnoreCase(status)) {
                return states[i];
            }
        }

        return UNKNOWN;
    }
}
