package com.proyecto.alexandrorodriguez.grownature.ui.arboles;

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
import com.proyecto.alexandrorodriguez.grownature.databinding.FragmentArbolesBinding;
import com.proyecto.alexandrorodriguez.grownature.model.PlantasArbustosArboles;

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

        return vista;
    }

    private void llenarLista() {
        listaPAA.add(new PlantasArbustosArboles("Helechos", "Es una planta, con terreno húmedo fffffffffffffffffffffffffffffffffffffffffffffffffffffffff", R.drawable.helechos));
        listaPAA.add(new PlantasArbustosArboles("Hiedra", "Es una planta, que necesita humedad fffffffffffffffffffffffffffff", R.drawable.helechos));
        listaPAA.add(new PlantasArbustosArboles("MAnzano", "Es una planta, que necesita calidez ffffffffffffffffffffff", R.drawable.helechos));
    }
}