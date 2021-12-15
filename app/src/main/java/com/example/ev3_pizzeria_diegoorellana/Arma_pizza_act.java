package com.example.ev3_pizzeria_diegoorellana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import Object.ATP;

public class Arma_pizza_act extends AppCompatActivity {

    private Spinner tipo, ingrediente;
    private TextView resultado;
    private ATP atp = new ATP();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arma_pizza);

        tipo = findViewById(R.id.tp);
        ingrediente = findViewById(R.id.igd);
        resultado = findViewById(R.id.tv_resultado);

        Bundle bun = getIntent().getExtras();
        String[] listPizza = bun.getStringArray("ATP");
        String[] listIngrediente = bun.getStringArray("ATP2");
        ArrayAdapter adaptPizza = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listPizza);
        ArrayAdapter adaptIng = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listIngrediente);
        tipo.setAdapter(adaptPizza);
        ingrediente.setAdapter(adaptIng);
    }
    public void Calcular(View v){
        int prec = 0;
        int ing = 0;
        int resultadoP;
        String opcion1 = tipo.getSelectedItem().toString();
        String opcion2 = ingrediente.getSelectedItem().toString();
        for(int i = 0; i<opcion1.length();i++){
            if(opcion1.equals(atp.getP_tipo()[i])){
                prec = atp.getP_precio()[i];
                break;
            }
        }

        for(int j = 0; j<opcion2.length();j++){
            if(opcion2.equals(atp.getIngrediente()[j])){
                ing = +atp.getI_precio()[j];
                break;
            }
        }
        resultadoP = atp.calcularPizza(prec,ing);
        resultado.setText("$"+resultadoP+".");
    }
}