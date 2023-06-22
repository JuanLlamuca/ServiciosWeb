package com.example.serviciosweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irFormula(View view){
        Intent intent=new Intent(this,FormulaGeneral.class);
        setContentView(R.layout.activity_formula_general);
    }

    public void irPontencia(View view){
        Intent intent=new Intent(this,Potencia.class);
        setContentView(R.layout.activity_potencia);
    }

    public void irTrinomio(View view){
        Intent intent=new Intent(this,Trinomio.class);
        setContentView(R.layout.activity_trinomio);
    }
}