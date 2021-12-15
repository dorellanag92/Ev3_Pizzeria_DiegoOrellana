package com.example.ev3_pizzeria_diegoorellana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Model.Pizzas;

public class Listado_act extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Pizzas> listaPizzas = new ArrayList();

    Pizzas pizzaSelected;

    FirebaseDatabase firebase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lista = findViewById(R.id.lv);
        inicializarDatabase();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                pizzaSelected = (Pizzas)parent.getItemAtPosition(position);
            }
        });

        reference.child("Pizzas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot op: snapshot.getChildren()){
                    Pizzas p = op.getValue(Pizzas.class);
                    listaPizzas.add(p);
                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(),android.R.layout.simple_list_item_1, listaPizzas);
                    lista.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void eliminarPizza(View view){
        Pizzas p = new Pizzas();
        p.setId(pizzaSelected.getId());
        reference.child("Pizzas").child(p.getId()).removeValue();
        Toast.makeText(getBaseContext(), "Ha eliminado una pizza", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getBaseContext(),Listado_act.class);
        startActivity(i);
    }

    public void inicializarDatabase(){
        FirebaseApp.initializeApp(this); //inicializa base de datos en este contexto
        firebase = FirebaseDatabase.getInstance(); //instancia
        reference = firebase.getInstance().getReference(); //referencia
    }
}