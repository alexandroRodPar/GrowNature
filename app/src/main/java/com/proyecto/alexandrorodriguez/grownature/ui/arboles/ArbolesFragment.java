package com.proyecto.alexandrorodriguez.grownature.ui.arboles;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.alexandrorodriguez.grownature.CaracteristicasActivity;
import com.proyecto.alexandrorodriguez.grownature.R;
import com.proyecto.alexandrorodriguez.grownature.adapters.AdapterView;
import com.proyecto.alexandrorodriguez.grownature.databinding.FragmentArbolesBinding;
import com.proyecto.alexandrorodriguez.grownature.model.PlantasArbustosArboles;
import com.proyecto.alexandrorodriguez.grownature.ui.plantasinflores.PlantaSinFloresFragment;

import java.util.ArrayList;


public class ArbolesFragment extends Fragment {

    private RecyclerView rv_arboles;
    private ArrayList<PlantasArbustosArboles> listaPAA;

    public ArbolesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_arboles, container, false);
        listaPAA = new ArrayList<>();

        rv_arboles = vista.findViewById(R.id.rv_arboles);
        rv_arboles.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdapterView adapter = new AdapterView(listaPAA);
        rv_arboles.setAdapter(adapter);

        adapter.setOnClickVerListener(new AdapterView.OnItemClickVerListener() {
            @Override
            public void onItemVerClick(PlantasArbustosArboles paa) {
                verArboles(paa);
            }

        });

        return vista;
    }

    private void verArboles(PlantasArbustosArboles paa) {
        Intent i = new Intent(getContext(), CaracteristicasActivity.class);
        i.putExtra(PlantaSinFloresFragment.EXTRA_MAIN,paa);
        startActivity(i);
    }

    private void llenarLista() {
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_arce_japones), getString(R.string.descripcion_arce_japones), getString(R.string.plantacion_arce_japones), getString(R.string.crecimiento_arce_japones), getString(R.string.riego_arce_japones), getString(R.string.clima_arce_japones), getString(R.string.precio_arce_japones), getString(R.string.donde_comprar_arce_japones), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_altea_rosa_de_siria), getString(R.string.descripcion_altea_rosa_de_siria), getString(R.string.plantacion_altea_rosa_de_siria), getString(R.string.crecimiento_altea_rosa_de_siria), getString(R.string.riego_altea_rosa_de_siria), getString(R.string.clima_altea_rosa_de_siria), getString(R.string.precio_altea_rosa_de_siria), getString(R.string.donde_comprar_altea_rosa_de_siria), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_arbol_de_jupiter), getString(R.string.descripcion_arbol_de_jupiter), getString(R.string.plantacion_arbol_de_jupiter), getString(R.string.crecimiento_arbol_de_jupiter), getString(R.string.riego_arbol_de_jupiter), getString(R.string.clima_arbol_de_jupiter), getString(R.string.precio_arbol_de_jupiter), getString(R.string.donde_comprar_arbol_de_jupiter), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_syringa), getString(R.string.descripcion_syringa), getString(R.string.plantacion_syringa), getString(R.string.crecimiento_syringa), getString(R.string.riego_syringa), getString(R.string.clima_syringa), getString(R.string.precio_syringa), getString(R.string.donde_comprar_syringa), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_lagarstroemia_indica), getString(R.string.descripcion_lagarstroemia_indica), getString(R.string.plantacion_lagarstroemia_indica), getString(R.string.crecimiento_lagarstroemia_indica), getString(R.string.riego_lagarstroemia_indica), getString(R.string.clima_lagarstroemia_indica), getString(R.string.precio_lagarstroemia_indica), getString(R.string.donde_comprar_lagarstroemia_indica), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_rhus_typhina), getString(R.string.descripcion_rhus_typhina), getString(R.string.plantacion_rhus_typhina), getString(R.string.crecimiento_rhus_typhina), getString(R.string.riego_rhus_typhina), getString(R.string.clima_rhus_typhina), getString(R.string.precio_rhus_typhina), getString(R.string.donde_comprar_rhus_typhina), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_plumeria_rubra), getString(R.string.descripcion_plumeria_rubra), getString(R.string.plantacion_plumeria_rubra), getString(R.string.crecimiento_plumeria_rubra), getString(R.string.riego_plumeria_rubra), getString(R.string.clima_plumeria_rubra), getString(R.string.precio_plumeria_rubra), getString(R.string.donde_comprar_plumeria_rubra), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_tecoma_stans), getString(R.string.descripcion_tecoma_stans), getString(R.string.plantacion_tecoma_stans), getString(R.string.crecimiento_tecoma_stans), getString(R.string.riego_tecoma_stans), getString(R.string.clima_tecoma_stans), getString(R.string.precio_tecoma_stans), getString(R.string.donde_comprar_tecoma_stans), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_rubina_hispida), getString(R.string.descripcion_rubina_hispida), getString(R.string.plantacion_rubina_hispida), getString(R.string.crecimiento_rubina_hispida), getString(R.string.riego_rubina_hispida), getString(R.string.clima_rubina_hispida), getString(R.string.precio_rubina_hispida), getString(R.string.donde_comprar_rubina_hispida), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_acacia_baileyana), getString(R.string.descripcion_acacia_baileyana), getString(R.string.plantacion_acacia_baileyana), getString(R.string.crecimiento_acacia_baileyana), getString(R.string.riego_acacia_baileyana), getString(R.string.clima_acacia_baileyana), getString(R.string.precio_acacia_baileyana), getString(R.string.donde_comprar_acacia_baileyana), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_prunus_serrulata), getString(R.string.descripcion_prunus_serrulata), getString(R.string.plantacion_prunus_serrulata), getString(R.string.crecimiento_prunus_serrulata), getString(R.string.riego_prunus_serrulata), getString(R.string.clima_prunus_serrulata), getString(R.string.precio_prunus_serrulata), getString(R.string.donde_comprar_prunus_serrulata), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_bauhinia_variegata), getString(R.string.descripcion_bauhinia_variegata), getString(R.string.plantacion_bauhinia_variegata), getString(R.string.crecimiento_bauhinia_variegata), getString(R.string.riego_bauhinia_variegata), getString(R.string.clima_bauhinia_variegata), getString(R.string.precio_bauhinia_variegata), getString(R.string.donde_comprar_bauhinia_variegata), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_pino), getString(R.string.descripcion_pino), getString(R.string.plantacion_pino), getString(R.string.crecimiento_pino), getString(R.string.riego_pino), getString(R.string.clima_pino), getString(R.string.precio_pino), getString(R.string.donde_comprar_pino), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_laurel), getString(R.string.descripcion_laurel), getString(R.string.plantacion_laurel), getString(R.string.crecimiento_laurel), getString(R.string.riego_laurel), getString(R.string.clima_laurel), getString(R.string.precio_laurel), getString(R.string.donde_comprar_laurel), 0, 0));
    }
}