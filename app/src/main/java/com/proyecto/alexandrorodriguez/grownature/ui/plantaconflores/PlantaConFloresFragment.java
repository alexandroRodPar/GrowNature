package com.proyecto.alexandrorodriguez.grownature.ui.plantaconflores;

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
import com.proyecto.alexandrorodriguez.grownature.databinding.FragmentPlanconfloresBinding;
import com.proyecto.alexandrorodriguez.grownature.model.PlantasArbustosArboles;
import com.proyecto.alexandrorodriguez.grownature.ui.plantasinflores.PlantaSinFloresFragment;

import java.util.ArrayList;

public class PlantaConFloresFragment extends Fragment {

    private RecyclerView rv_conflores;
    private ArrayList<PlantasArbustosArboles> listaPAA;

    public PlantaConFloresFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_planconflores, container, false);
        listaPAA = new ArrayList<>();

        rv_conflores = vista.findViewById(R.id.rv_conflores);
        rv_conflores.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdapterView adapter = new AdapterView(listaPAA);
        rv_conflores.setAdapter(adapter);

        adapter.setOnClickVerListener(new AdapterView.OnItemClickVerListener() {
            @Override
            public void onItemVerClick(PlantasArbustosArboles paa) {
                verPlantasConFlores(paa);
            }

        });

        return vista;
    }

    private void verPlantasConFlores(PlantasArbustosArboles paa) {
        Intent i = new Intent(getContext(), CaracteristicasActivity.class);
        i.putExtra(PlantaSinFloresFragment.EXTRA_MAIN,paa);
        startActivity(i);
    }

    private void llenarLista() {
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_glicinia), getString(R.string.descripcion_glicinia), getString(R.string.plantacion_glicinia), getString(R.string.crecimiento_glicinia), getString(R.string.riego_glicinia), getString(R.string.clima_glicinia), getString(R.string.precio_glicinia), getString(R.string.donde_comprar_glicinia), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_rosas_negras), getString(R.string.descripcion_rosas_negras), getString(R.string.plantacion_rosas_negras), getString(R.string.crecimiento_rosas_negras), getString(R.string.riego_rosas_negras), getString(R.string.clima_rosas_negras), getString(R.string.precio_rosas_negras), getString(R.string.donde_comprar_rosas_negras), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_rosas_blancas), getString(R.string.descripcion_rosas_blancas), getString(R.string.plantacion_rosas_blancas), getString(R.string.crecimiento_rosas_blancas), getString(R.string.riego_rosas_blancas), getString(R.string.clima_rosas_blancas), getString(R.string.precio_rosas_blancas), getString(R.string.donde_comprar_rosas_blancas), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_aster), getString(R.string.descripcion_aster), getString(R.string.plantacion_aster), getString(R.string.crecimiento_aster), getString(R.string.riego_aster), getString(R.string.clima_aster), getString(R.string.precio_aster), getString(R.string.donde_comprar_aster), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_dalia), getString(R.string.descripcion_dalia), getString(R.string.plantacion_dalia), getString(R.string.crecimiento_dalia), getString(R.string.riego_dalia), getString(R.string.clima_dalia), getString(R.string.precio_dalia), getString(R.string.donde_comprar_dalia), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_astilbe), getString(R.string.descripcion_astilbe), getString(R.string.plantacion_astilbe), getString(R.string.crecimiento_astilbe), getString(R.string.riego_astilbe), getString(R.string.clima_astilbe), getString(R.string.precio_astilbe), getString(R.string.donde_comprar_astilbe), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_gazania), getString(R.string.descripcion_gazania), getString(R.string.plantacion_gazania), getString(R.string.crecimiento_gazania), getString(R.string.riego_gazania), getString(R.string.clima_gazania), getString(R.string.precio_gazania), getString(R.string.donde_comprar_gazania), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_corazon_sangrante), getString(R.string.descripcion_corazon_sangrante), getString(R.string.plantacion_corazon_sangrante), getString(R.string.crecimiento_corazon_sangrante), getString(R.string.riego_corazon_sangrante), getString(R.string.clima_corazon_sangrante), getString(R.string.precio_corazon_sangrante), getString(R.string.donde_comprar_corazon_sangrante), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_geranios), getString(R.string.descripcion_geranios), getString(R.string.plantacion_geranios), getString(R.string.crecimiento_geranios), getString(R.string.riego_geranios), getString(R.string.clima_geranios), getString(R.string.precio_geranios), getString(R.string.donde_comprar_geranios), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_petunias), getString(R.string.descripcion_petunias), getString(R.string.plantacion_petunias), getString(R.string.crecimiento_petunias), getString(R.string.riego_petunias), getString(R.string.clima_petunias), getString(R.string.precio_petunias), getString(R.string.donde_comprar_petunias), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_lirio_azul), getString(R.string.descripcion_lirio_azul), getString(R.string.plantacion_lirio_azul), getString(R.string.crecimiento_lirio_azul), getString(R.string.riego_lirio_azul), getString(R.string.clima_lirio_azul), getString(R.string.precio_lirio_azul), getString(R.string.donde_comprar_lirio_azul), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_clavel), getString(R.string.descripcion_clavel), getString(R.string.plantacion_clavel), getString(R.string.crecimiento_clavel), getString(R.string.riego_clavel), getString(R.string.clima_clavel), getString(R.string.precio_clavel), getString(R.string.donde_comprar_clavel), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_pensamiento), getString(R.string.descripcion_pensamiento), getString(R.string.plantacion_pensamiento), getString(R.string.crecimiento_pensamiento), getString(R.string.riego_pensamiento), getString(R.string.clima_pensamiento), getString(R.string.precio_pensamiento), getString(R.string.donde_comprar_pensamiento), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_crisantemo), getString(R.string.descripcion_crisantemo), getString(R.string.plantacion_crisantemo), getString(R.string.crecimiento_crisantemo), getString(R.string.riego_crisantemo), getString(R.string.clima_crisantemo), getString(R.string.precio_crisantemo), getString(R.string.donde_comprar_crisantemo), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_zinnia), getString(R.string.descripcion_zinnia), getString(R.string.plantacion_zinnia), getString(R.string.crecimiento_zinnia), getString(R.string.riego_zinnia), getString(R.string.clima_zinnia), getString(R.string.precio_zinnia), getString(R.string.donde_comprar_zinnia), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_girasol), getString(R.string.descripcion_girasol), getString(R.string.plantacion_girasol), getString(R.string.crecimiento_girasol), getString(R.string.riego_girasol), getString(R.string.clima_girasol), getString(R.string.precio_girasol), getString(R.string.donde_comprar_girasol), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_flor_de_porcelana), getString(R.string.descripcion_flor_de_porcelana), getString(R.string.plantacion_flor_de_porcelana), getString(R.string.crecimiento_flor_de_porcelana), getString(R.string.riego_flor_de_porcelana), getString(R.string.clima_flor_de_porcelana), getString(R.string.precio_flor_de_porcelana), getString(R.string.donde_comprar_flor_de_porcelana), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_pasiflora), getString(R.string.descripcion_pasiflora), getString(R.string.plantacion_pasiflora), getString(R.string.crecimiento_pasiflora), getString(R.string.riego_pasiflora), getString(R.string.clima_pasiflora), getString(R.string.precio_pasiflora), getString(R.string.donde_comprar_pasiflora), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_azucena), getString(R.string.descripcion_azucena), getString(R.string.plantacion_azucena), getString(R.string.crecimiento_azucena), getString(R.string.riego_azucena), getString(R.string.clima_azucena), getString(R.string.precio_azucena), getString(R.string.donde_comprar_azucena), 0, 0));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_flor_de_loto), getString(R.string.descripcion_flor_de_loto), getString(R.string.plantacion_flor_de_loto), getString(R.string.crecimiento_flor_de_loto), getString(R.string.riego_flor_de_loto), getString(R.string.clima_flor_de_loto), getString(R.string.precio_flor_de_loto), getString(R.string.donde_comprar_flor_de_loto), 0, 0));


    }
}