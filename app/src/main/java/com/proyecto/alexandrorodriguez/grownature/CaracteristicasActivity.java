package com.proyecto.alexandrorodriguez.grownature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyecto.alexandrorodriguez.grownature.model.PlantasArbustosArboles;

public class CaracteristicasActivity extends AppCompatActivity {

    private ImageView iv_fotoPlanta;
    private TextView tv_tituloPlanta;
    private TextView tv_textDescPlanta;
    private TextView tv_textPlantacion;
    private TextView tv_textCrecimiento;
    private TextView tv_clima;
    private TextView tv_textRiego;
    private TextView tv_precioAprox;
    private TextView tv_lugaresComprar;
    private ImageView iv_ejemploImagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas);

        iv_fotoPlanta = findViewById(R.id.iv_fotoPlanta);
        tv_tituloPlanta = findViewById(R.id.tv_tituloPlanta);
        tv_textDescPlanta = findViewById(R.id.tv_textDescPlanta);
        tv_textPlantacion = findViewById(R.id.tv_textPlantacion);
        tv_textCrecimiento = findViewById(R.id.tv_textCrecimiento);
        tv_clima = findViewById(R.id.tv_clima);
        tv_textRiego = findViewById(R.id.tv_textRiego);
        tv_precioAprox = findViewById(R.id.tv_precioAprox);
        tv_lugaresComprar = findViewById(R.id.tv_lugaresComprar);
        iv_ejemploImagen = findViewById(R.id.iv_ejemploImagen);


        PlantasArbustosArboles paa = getIntent().getParcelableExtra("objeto");


    }
}