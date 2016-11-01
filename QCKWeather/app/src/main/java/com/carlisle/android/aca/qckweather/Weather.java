package com.carlisle.android.aca.qckweather;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by chriscarlisle on 10/31/16.
 */

public class Weather implements Serializable{

    @SerializedName("display_location.full")
    private String mLocation;
    @SerializedName("temperature_string")
    private String mTemp;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("fellslike_string")
    private String mFeels;

    public String getFeels() {
        return mFeels;
    }

    public void setFeels(String feels) {
        mFeels = feels;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getTemp() {
        return mTemp;
    }

    public void setTemp(String temp) {
        mTemp = temp;
    }

    public String getIcon() {
        return WXUG_IMAGE_PATH + mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }
}
