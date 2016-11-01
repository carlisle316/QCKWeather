package com.carlisle.android.aca.qckweather;

import android.telecom.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chriscarlisle on 10/28/16.
 */

public interface WeatherApiService {
    @GET("data/2.5/weather?APPID=" + Config.OPEN_WEATHER_API_KEY)
    Call<Weather> getWeather(@Query("q") String location);

