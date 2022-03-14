package com.proyecto.alexandrorodriguez.grownature;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity{

    private Button bRegis;
    private Button bIniSes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bRegis = findViewById(R.id.bRegis);
        bIniSes = findViewById(R.id.bIniSes);

        bRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        bIniSes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }


}