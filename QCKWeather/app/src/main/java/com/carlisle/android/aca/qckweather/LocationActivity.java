package com.carlisle.android.aca.qckweather;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LocationActivity extends AppCompatActivity implements LocationListener{
    private LocationManager mLocationManager;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        // Initialize location services
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        provider = mLocationManager.getBestProvider(criteria, false);
        Location location = mLocationManager.getLastKnownLocation(provider);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLocationManager.requestLocationUpdates(provider, 500, 1, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLocationManager.removeUpdates(this);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
