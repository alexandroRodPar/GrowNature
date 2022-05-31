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
    public final static String EXTRA_MAIN="GrowNatureApp.extra";

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

    private void verPlantasSinFlores(PlantasArbustosArboles paa) {
        Intent i = new Intent(getContext(), CaracteristicasActivity.class);
        i.putExtra(EXTRA_MAIN,paa);
        startActivity(i);
    }

    private void llenarLista() {
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_helecho), getString(R.string.descripcion_helecho), getString(R.string.plantacion_helecho), getString(R.string.crecimiento_helecho), getString(R.string.riego_helecho), getString(R.string.clima_helecho), getString(R.string.precio_helecho), getString(R.string.donde_comprar_helecho), R.drawable.helechos, R.drawable.ejemplo_helechos));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_hiedra), getString(R.string.descripcion_hiedra), getString(R.string.plantacion_hiedra), getString(R.string.crecimiento_hiedra), getString(R.string.riego_hiedra), getString(R.string.clima_hiedra), getString(R.string.precio_hiedra), getString(R.string.donde_comprar_hiedra), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_bambu), getString(R.string.descripcion_bambu), getString(R.string.plantacion_bambu), getString(R.string.crecimiento_bambu), getString(R.string.riego_bambu), getString(R.string.clima_bambu), getString(R.string.precio_bambu), getString(R.string.donde_comprar_bambu), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_agapanto), getString(R.string.descripcion_agapanto), getString(R.string.plantacion_agapanto), getString(R.string.crecimiento_agapanto), getString(R.string.riego_agapanto), getString(R.string.clima_agapanto), getString(R.string.precio_agapanto), getString(R.string.donde_comprar_agapanto), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_lamium_maculatum_mix), getString(R.string.descripcion_lamium_maculatum_mix), getString(R.string.plantacion_lamium_maculatum_mix), getString(R.string.crecimiento_lamium_maculatum_mix), getString(R.string.riego_lamium_maculatum_mix), getString(R.string.clima_lamium_maculatum_mix), getString(R.string.precio_lamium_maculatum_mix), getString(R.string.donde_comprar_lamium_maculatum_mix), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_peperomia), getString(R.string.descripcion_peperomia), getString(R.string.plantacion_peperomia), getString(R.string.crecimiento_peperomia), getString(R.string.riego_peperomia), getString(R.string.clima_peperomia), getString(R.string.precio_peperomia), getString(R.string.donde_comprar_peperomia), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_alocasia), getString(R.string.descripcion_alocasia), getString(R.string.plantacion_alocasia), getString(R.string.crecimiento_alocasia), getString(R.string.riego_alocasia), getString(R.string.clima_alocasia), getString(R.string.precio_alocasia), getString(R.string.donde_comprar_alocasia), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_coleo), getString(R.string.descripcion_coleo), getString(R.string.plantacion_coleo), getString(R.string.crecimiento_coleo), getString(R.string.riego_coleo), getString(R.string.clima_coleo), getString(R.string.precio_coleo), getString(R.string.donde_comprar_coleo), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_fitonia), getString(R.string.descripcion_fitonia), getString(R.string.plantacion_fitonia), getString(R.string.crecimiento_fitonia), getString(R.string.riego_fitonia), getString(R.string.clima_fitonia), getString(R.string.precio_fitonia), getString(R.string.donde_comprar_fitonia), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_kentia), getString(R.string.descripcion_kentia), getString(R.string.plantacion_kentia), getString(R.string.crecimiento_kentia), getString(R.string.riego_kentia), getString(R.string.clima_kentia), getString(R.string.precio_kentia), getString(R.string.donde_comprar_kentia), 0, 0));
    }
}
