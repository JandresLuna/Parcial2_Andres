package com.example.parcial2_andres.adaptadores;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2_andres.MainActivity3;
import com.example.parcial2_andres.R;
import com.example.parcial2_andres.clases.Personaje;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonajeAdaptador extends RecyclerView.Adapter<PersonajeAdaptador.ViewHolder> {

    private List<Personaje> datos;

    public PersonajeAdaptador(List<Personaje> datos) {
        this.datos = datos;
    }


    @NonNull
    @Override
    public PersonajeAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perfil, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeAdaptador.ViewHolder holder, int position) {
        Personaje dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre_personaje, estado_personaje, raza_personaje;
        ImageView foto_perfil;
        Button btn_mas_info;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre_personaje = itemView.findViewById(R.id.nombre_personaje);
            estado_personaje = itemView.findViewById(R.id.estado_personaje);
            raza_personaje = itemView.findViewById(R.id.raza_personaje);
            foto_perfil = itemView.findViewById(R.id.foto_perfil);
            btn_mas_info = itemView.findViewById(R.id.btn_mas_info);

        }

        public void bind(Personaje dato) {
            nombre_personaje.setText(dato.getNombre());
            estado_personaje.setText(dato.getEstado());

            cambiarColorEstado(estado_personaje, dato.getEstado());

            raza_personaje.setText(dato.getRaza());
            Picasso.get().load(dato.getImagen()).into(foto_perfil);



            btn_mas_info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle b = new Bundle();
                    Gson gson = new Gson();
                    b.putString("personaje", gson.toJson(dato));

                    Intent i = new Intent(itemView.getContext(), MainActivity3.class);
                    i.putExtras(b);

                    itemView.getContext().startActivity(i);
                }
            });
        }


        private void cambiarColorEstado(TextView estadoPersonaje, String estado) {
            int color;

            View itemView = estadoPersonaje.getRootView();

            switch (estado.toLowerCase()) {
                case "alive":
                    color = ContextCompat.getColor(itemView.getContext(), android.R.color.holo_green_dark);
                    break;
                case "dead":
                    color = ContextCompat.getColor(itemView.getContext(), android.R.color.holo_red_dark);
                    break;
                default:
                    color = ContextCompat.getColor(itemView.getContext(), android.R.color.darker_gray);
                    break;
            }


            estadoPersonaje.setTextColor(color);
        }


    }
}
