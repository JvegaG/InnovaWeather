package com.example.innova.innovaweather_3.ClassesAndInterfaces;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.innova.innovaweather_3.R;



public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView stationName, Location;
    public TextView senHum, senET, senRad, senUV, connection, lastUpdate;
    public TextView senTemp, tempUnit, timeError;
    public ImageView weather;


    public ViewHolder(View itemView) {
        super(itemView);

        stationName = itemView.findViewById(R.id.StationName);
        Location = itemView.findViewById(R.id.Location);
        senHum = itemView.findViewById(R.id.Sen_Hum);
        senET = itemView.findViewById(R.id.Sen_ET);
        senRad = itemView.findViewById(R.id.Sen_Rad);
        senUV = itemView.findViewById(R.id.Sen_UV);
        connection = itemView.findViewById(R.id.isOnlineOrOffline);
        lastUpdate = itemView.findViewById(R.id.lastUpdate);
        senTemp = itemView.findViewById(R.id.cardview_senTemp);
        tempUnit = itemView.findViewById(R.id.temp_unit);
        timeError = itemView.findViewById(R.id.time_error);
        weather = itemView.findViewById(R.id.img_weather);
    }
}
