package com.example.innova.innovaweather_3.ClassesAndInterfaces.DidStation;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DidStationRetrofit{


    private String url = "http://innovat.com.pe/InnovaWeather/api/";

    Retrofit DidsRetrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    DidInterface didInterface = DidsRetrofit.create(DidInterface.class);
    //Call<DidJson> didJsonCall = didInterface.getDataDid();
}
