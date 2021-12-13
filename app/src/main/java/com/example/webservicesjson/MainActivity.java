package com.example.webservicesjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button actualizar;
    EditText d,lat,lon;
    String texto="",texto2="",texto3="";
    ArrayList<String> lista = new ArrayList<String>();
    ArrayAdapter adapatador=null;
    ListView listaUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relacionarVistas();
        adapatador= new ArrayAdapter(this,android.R.layout.simple_spinner_item,lista);
        listaUI.setAdapter(adapatador);
    }

    private void relacionarVistas() {
            actualizar=(Button)findViewById(R.id.actualizar);
            d=(EditText)findViewById(R.id.direccion);
            lat=(EditText)findViewById(R.id.longitud);
            lon=(EditText)findViewById(R.id.latitud);
            listaUI=(ListView)findViewById(R.id.lista_valores);
    }

    public void actualizarWebServices(View v){
        lista.clear();
       String url="http://192.168.0.2/services/seleccionar.php";

        RequestQueue servicio= Volley.newRequestQueue(this);

        JsonArrayRequest respuesta=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject json=null;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        json = response.getJSONObject(i);
                        texto = "Longitud  es " +json.getString("lon");
                        texto2 = " Latitud es " +json.getString("lat");
                        texto3 = " Con dirección es " +json.getString("dire");
                        lista.add(texto+texto2+texto3+"\n");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //Toast.makeText(getApplicationContext(),""+lista,Toast.LENGTH_LONG).show();
               // adapatador= new ArrayAdapter(this,android.R.layout.simple_spinner_item,lista);
                listaUI.setAdapter(adapatador);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        servicio.add(respuesta);

    }

}