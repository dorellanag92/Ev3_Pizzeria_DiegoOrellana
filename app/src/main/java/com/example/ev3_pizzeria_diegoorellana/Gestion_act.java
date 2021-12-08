package com.example.ev3_pizzeria_diegoorellana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Model.Pizzas;

public class Gestion_act extends AppCompatActivity {

    private EditText nombre, precio, localizacion;
    private Button btn;

    FirebaseDatabase firebase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        nombre = findViewById(R.id.nom);
        precio = findViewById(R.id.pre);
        localizacion = findViewById(R.id.loc);
        btn = findViewById(R.id.btn_addPizza);

        inicializarDatabase();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pizzas p = new Pizzas();

                p.setId(UUID.randomUUID().toString());
                p.setNombre(nombre.getText().toString());
                p.setPrecio(precio.getText().toString());
                p.setLocalizacion(localizacion.getText().toString());

                reference.child("Pizzas").child(p.getId()).setValue(p);

                Toast.makeText(getBaseContext(), "Ha agregado una pizza", Toast.LENGTH_SHORT).show();
                Limpiar();
            }
        });
    }

    public void inicializarDatabase(){
        FirebaseApp.initializeApp(this); //inicializa base de datos en este contexto
        firebase = FirebaseDatabase.getInstance(); //instancia
        reference = firebase.getInstance().getReference(); //referencia
    }

    public void Limpiar(){
        nombre.setText("");
        precio.setText("");
        localizacion.setText("");
    }
}