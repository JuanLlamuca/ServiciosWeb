package com.example.serviciosweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class FormulaGeneral extends AppCompatActivity {

    EditText txt_a,txt_b,txt_c,txt_respuesta;
    Button btn_calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula_general);
        txt_a=findViewById(R.id.txt_a);
        txt_b=findViewById(R.id.txt_b);
        txt_c=findViewById(R.id.txt_c);
        txt_respuesta=findViewById(R.id.txt_respuesta);
        btn_calcular=findViewById(R.id.btn_calcular);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leer();
            }
        });
    }

    private void leer(){
        String url = "https://apifunciones.azurewebsites.net/Funciones/FormulaGeneral?a=" + txt_a + "&b=" + txt_b + "&c=" + txt_c;

        StringRequest postResquest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            //este metodo se ejecuta cuando nos regrese una respuesta el web service
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject= new JSONObject(response);
                    txt_a.setText(jsonObject.getString("a"));
                    txt_b.setText(jsonObject.getString("b"));
                    txt_c.setText(jsonObject.getString("c"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("error",error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);
    }

    public void Finalizar(View view){
        this.finish();
    }
}