package com.example.innova.innovaweather_3.ClassesAndInterfaces.DidStation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatosDidJson {

    @SerializedName("did")
    @Expose
    private String did;

    @SerializedName("alias")
    @Expose
    private String alias;
    
    @SerializedName("usuario_estacion")
    @Expose
    private String usuario_estacion;

    @SerializedName("pass_estacion")
    @Expose
    private String pass_estation;

    @SerializedName("tipo")
    @Expose
    private String tipo;

    public DatosDidJson(String did, String alias, String usuario_estacion, String pass_estation, String tipo) {
        this.did = did;
        this.alias = alias;
        this.usuario_estacion = usuario_estacion;
        this.pass_estation = pass_estation;
        this.tipo = tipo;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUsuario_estación() {
        return usuario_estacion;
    }

    public void setUsuario_estación(String usuario_estacion) {
        this.usuario_estacion = usuario_estacion;
    }

    public String getPass_estation() {
        return pass_estation;
    }

    public void setPass_estation(String pass_estation) {
        this.pass_estation = pass_estation;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
