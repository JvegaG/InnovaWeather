package com.example.innova.innovaweather_3.ClassesAndInterfaces.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {
    @SerializedName("Data")
    @Expose
    private Data data;

    @SerializedName("error")
    @Expose
    private String error;

    public User(Data data, String error) {
        this.data = data;
        this.error = error;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
