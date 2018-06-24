package com.example.innova.innovaweather_3.ClassesAndInterfaces.DidStation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DidInterface {

    @GET("App_EstacionesxUsr")
    Call<DidJson> getDataDid(
            @Query("idUsr") String idUsr,
            @Query("passUsr") String passUsr
    );

}
