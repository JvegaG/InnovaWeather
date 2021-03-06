package com.example.innova.innovaweather_3;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.innova.innovaweather_3.Fragments.AboutUsFragment;
import com.example.innova.innovaweather_3.Fragments.DashboardFragment;
import com.example.innova.innovaweather_3.Fragments.MapFragment;
import com.example.innova.innovaweather_3.Fragments.ReportFragment;
import com.example.innova.innovaweather_3.Fragments.SettingFragment;
import com.example.innova.innovaweather_3.Fragments.SmartFilterFragment;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        DashboardFragment.OnFragmentInteractionListener,
        ReportFragment.OnFragmentInteractionListener,
        SmartFilterFragment.OnFragmentInteractionListener,
        MapFragment.OnFragmentInteractionListener,
        SettingFragment.OnFragmentInteractionListener,
        AboutUsFragment.OnFragmentInteractionListener{

    Fragment fragment = null;
    Toolbar toolbar;

    private TextView userNameHeader, emailheader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        // --- Toolbar ---
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // --- DrawnerLayout ---
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // --- NavigationView ---
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        userNameHeader = headerView.findViewById(R.id.userName);
        emailheader = headerView.findViewById(R.id.email_menu);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String nombre = bundle.getString("USERNAME");
            String correo = bundle.getString("EMAIL");
            userNameHeader.setText(nombre);
            emailheader.setText(correo);
        }
        navigationView.setNavigationItemSelectedListener(this);

        // --- Inicializamos con el Dashboard Fragment ---
        fragment = new DashboardFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.

        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.dashboard:
                fragment = new DashboardFragment();
                fragmentTransaction = true;
                break;
            case R.id.report:
                fragment = new ReportFragment();
                fragmentTransaction = true;
                break;
            case R.id.smartFilter:
                fragment = new SmartFilterFragment();
                fragmentTransaction = true;
                break;
            case R.id.mapLocation:
                fragment = new MapFragment();
                fragmentTransaction = true;
                break;
            case R.id.setting:
                fragment = new SettingFragment();
                fragmentTransaction = true;
                break;
            case R.id.aboutUs:
                fragment = new AboutUsFragment();
                fragmentTransaction = true;
                break;
            case R.id.logout:
                break;
        }

        if(fragmentTransaction){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contenedor, fragment).commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
