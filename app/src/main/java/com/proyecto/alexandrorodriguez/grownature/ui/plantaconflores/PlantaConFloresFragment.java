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

import com.proyecto.alexandrorodriguez.grownature.databinding.FragmentPlanconfloresBinding;

public class PlantaConFloresFragment extends Fragment {

    private PlantaConFloresViewModel plantaConFloresViewModel;
    private FragmentPlanconfloresBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        plantaConFloresViewModel =
                new ViewModelProvider(this).get(PlantaConFloresViewModel.class);

        binding = FragmentPlanconfloresBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPlanconflores;
        plantaConFloresViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}