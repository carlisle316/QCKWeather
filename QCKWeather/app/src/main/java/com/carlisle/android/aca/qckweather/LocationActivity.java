package com.carlisle.android.aca.qckweather;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LocationActivity extends AppCompatActivity implements LocationListener{
    private LocationManager mLocationManager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        // Initialize location services
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }
}
