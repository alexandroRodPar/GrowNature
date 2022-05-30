package com.proyecto.alexandrorodriguez.grownature.ui.plantasinflores;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.alexandrorodriguez.grownature.CaracteristicasActivity;
import com.proyecto.alexandrorodriguez.grownature.R;
import com.proyecto.alexandrorodriguez.grownature.adapters.AdapterView;
import com.proyecto.alexandrorodriguez.grownature.model.PlantasArbustosArboles;

import java.io.Serializable;
import java.util.ArrayList;

public class PlantaSinFloresFragment extends Fragment   {

    //Constantes que nos ayudará a pasar los datos a otra actividad
    public final static String EXTRA_MAIN="GrowNatureApp.MainActivity.extra";

    private RecyclerView rv_sinflores;
    private ArrayList<PlantasArbustosArboles> listaPAA;

    public PlantaSinFloresFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_plansinflores, container, false);
        listaPAA = new ArrayList<>();

        rv_sinflores = vista.findViewById(R.id.rv_sinflores);
        rv_sinflores.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdapterView adapter = new AdapterView(listaPAA);
        rv_sinflores.setAdapter(adapter);

        adapter.setOnClickVerListener(new AdapterView.OnItemClickVerListener() {
            @Override
            public void onItemVerClick(PlantasArbustosArboles paa) {
                verPlantasSinFlores(paa);
            }

        });

        return vista;
    }

    /*ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                }
            });*/

    private void verPlantasSinFlores(PlantasArbustosArboles paa) {
        Intent i = new Intent(getContext(), CaracteristicasActivity.class);
        i.putExtra(EXTRA_MAIN,paa);
        startActivity(i);
        //mStartForResult.launch(i);
    }

    private void llenarLista() {
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_helecho), getString(R.string.descripcion_helecho), getString(R.string.plantacion_helecho), getString(R.string.crecimiento_helecho), getString(R.string.riego_helecho), getString(R.string.clima_helecho), getString(R.string.precio_helecho), getString(R.string.donde_comprar_helecho), R.drawable.helechos, R.drawable.ejemplo_helechos));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_helecho), getString(R.string.descripcion_helecho), getString(R.string.plantacion_helecho), getString(R.string.crecimiento_helecho), getString(R.string.riego_helecho), getString(R.string.clima_helecho), getString(R.string.precio_helecho), getString(R.string.donde_comprar_helecho), R.drawable.helechos, R.drawable.ejemplo_helechos));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_helecho), getString(R.string.descripcion_helecho), getString(R.string.plantacion_helecho), getString(R.string.crecimiento_helecho), getString(R.string.riego_helecho), getString(R.string.clima_helecho), getString(R.string.precio_helecho), getString(R.string.donde_comprar_helecho), R.drawable.helechos, R.drawable.ejemplo_helechos));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_helecho), getString(R.string.descripcion_helecho), getString(R.string.plantacion_helecho), getString(R.string.crecimiento_helecho), getString(R.string.riego_helecho), getString(R.string.clima_helecho), getString(R.string.precio_helecho), getString(R.string.donde_comprar_helecho), R.drawable.helechos, R.drawable.ejemplo_helechos));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_helecho), getString(R.string.descripcion_helecho), getString(R.string.plantacion_helecho), getString(R.string.crecimiento_helecho), getString(R.string.riego_helecho), getString(R.string.clima_helecho), getString(R.string.precio_helecho), getString(R.string.donde_comprar_helecho), R.drawable.helechos, R.drawable.ejemplo_helechos));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_helecho), getString(R.string.descripcion_helecho), getString(R.string.plantacion_helecho), getString(R.string.crecimiento_helecho), getString(R.string.riego_helecho), getString(R.string.clima_helecho), getString(R.string.precio_helecho), getString(R.string.donde_comprar_helecho), R.drawable.helechos, R.drawable.ejemplo_helechos));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_helecho), getString(R.string.descripcion_helecho), getString(R.string.plantacion_helecho), getString(R.string.crecimiento_helecho), getString(R.string.riego_helecho), getString(R.string.clima_helecho), getString(R.string.precio_helecho), getString(R.string.donde_comprar_helecho), R.drawable.helechos, R.drawable.ejemplo_helechos));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_helecho), getString(R.string.descripcion_helecho), getString(R.string.plantacion_helecho), getString(R.string.crecimiento_helecho), getString(R.string.riego_helecho), getString(R.string.clima_helecho), getString(R.string.precio_helecho), getString(R.string.donde_comprar_helecho), R.drawable.helechos, R.drawable.ejemplo_helechos));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_helecho), getString(R.string.descripcion_helecho), getString(R.string.plantacion_helecho), getString(R.string.crecimiento_helecho), getString(R.string.riego_helecho), getString(R.string.clima_helecho), getString(R.string.precio_helecho), getString(R.string.donde_comprar_helecho), R.drawable.helechos, R.drawable.ejemplo_helechos));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_helecho), getString(R.string.descripcion_helecho), getString(R.string.plantacion_helecho), getString(R.string.crecimiento_helecho), getString(R.string.riego_helecho), getString(R.string.clima_helecho), getString(R.string.precio_helecho), getString(R.string.donde_comprar_helecho), R.drawable.helechos, R.drawable.ejemplo_helechos));
    }
}
