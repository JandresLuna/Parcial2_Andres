package com.example.parcial2_andres;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2_andres.adaptadores.PersonajeAdaptador;
import com.example.parcial2_andres.clases.Personaje;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    Button btn_mas_info;
    RecyclerView rcv_personaje;
    List<Personaje> listaPersonaje = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        rcv_personaje = findViewById(R.id.rcv_personaje);
        rcv_personaje.setLayoutManager(new LinearLayoutManager(this));

    Personaje p1 = new Personaje ("https://rickandmortyapi.com/api/character/avatar/1.jpeg","Rick Sanchez","Alive","Human");
    Personaje p2 = new Personaje ("https://rickandmortyapi.com/api/character/avatar/2.jpeg","Morty Smith","Alive","Human");
    Personaje p3 = new Personaje ("https://rickandmortyapi.com/api/character/avatar/3.jpeg","Summer Smith","Alive","Human");
    Personaje p4 = new Personaje ("https://rickandmortyapi.com/api/character/avatar/4.jpeg","Beth Smith","Alive","Human");
    Personaje p5 = new Personaje ("https://rickandmortyapi.com/api/character/avatar/5.jpeg","Jerry Smith","Alive","Human");

    listaPersonaje.add(p1);
    listaPersonaje.add(p2);
    listaPersonaje.add(p3);
    listaPersonaje.add(p4);
    listaPersonaje.add(p5);

    rcv_personaje.setAdapter(new PersonajeAdaptador(listaPersonaje));

    }
}