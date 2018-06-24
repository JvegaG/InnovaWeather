package com.example.innova.innovaweather_3.ClassesAndInterfaces.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("dni")
    @Expose
    private String dni;

    @SerializedName("empresa")
    @Expose
    private String empresa;

    @SerializedName("login")
    @Expose
    private boolean login;

    /**
     * No args constructor for use in serialization
     *
     */
    public Data() {
    }

    /**
     *
     * @param id
     * @param nombre
     * @param empresa
     * @param login
     * @param dni
     */
    public Data(String nombre, String id, String dni, String empresa, boolean login) {
        super();
        this.nombre = nombre;
        this.id = id;
        this.dni = dni;
        this.empresa = empresa;
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
