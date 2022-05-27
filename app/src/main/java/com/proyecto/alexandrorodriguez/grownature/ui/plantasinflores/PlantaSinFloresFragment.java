package com.proyecto.alexandrorodriguez.grownature.ui.plantasinflores;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.alexandrorodriguez.grownature.CaracteristicasActivity;
import com.proyecto.alexandrorodriguez.grownature.R;
import com.proyecto.alexandrorodriguez.grownature.adapters.AdapterView;
import com.proyecto.alexandrorodriguez.grownature.model.PlantasArbustosArboles;

import java.util.ArrayList;

public class PlantaSinFloresFragment extends Fragment {

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
        i.putExtra("objeto", (Parcelable) paa);
        startActivity(i);
    }

    private void llenarLista() {
        listaPAA.add(new PlantasArbustosArboles("Helechos", getString(R.string.descripcion_helecho), R.drawable.helechos));
        listaPAA.add(new PlantasArbustosArboles("Hiedra", "Esto es una breve descripción sobre la planta sin flor", R.drawable.helechos));
        listaPAA.add(new PlantasArbustosArboles("Bambú", "Esto es una breve descripción sobre la planta sin flor", R.drawable.helechos));
        listaPAA.add(new PlantasArbustosArboles("Adelfa Roja", "Esto es una breve descripción sobre la planta sin flor", R.drawable.helechos));
        listaPAA.add(new PlantasArbustosArboles("Agapanto", "Esto es una breve descripción sobre la planta sin flor", R.drawable.helechos));
        listaPAA.add(new PlantasArbustosArboles("Aralia de Japón", "Esto es una breve descripción sobre la planta sin flor", R.drawable.helechos));
    }
}