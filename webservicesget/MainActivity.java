package com.example.webservicesget;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText e1,e2,e3,e4;
TextView t1,t2,t3,t5;
Button b1,b2,b3,b4;
Spinner sp1,sp2;
ImageView foto;
    ArrayList<String> id=new ArrayList<String>();
    ArrayList<String> origen=new ArrayList<String>();
    ArrayList<String> destino=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            relacionaVistas();
    }

    public  void relacionaVistas(){
        foto=(ImageView)findViewById(R.id.imageView);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
    t1=(TextView) findViewById(R.id.textView);
    t2=(TextView) findViewById(R.id.textView2);
    t3=(TextView) findViewById(R.id.textView3);
    t5=(TextView) findViewById(R.id.textView5);
    b1=(Button) findViewById(R.id.button);
    b2=(Button) findViewById(R.id.button2);
    b3=(Button) findViewById(R.id.button3);
    b4=(Button) findViewById(R.id.button4);
    sp1=(Spinner)findViewById(R.id.spinner);
    sp2=(Spinner)findViewById(R.id.spinner2);
    b1.setOnClickListener(this);
    b2.setOnClickListener(this);
    b3.setOnClickListener(this);
    b4.setOnClickListener(this);

}

public void insertar2(){
//    final String id=e1.getText().toString();
//    final String origen=e2.getText().toString();
//    final String destino=e3.getText().toString();

  RequestQueue servicio= Volley.newRequestQueue(this);
  String url="http://192.168.0.4/reservacionvuelos/cargaDatos.php";
  StringRequest respuesta= new StringRequest(Request.Method.POST, url,
          new Response.Listener<String>() {
              @Override
              public void onResponse(String response) {
Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
t5.setText(response);
              }
          }, new Response.ErrorListener(){
      @Override
      public void onErrorResponse(VolleyError error) {
          Toast.makeText(getApplicationContext(),"Error de comunicacion:"+error,Toast.LENGTH_LONG).show();
      }
  })
//  {
//      @Override
//      protected Map<String, String> getParams() throws AuthFailureError {
//          Map<String,String>  valoresPOST= new HashMap<String, String>();
//          valoresPOST.put("id",id);
//          valoresPOST.put("o",origen);
//          valoresPOST.put("d",destino);
//          return valoresPOST;
//      }
//  }
  ;

  servicio.add(respuesta);
}

public void getimagen(){
    RequestQueue servicioJson= Volley.newRequestQueue(this);
    ImageRequest respuesta = new ImageRequest("http://192.168.43.42:3977/api/get-imagen-usuario/0TsBubrh24ayAcspOeGb7fyn",
            new Response.Listener<Bitmap>() {
                @Override
                public void onResponse(Bitmap bitmap) {
                    foto.setImageBitmap(bitmap);
                }
            }, 0, 0, null, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });
    servicioJson.add(respuesta);
}

public void servicios(){
    /*
    esta es la funcion que consume desde nodeJS
    function prueba(req, res) {
    console.log(req.body.destino);;
    res.status(200).send([{ "0": "", "id": "", "1": "", "origen": "", "2": "", "destino": "" }, { "0": "1", "id": "1", "1": "CDMX", "origen": "CDMX", "2": "ACAPULCO", "destino": "ACAPULCO" }, { "0": "10", "id": "10", "1": "Guadalajara", "origen": "Guadalajara", "2": "usa", "destino": "usa" }, { "0": "12", "id": "12", "1": "Wuan China", "origen": "Wuan China", "2": "City M\u00c3\u00a9xico", "destino": "City M\u00c3\u00a9xico" }, { "0": "2", "id": "2", "1": "CDMX", "origen": "CDMX", "2": "CHETUMAL", "destino": "CHETUMAL" }, { "0": "3", "id": "3", "1": "CDMX", "origen": "CDMX", "2": "MAZATLAN", "destino": "MAZATLAN" }, { "0": "4", "id": "4", "1": "MERIDA", "origen": "MERIDA", "2": "CDMX", "destino": "CDMX" }, { "0": "5", "id": "5", "1": "CDMX", "origen": "CDMX", "2": "FRANCIA", "destino": "FRANCIA" }, { "0": "6", "id": "6", "1": "Israel", "origen": "Israel", "2": "Egipto", "destino": "Egipto" }, { "0": "7", "id": "7", "1": "Tlapala state", "origen": "Tlapala state", "2": "Neza city", "destino": "Neza city" }, { "0": "8", "id": "8", "1": "Venustiano Carranza", "origen": "Venustiano Carranza", "2": "Milpa Alta", "destino": "Milpa Alta" }, { "0": "9", "id": "9", "1": "Chalco", "origen": "Chalco", "2": "Amecameca", "destino": "Amecameca" }]);
}
*/
        RequestQueue servicioConsulta=Volley.newRequestQueue(this);
        JsonArrayRequest respuestaConsulta= new JsonArrayRequest(
                "http://172.16.3.251:3977/api/probando-control2",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                    id.clear();
                    origen.clear();
                    destino.clear();
                        JSONObject json=null;
                        try {
                            for (int i = 0; i < response.length() ; i++) {
                                json=response.getJSONObject(i);
                                id.add(json.getString("id"));
                                origen.add(json.getString("origen"));
                                destino.add(json.getString("destino"));
                            }

                            Toast.makeText(getApplicationContext(),
                                    ""+origen+"--"+destino,Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),
                                    "ERROR COMUNICACION",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        servicioConsulta.add(respuestaConsulta);

    ArrayAdapter<String> adapta=new ArrayAdapter<String>(getApplicationContext(),
            android.R.layout.simple_list_item_1,origen);
    sp1.setAdapter(adapta);

    ArrayAdapter<String> adapter2=new ArrayAdapter<String>(getApplicationContext(),
            android.R.layout.select_dialog_item,destino);
    sp2.setAdapter(adapter2);
    }

public void insertar(){
RequestQueue servicioJson= Volley.newRequestQueue(this);
String url="http://192.168.43.42:3977/api/probando-control2";
    StringRequest respuesta= new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                }
            } , new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(), "error red", Toast.LENGTH_SHORT).show();
        }
    });
    servicioJson.add(respuesta);
}

public void eliminar(){
    RequestQueue servicio3= Volley.newRequestQueue(this);
    String url="http://192.168.0.6/reservacionvuelos/eliminar.php";
    StringRequest respuesta3= new StringRequest(Request.Method.POST, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(),"Error C",Toast.LENGTH_LONG).show();
        }
    }){
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> valores= new HashMap<String,String>();
            valores.put("id",e1.getText().toString());
            return valores;
        }
    };
    servicio3.add(respuesta3);
}

public void editar(){
      RequestQueue servicio4= Volley.newRequestQueue(this);
      String id=e1.getText().toString();
      String origen=e2.getText().toString();
      String destino=e3.getText().toString();
      String url="http://169.254.174.56/reservacionvuelos/editar.php?id="+id+"&o="+origen+"&d="+destino;
      StringRequest respuesta4= new StringRequest(Request.Method.GET, url,
              new Response.Listener<String>() {
                  @Override
                  public void onResponse(String response) {
                      Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                  }
              }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
              Toast.makeText(getApplicationContext(),"Error de Comunicacion",Toast.LENGTH_LONG).show();
          }
      });
servicio4.add(respuesta4);
}

    public void prueba(){
        RequestQueue servicioConsulta=Volley.newRequestQueue(this);
        StringRequest respuestaConsulta= new StringRequest(Request.Method.POST,
                "http://192.168.1.18:3977/api/probando-control2/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        id.clear();
                        origen.clear();
                        destino.clear();
                        JSONObject json=null;

                        try {
                            JSONArray r =new JSONArray(response);
                            for (int i = 0; i < r.length() ; i++) {
                                json=r.getJSONObject(i);
                                id.add(json.getString("id"));
                                origen.add(json.getString("origen"));
                                destino.add(json.getString("destino"));
                            }

                            Toast.makeText(getApplicationContext(),
                                    ""+origen+"--"+destino,Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),
                                    "ERROR JSON",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){   @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("destino", e1.getText().toString());
                return params;
            }
        };

                servicioConsulta.add(respuestaConsulta);


                    ArrayAdapter<String> adapta = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, origen);
        sp1.setAdapter(adapta);

                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.select_dialog_item, destino);
        sp2.setAdapter(adapter2);
                }

    public void prueba2(){
        RequestQueue servicioConsulta=Volley.newRequestQueue(this);
        StringRequest respuestaConsulta= new StringRequest(Request.Method.POST,
                "http://192.168.1.18:3977/api/registrar/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject json=null;
                        t5.setText("");
                        try {
                            JSONArray r =new JSONArray(response);
                            for (int i = 0; i < r.length() ; i++) {
                                json=r.getJSONObject(i);
                                //t5.append(json.getString("_id"));
                                t5.append(json.getString("nombre"));
                                t5.append(json.getString("apellido"));
                                t5.append(json.getString("email"));
                                t5.append(json.getString("password"));
                            }
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),
                                    "ERROR JSON",
                                    Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(getApplicationContext(),
                                response.toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "ERROR RED",
                        Toast.LENGTH_SHORT).show();
            }
        }){   @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap<>();
            params.put("nombre", e1.getText().toString());
            params.put("apellido", e2.getText().toString());
            params.put("email", e3.getText().toString());
            params.put("password", e4.getText().toString());
            return params;
        }        };
        servicioConsulta.add(respuestaConsulta);
    }

    public void prueba3(){
        RequestQueue servicioConsulta=Volley.newRequestQueue(this);
        ImageRequest respuestaConsulta= new ImageRequest(
                "http://192.168.1.18:3977/api//get-imagen-usuario/_OBKDfkaJX8LKDT2jnhA_sAd.png",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
foto.setImageBitmap(response);
                        Toast.makeText(getApplicationContext(),
                                "cargando..",
                                Toast.LENGTH_SHORT).show();
                    }
                },0,0,null, null,new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "ERROR RED",
                        Toast.LENGTH_SHORT).show();
            }
        });
        servicioConsulta.add(respuestaConsulta);
    }

    public void prueba4(){
        RequestQueue servicioConsulta=Volley.newRequestQueue(this);
        StringRequest respuestaConsulta= new StringRequest(Request.Method.POST,
                "http://192.168.1.18:3977/api/actualizar-imagen-usuario2/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),
                                "cargando..",
                                Toast.LENGTH_SHORT).show();
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "ERROR RED",
                        Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("image",encodeImage );
                return params;
            }  @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","image/gif");
                return params;
            }
        };
        servicioConsulta.add(respuestaConsulta);
    }

        @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
               prueba4();
                break;
            case R.id.button2:
                servicios();
                break;
            case R.id.button3:
                eliminar();
                break;
            case R.id.button4:
                getimagen();
                break;
        }}}


/*
    StringRequest eventoReq = new StringRequest(Request.Method.POST,Configuracion.URL_API_PROXIMOS_EVENTOS,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d(TAG, response.toString());

                    hidePDialog();
                    try{
                        JSONArray j= new JSONArray(response);

                        // Parsea json
                        for (int i = 0; i < j.length(); i++) {
                            try {
                                JSONObject obj = j.getJSONObject(i);

                                Evento evento = new Evento();
                                evento.setCod_evento(obj.getInt("cod_evento"));
                                evento.setTitulo(obj.getString("titulo"));
                                evento.setDescripcion(obj.getString("descripcion"));
                                evento.setDireccion(obj.getString("direccion"));
                                evento.setImagen(obj.getString("imagen"));
                                evento.setPuntuacion((float) obj.getDouble("puntuacion"));

                                // Añade el evento al listado
                                listaEventos.add(evento);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
// Actualiza el adaptador
                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            VolleyLog.d(TAG, "Error: " + error.getMessage());
            hidePDialog();

        }
    }){
        @Override
        protected Map<String, String> getParams() {
            // Posting parameters to login url
            Map<String, String> params = new HashMap<String, String>();
            params.put("tag", "eventos_proximos_usuario");
            params.put("cod_usuario", cod_usuario);
            return params;
        }
    };

// Añade la peticion a la cola
    AppController.getInstance().addToRequestQueue(eventoReq);
*/

