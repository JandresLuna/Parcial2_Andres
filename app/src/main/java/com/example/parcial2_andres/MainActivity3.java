package com.example.parcial2_andres;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.parcial2_andres.clases.Personaje;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class MainActivity3 extends AppCompatActivity {

    Button btn_volver;
    TextView txt_nombre_detalle, txt_estado_detalle, txt_raza_detalle;
    ImageView foto_perfil_detalle;
    public static final String dataUserCache = "datauser";
    private static final int modo_private = Context.MODE_PRIVATE;
    String datoShared;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        btn_volver = findViewById(R.id.btn_volver);
        txt_nombre_detalle = findViewById(R.id.txt_nombre_detalle);
        txt_estado_detalle = findViewById(R.id.txt_estado_detalle);
        txt_raza_detalle = findViewById(R.id.txt_raza_detalle);
        foto_perfil_detalle = findViewById(R.id.foto_perfil_detalle);



        datoShared = getApplicationContext().getSharedPreferences(dataUserCache,modo_private).getString("usuario","0");



        preferences = getSharedPreferences(dataUserCache,modo_private);
        editor = preferences.edit();

        String personajeJson = getIntent().getExtras().getString("personaje");
        Gson gson = new Gson();
        Personaje personaje = gson.fromJson(personajeJson, Personaje.class);

        txt_nombre_detalle.setText(personaje.getNombre());
        txt_estado_detalle.setText(personaje.getEstado());
        txt_raza_detalle.setText(personaje.getRaza());

        Picasso.get().load(personaje.getImagen()).into(foto_perfil_detalle);




        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();


                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Asegurarse de limpiar el back stack
                startActivity(intent);
                finish();
            }
        });


    }
}