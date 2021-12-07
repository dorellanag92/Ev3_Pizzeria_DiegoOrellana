package com.example.ev3_pizzeria_diegoorellana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import Object.ATP;

public class MainActivity extends AppCompatActivity {

    private ATP atp = new ATP();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gestionPizza(View v){
        Intent i = new Intent(getBaseContext(),Gestion_act.class);
        startActivity(i);
    }

    public void listadoPizza(View v){
        Intent i = new Intent(getBaseContext(),Listado_act.class);
        startActivity(i);
    }

    public void armaPizza(View v){
        Intent i = new Intent(getBaseContext(),Arma_pizza_act.class);
        Bundle bun = new Bundle();
        Bundle bun2 = new Bundle();
        bun.putStringArray("ATP",atp.getP_tipo());
        bun.putStringArray("ATP2", atp.getIngrediente());
        i.putExtras(bun);
        startActivity(i);
    }

    public void Facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW); //abre sitio web
        i.setData(Uri.parse("https://www.facebook.com/")); //recibe direccion web
        startActivity(i); //Se inicia el activity
    }

    public void Instagram(View view){
        Intent i = new Intent(Intent.ACTION_VIEW); //abre sitio web
        i.setData(Uri.parse("https://www.instagram.com/")); //recibe direccion web
        startActivity(i); //Se inicia el activity
    }

    public void Twitter(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);
    }

    public void Youtube(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }


}