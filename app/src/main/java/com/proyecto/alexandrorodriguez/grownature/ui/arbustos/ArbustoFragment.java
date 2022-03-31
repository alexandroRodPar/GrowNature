package com.proyecto.alexandrorodriguez.grownature.ui.arbustos;

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
import com.proyecto.alexandrorodriguez.grownature.databinding.FragmentArbustoBinding;
import com.proyecto.alexandrorodriguez.grownature.model.PlantasArbustosArboles;

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

        return vista;
    }


    private void llenarLista() {
        listaPAA.add(new PlantasArbustosArboles("Galan de noche", "Esto es una breve descripción sobre el arbusto", R.drawable.fotinia));
        listaPAA.add(new PlantasArbustosArboles("Fotinia", "Esto es una breve descripción sobre el arbusto", R.drawable.fotinia));
        listaPAA.add(new PlantasArbustosArboles("Acebo (ilex Aquifolium)", "Esto es una breve descripción sobre el arbusto", R.drawable.fotinia));
        listaPAA.add(new PlantasArbustosArboles("Andrómeda Japonesa (Pieris Japonica)", "Esto es una breve descripción sobre el arbusto", R.drawable.fotinia));
        listaPAA.add(new PlantasArbustosArboles("Berberis Thunbergil Green Carpet", "Esto es una breve descripción sobre el arbusto", R.drawable.fotinia));
        listaPAA.add(new PlantasArbustosArboles("Berberis Thunbergil Admiration", "Esto es una breve descripción sobre el arbusto", R.drawable.fotinia));
    }
}