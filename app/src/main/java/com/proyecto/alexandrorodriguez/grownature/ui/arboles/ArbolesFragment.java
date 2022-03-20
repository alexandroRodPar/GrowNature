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

import com.proyecto.alexandrorodriguez.grownature.databinding.FragmentArbolesBinding;


public class ArbolesFragment extends Fragment {

    private ArbolesViewModel arbolesViewModel;
    private FragmentArbolesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        arbolesViewModel =
                new ViewModelProvider(this).get(ArbolesViewModel.class);

        binding = FragmentArbolesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textArboles;
        arbolesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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