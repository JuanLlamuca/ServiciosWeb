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

public class Potencia extends AppCompatActivity {

    EditText txt_n1,txt_n2;
    Button btn_calcular2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potencia);
        txt_n1=findViewById(R.id.txt_n1);
        txt_n2=findViewById(R.id.txt_n2);
        btn_calcular2=findViewById(R.id.btn_calcular2);

        btn_calcular2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leer();
            }
        });
    }

    private void leer(){
        String url = "https://apifunciones.azurewebsites.net/Funciones/Potencia?a=" + txt_n1 + "&b=" + txt_n2;

        StringRequest postResquest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            //este metodo se ejecuta cuando nos regrese una respuesta el web service
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject= new JSONObject(response);
                    txt_n1.setText(jsonObject.getString("n1"));
                    txt_n2.setText(jsonObject.getString("n2"));

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


    //Funcion para regresar
    public void Finalizar(View view){
        this.finish();
    }
}