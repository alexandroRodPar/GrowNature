package com.proyecto.alexandrorodriguez.grownature.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.alexandrorodriguez.grownature.R;
import com.proyecto.alexandrorodriguez.grownature.model.PlantasArbustosArboles;

import java.util.ArrayList;
import java.util.List;

public class AdapterView extends RecyclerView.Adapter<AdapterView.AdapterViewHolder>{

    ArrayList<PlantasArbustosArboles> listaPAA;

    public AdapterView(ArrayList<PlantasArbustosArboles> listaPAA) {
        this.listaPAA = listaPAA;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plan_arbu_arb, parent, false);
        return new AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.i_foto.setImageResource(listaPAA.get(position).getImagen());
        holder.tv_Nombre.setText(listaPAA.get(position).getNombre());
        holder.tv_Descripcion.setText(listaPAA.get(position).getBreveDescripcion());
    }

    @Override
    public int getItemCount() {
        return listaPAA.size();
    }

    /**
     * Creamos la clase ViewHolder para hacer referencia a los objetos del RecyclerView
     */
    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        /**ATRIBUTOS**/
        private TextView tv_Descripcion;
        private TextView tv_Nombre;
        private ImageView i_foto;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_Descripcion = itemView.findViewById(R.id.tv_Descripcion);
            tv_Nombre = itemView.findViewById(R.id.tv_Nombre);
            i_foto = itemView.findViewById(R.id.i_foto);
        }


    }




}
