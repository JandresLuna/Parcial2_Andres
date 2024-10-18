package com.example.parcial2_andres;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edt_usuario, edt_contraseña;
    Button ingresar;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    public static final String dataUserCache = "datauser";
    private static final int modo_private = Context.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edt_usuario = findViewById(R.id.edt_usuario);
        edt_contraseña = findViewById(R.id.edt_contraseña);
        ingresar = findViewById(R.id.ingresar);

        preferences = getSharedPreferences(dataUserCache,modo_private);
        editor = preferences.edit();


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt_usuario.getText().toString().isEmpty() || edt_contraseña.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Debe ingresar un usuario y contraseña",Toast.LENGTH_SHORT).show();

                }else{

                    editor.putString("usuario", edt_usuario.getText().toString());
                    editor.commit();


                    Intent i = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(i);
                    finish();
                }
            }
        });

    }

}
