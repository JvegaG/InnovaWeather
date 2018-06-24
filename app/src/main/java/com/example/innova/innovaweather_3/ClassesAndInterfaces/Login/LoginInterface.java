package com.example.innova.innovaweather_3.ClassesAndInterfaces.Login;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LoginInterface {

    @GET("AppLogin")
    Call<User> getUser(
        @Query("email") String email,
        @Query("password") String password,
        @Header("Authorization") String authHeader
    );
}
