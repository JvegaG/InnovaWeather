package com.example.innova.innovaweather_3.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.innova.innovaweather_3.Adapters.Adaptador;
import com.example.innova.innovaweather_3.ClassesAndInterfaces.DidStation.DidInterface;
import com.example.innova.innovaweather_3.ClassesAndInterfaces.fuenteDashboard;
import com.example.innova.innovaweather_3.DetalleActivity;
import com.example.innova.innovaweather_3.R;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DashboardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<fuenteDashboard> Lista;
    RecyclerView recyclerView;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista = inflater.inflate(R.layout.fragment_dashboard, container, false);

        Lista = new ArrayList<>();
        recyclerView = vista.findViewById(R.id.dashboardRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())) ;

        //Ejecutamos el metodo - contiene la lista de estaciones
        datosStation();

        Adaptador adaptador = new Adaptador(Lista);
        recyclerView.setAdapter(adaptador);

        //para que entre a la vista detalle

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DetalleActivity.class));
            }
        });

        return vista;
    }

    /**
     * Datos para mostrar en el dashboard
     */
    private void datosStation() {

        String url = "http://innovat.com.pe/InnovaWeather/api/";
        Retrofit DidBuilder = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DidInterface didInterface = DidBuilder.create(DidInterface.class);



        Lista.add(new fuenteDashboard("Innova-T","Trujillo, La Libertad","74.2",
                "1.6","230", "0.6","19","Online:","11 Jul 2018",
                "",R.drawable.weather_fog));
        Lista.add(new fuenteDashboard("Gloria","Olmos, Olmos","74.2",
                "1.6","230", "0.6","19","Online:","11 Jul 2018",
                "",R.drawable.weather_partlycloudy));
        Lista.add(new fuenteDashboard("Laredo","Laredo, La Libertad","74.2",
                "1.6","230", "0.6","19","Online:","11 Jul 2018",
                "",R.drawable.weather_pouring));
        Lista.add(new fuenteDashboard("ViruFruit","Virú, La Libertad","74.2",
                "1.6","230", "0.6","19","Online:","11 Jul 2018",
                "",R.drawable.weather_sunny));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
