package com.proyecto.alexandrorodriguez.grownature.ui.plantaconflores;

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

import com.proyecto.alexandrorodriguez.grownature.R;
import com.proyecto.alexandrorodriguez.grownature.adapters.AdapterView;
import com.proyecto.alexandrorodriguez.grownature.databinding.FragmentPlanconfloresBinding;
import com.proyecto.alexandrorodriguez.grownature.model.PlantasArbustosArboles;

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

        return vista;
    }

    private void llenarLista() {
        listaPAA.add(new PlantasArbustosArboles("Glicinia", "Esto es una breve descripción sobre la planta con flor", R.drawable.dalia));
        listaPAA.add(new PlantasArbustosArboles("Rosas Negras", "Esto es una breve descripción sobre la planta con flor", R.drawable.dalia));
        listaPAA.add(new PlantasArbustosArboles("Rosas Blancas", "Esto es una breve descripción sobre la planta con flor", R.drawable.dalia));
        listaPAA.add(new PlantasArbustosArboles("Dalia", "Esto es una breve descripción sobre la planta con flor", R.drawable.dalia));
        listaPAA.add(new PlantasArbustosArboles("Azalea", "Esto es una breve descripción sobre la planta con flor", R.drawable.dalia));
        listaPAA.add(new PlantasArbustosArboles("Astilbes", "Esto es una breve descripción sobre la planta con flor", R.drawable.dalia));
    }
}