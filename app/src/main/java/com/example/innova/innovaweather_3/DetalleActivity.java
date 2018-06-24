package com.example.innova.innovaweather_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class DetalleActivity extends AppCompatActivity {

    ImageView windAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        //| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION   //hide Navigation Bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN    //hide status Bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        windAnim = findViewById(R.id.wind_anim);
        rotation();

    }

    public void rotation(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotacion);
        animation.setFillAfter(true);
        windAnim.startAnimation(animation);
    }
}
