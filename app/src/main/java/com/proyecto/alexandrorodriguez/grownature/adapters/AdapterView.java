package com.proyecto.alexandrorodriguez.grownature.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.alexandrorodriguez.grownature.R;
import com.proyecto.alexandrorodriguez.grownature.model.PlantasArbustosArboles;

import java.util.ArrayList;

public class AdapterView extends RecyclerView.Adapter<AdapterView.AdapterViewHolder>{

    ArrayList<PlantasArbustosArboles> listaPAA;
    private OnItemClickVerListener listenerVer;

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
        holder.i_foto.setImageResource(listaPAA.get(position).getImagenPortada());
        holder.tv_Nombre.setText(listaPAA.get(position).getNombre());
        holder.tv_Descripcion.setText(listaPAA.get(position).getDescripcion());
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
        private CardView cv_fondo;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_Descripcion = itemView.findViewById(R.id.tv_Descripcion);
            tv_Nombre = itemView.findViewById(R.id.tv_Nombre);
            i_foto = itemView.findViewById(R.id.i_foto);
            cv_fondo = itemView.findViewById(R.id.cv_fondo);

            cv_fondo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listenerVer != null){
                        //si se pulsa en la tarjeta, le pasamos la nota. Podemos saber la posición del item en la lista
                        listenerVer.onItemVerClick(listaPAA.get(AdapterViewHolder.this.getBindingAdapterPosition()));

                    }
                }
            });
        }

    }

    //Interfaz para poder ejecutar el ImageView Editar al darle click
    public interface OnItemClickVerListener {
        void onItemVerClick(PlantasArbustosArboles paa);
    }
    public void setOnClickVerListener(OnItemClickVerListener listener) {
        this.listenerVer = listener;
    }

}
