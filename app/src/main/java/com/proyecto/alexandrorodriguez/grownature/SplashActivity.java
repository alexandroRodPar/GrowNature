package com.proyecto.alexandrorodriguez.grownature;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bSalir;
    private Button bContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bSalir = findViewById(R.id.bSalir);
        bContinuar = findViewById(R.id.bContinuar);

        bSalir.setOnClickListener(this);
        bContinuar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bSalir:
                finish();
                break;
            case R.id.bContinuar:
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}