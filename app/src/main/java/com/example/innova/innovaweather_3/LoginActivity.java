package com.example.innova.innovaweather_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // --- Button - Ingresar ---
        Button btnIngresar = findViewById(R.id.btn_loginIn);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNavigationView();
            }
        });
    }

    /**
     * Método para pasar a Navigation Activity
     */
    private void showNavigationView(){
        startActivity(new Intent(this,NavigationActivity.class));
        finish();
    }
}
