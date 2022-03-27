package com.proyecto.alexandrorodriguez.grownature.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.alexandrorodriguez.grownature.R;

import java.util.List;

public class AdapterView extends RecyclerView.Adapter<AdapterView.AdapterViewHolder>{




    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan_arbu_arb, parent, false);
        return new AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * Creamos la clase ViewHolder para hacer referencia a los objetos del RecyclerView
     */
    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        /**ATRIBUTOS**/


        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

        }


    }




}
