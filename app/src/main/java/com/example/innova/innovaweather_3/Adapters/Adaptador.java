package com.example.innova.innovaweather_3.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.innova.innovaweather_3.ClassesAndInterfaces.ViewHolder;
import com.example.innova.innovaweather_3.ClassesAndInterfaces.fuenteDashboard;
import com.example.innova.innovaweather_3.R;

import java.util.List;


public class Adaptador extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {

    private List<fuenteDashboard> ListaObjeto;
    private View.OnClickListener listener;

    public Adaptador(List<fuenteDashboard> listaObjeto) {
        ListaObjeto = listaObjeto;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_dashboard, parent,false);
        vista.setOnClickListener(this);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.stationName.setText(ListaObjeto.get(position).getStationName());
        holder.Location.setText(ListaObjeto.get(position).getLocation());
        holder.senHum.setText(ListaObjeto.get(position).getSenHum());
        holder.senRad.setText(ListaObjeto.get(position).getSenRad());
        holder.senET.setText(ListaObjeto.get(position).getSenET());
        holder.senUV.setText(ListaObjeto.get(position).getSenUV());
        holder.connection.setText(ListaObjeto.get(position).getConnection());
        holder.lastUpdate.setText(ListaObjeto.get(position).getLastUpdate());
        holder.timeError.setText(ListaObjeto.get(position).getTimeError());
        holder.weather.setImageResource(ListaObjeto.get(position).getWeather());
    }

    public void setOnClickListener (View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return ListaObjeto.size();
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }
}
