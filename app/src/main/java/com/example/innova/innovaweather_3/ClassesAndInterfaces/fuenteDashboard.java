package com.example.innova.innovaweather_3.ClassesAndInterfaces;

public class fuenteDashboard {

    private String StationName, Location;
    private String senHum, senUV, senRad, senET, senTemp;
    private String connection, lastUpdate, timeError;
    private int weather;

    public fuenteDashboard(String stationName, String location, String senHum,
                           String senUV, String senRad, String senET,
                           String senTemp, String connection, String lastUpdate,
                           String timeError, int weather) {
        StationName = stationName;
        Location = location;
        this.senHum = senHum;
        this.senUV = senUV;
        this.senRad = senRad;
        this.senET = senET;
        this.senTemp = senTemp;
        this.connection = connection;
        this.lastUpdate = lastUpdate;
        this.timeError = timeError;
        this.weather = weather;
    }

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getSenHum() {
        return senHum;
    }

    public void setSenHum(String senHum) {
        this.senHum = senHum;
    }

    public String getSenUV() {
        return senUV;
    }

    public void setSenUV(String senUV) {
        this.senUV = senUV;
    }

    public String getSenRad() {
        return senRad;
    }

    public void setSenRad(String senRad) {
        this.senRad = senRad;
    }

    public String getSenET() {
        return senET;
    }

    public void setSenET(String senET) {
        this.senET = senET;
    }

    public String getSenTemp() {
        return senTemp;
    }

    public void setSenTemp(String senTemp) {
        this.senTemp = senTemp;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getTimeError() {
        return timeError;
    }

    public void setTimeError(String timeError) {
        this.timeError = timeError;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }
}
