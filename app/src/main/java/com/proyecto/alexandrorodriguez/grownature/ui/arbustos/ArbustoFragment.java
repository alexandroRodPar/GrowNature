package com.proyecto.alexandrorodriguez.grownature.ui.arbustos;

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
import com.proyecto.alexandrorodriguez.grownature.databinding.FragmentArbustoBinding;
import com.proyecto.alexandrorodriguez.grownature.model.PlantasArbustosArboles;
import com.proyecto.alexandrorodriguez.grownature.ui.plantasinflores.PlantaSinFloresFragment;

import java.util.ArrayList;

public class ArbustoFragment extends Fragment {

    private RecyclerView rv_arbusto;
    private ArrayList<PlantasArbustosArboles> listaPAA;

    public ArbustoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_arbusto, container, false);
        listaPAA = new ArrayList<>();

        rv_arbusto = vista.findViewById(R.id.rv_arbusto);
        rv_arbusto.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        AdapterView adapter = new AdapterView(listaPAA);
        rv_arbusto.setAdapter(adapter);

        adapter.setOnClickVerListener(new AdapterView.OnItemClickVerListener() {
            @Override
            public void onItemVerClick(PlantasArbustosArboles paa) {
                verArbustos(paa);
            }

        });

        return vista;
    }

    private void verArbustos(PlantasArbustosArboles paa) {
        Intent i = new Intent(getContext(), CaracteristicasActivity.class);
        i.putExtra(PlantaSinFloresFragment.EXTRA_MAIN,paa);
        startActivity(i);
    }


    private void llenarLista() {
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_galan_de_noche), getString(R.string.descripcion_galan_de_noche), getString(R.string.plantacion_galan_de_noche), getString(R.string.crecimiento_galan_de_noche), getString(R.string.riego_galan_de_noche), getString(R.string.clima_galan_de_noche), getString(R.string.precio_galan_de_noche), getString(R.string.donde_comprar_galan_de_noche), R.drawable.galan_de_noche_principal, R.drawable.galan_de_noche_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_photinia), getString(R.string.descripcion_photinia), getString(R.string.plantacion_photinia), getString(R.string.crecimiento_photinia), getString(R.string.riego_photinia), getString(R.string.clima_photinia), getString(R.string.precio_photinia), getString(R.string.donde_comprar_photinia), R.drawable.fotinia_principal, R.drawable.fotinia_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_acebo), getString(R.string.descripcion_acebo), getString(R.string.plantacion_acebo), getString(R.string.crecimiento_acebo), getString(R.string.riego_acebo), getString(R.string.clima_acebo), getString(R.string.precio_acebo), getString(R.string.donde_comprar_acebo), R.drawable.acebo_principal, R.drawable.acebo_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_andromeda_japonesa), getString(R.string.descripcion_andromeda_japonesa), getString(R.string.plantacion_andromeda_japonesa), getString(R.string.crecimiento_andromeda_japonesa), getString(R.string.riego_andromeda_japonesa), getString(R.string.clima_andromeda_japonesa), getString(R.string.precio_andromeda_japonesa), getString(R.string.donde_comprar_andromeda_japonesa), R.drawable.andromeda_japonesa_principal, R.drawable.andromeda_japonesa_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_berberis_thunbergii), getString(R.string.descripcion_berberis_thunbergii), getString(R.string.plantacion_berberis_thunbergii), getString(R.string.crecimiento_berberis_thunbergii), getString(R.string.riego_berberis_thunbergii), getString(R.string.clima_berberis_thunbergii), getString(R.string.precio_berberis_thunbergii), getString(R.string.donde_comprar_berberis_thunbergii), R.drawable.berberis_principal, R.drawable.berberis_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_bog), getString(R.string.descripcion_bog), getString(R.string.plantacion_bog), getString(R.string.crecimiento_bog), getString(R.string.riego_bog), getString(R.string.clima_bog), getString(R.string.precio_bog), getString(R.string.donde_comprar_bog), R.drawable.boj_principal, R.drawable.boj_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_bola_de_nieve), getString(R.string.descripcion_bola_de_nieve), getString(R.string.plantacion_bola_de_nieve), getString(R.string.crecimiento_bola_de_nieve), getString(R.string.riego_bola_de_nieve), getString(R.string.clima_bola_de_nieve), getString(R.string.precio_bola_de_nieve), getString(R.string.donde_comprar_bola_de_nieve), R.drawable.bola_de_nieve_principal, R.drawable.bola_de_nieve_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_ceanothus_puget_blue), getString(R.string.descripcion_ceanothus_puget_blue), getString(R.string.plantacion_ceanothus_puget_blue), getString(R.string.crecimiento_ceanothus_puget_blue), getString(R.string.riego_ceanothus_puget_blue), getString(R.string.clima_ceanothus_puget_blue), getString(R.string.precio_ceanothus_puget_blue), getString(R.string.donde_comprar_ceanothus_puget_blue), R.drawable.ceanothus_principal, R.drawable.ceanothus_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_forysthia), getString(R.string.descripcion_forysthia), getString(R.string.plantacion_forysthia), getString(R.string.crecimiento_forysthia), getString(R.string.riego_forysthia), getString(R.string.clima_forysthia), getString(R.string.precio_forysthia), getString(R.string.donde_comprar_forysthia), R.drawable.forsitia_principal, R.drawable.forsitia_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_hebe_veronica), getString(R.string.descripcion_hebe_veronica), getString(R.string.plantacion_hebe_veronica), getString(R.string.crecimiento_hebe_veronica), getString(R.string.riego_hebe_veronica), getString(R.string.clima_hebe_veronica), getString(R.string.precio_hebe_veronica), getString(R.string.donde_comprar_hebe_veronica), R.drawable.hebe_veronica_principal, R.drawable.hebe_veronica_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_aloe_vera), getString(R.string.descripcion_aloe_vera), getString(R.string.plantacion_aloe_vera), getString(R.string.crecimiento_aloe_vera), getString(R.string.riego_aloe_vera), getString(R.string.clima_aloe_vera), getString(R.string.precio_aloe_vera), getString(R.string.donde_comprar_aloe_vera), R.drawable.aloe_vera_principal, R.drawable.aloe_vera_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_viburno), getString(R.string.descripcion_viburno), getString(R.string.plantacion_viburno), getString(R.string.crecimiento_viburno), getString(R.string.riego_viburno), getString(R.string.clima_viburno), getString(R.string.precio_viburno), getString(R.string.donde_comprar_viburno), R.drawable.viburnum_principal, R.drawable.viburnum_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_buganvilla), getString(R.string.descripcion_buganvilla), getString(R.string.plantacion_buganvilla), getString(R.string.crecimiento_buganvilla), getString(R.string.riego_buganvilla), getString(R.string.clima_buganvilla), getString(R.string.precio_buganvilla), getString(R.string.donde_comprar_buganvilla), R.drawable.buganvilla_principal, R.drawable.buganvilla_ejemplo));
        listaPAA.add(new PlantasArbustosArboles(getString(R.string.nombre_aralia_de_japon), getString(R.string.descripcion_aralia_de_japon), getString(R.string.plantacion_aralia_de_japon), getString(R.string.crecimiento_aralia_de_japon), getString(R.string.riego_aralia_de_japon), getString(R.string.clima_aralia_de_japon), getString(R.string.precio_aralia_de_japon), getString(R.string.donde_comprar_aralia_de_japon), R.drawable.aralia_de_japon_principal, R.drawable.aralia_de_japon_ejemplo));
    }
}