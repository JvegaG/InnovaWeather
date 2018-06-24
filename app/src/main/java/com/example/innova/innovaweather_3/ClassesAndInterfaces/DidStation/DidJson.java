package com.example.innova.innovaweather_3.ClassesAndInterfaces.DidStation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DidJson {

    @SerializedName("Data")
    @Expose
    private ArrayList<DatosDidJson> datos;

    @SerializedName("error")
    @Expose
    private String error;

    public DidJson(ArrayList<DatosDidJson> datos, String error) {
        this.datos = datos;
        this.error = error;
    }

    public ArrayList<DatosDidJson> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<DatosDidJson> datos) {
        this.datos = datos;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
