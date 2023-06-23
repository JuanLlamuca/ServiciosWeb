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

public class Trinomio extends AppCompatActivity {


    EditText txt_at,txt_bt,txt_resultado;
    Button btn_calcular3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trinomio);
        txt_at=findViewById(R.id.txt_at);
        txt_bt=findViewById(R.id.txt_bt);
        txt_resultado=findViewById(R.id.txt_res);
        btn_calcular3=findViewById(R.id.btn_calcular3);

        btn_calcular3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leer();
            }
        });

    }

    private void leer(){
        String url = "https://apifunciones.azurewebsites.net/Funciones/TrinomioCuadradoPerfecto?a=" + txt_at + "&b=" + txt_bt;

        StringRequest postResquest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            //este metodo se ejecuta cuando nos regrese una respuesta el web service
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject= new JSONObject(response);
                    txt_resultado.setText(jsonObject.getInt("$int32"));


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