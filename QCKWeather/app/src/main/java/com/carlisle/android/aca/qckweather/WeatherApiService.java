package com.carlisle.android.aca.qckweather;


import com.carlisle.android.aca.qckweather.model.BaseWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chriscarlisle on 10/28/16.
 */

public interface WeatherApiService {
    @GET("data/2.5/weather?APPID=" + Configuration.OPEN_WEATHER_API_KEY + "&units=imperial")
    Call<BaseWeather> getWeather(@Query("q") String location);
}

