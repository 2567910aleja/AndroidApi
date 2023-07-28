package com.example.proyectoapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerLista=findViewById(R.id.recyclerLista);
        recyclerLista.setLayoutManager(new LinearLayoutManager(this));

        // Conectarse a la base de datos
        AsyncHttpClient httpClient= new AsyncHttpClient();
        httpClient.get(UrlServidor.urlListar, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                String respuesta=new String(responseBody);
                try {
                    cargarDatos(statusCode, respuesta);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Toast.makeText(MainActivity.this, "onSucces, SI hay conexion", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                try {
                    cargarDatos(statusCode, "Error de conexion");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Toast.makeText(MainActivity.this, "onFailure, NO hay conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cargarDatos(int statusCode, String respuesta) throws JSONException {
        if (statusCode == 200) {
            // Si hay conexion
            // Log.e("datos", respuesta.toString());
            JSONObject miJsonObj= new JSONObject(respuesta);
            JSONArray miJsonArray=miJsonObj.getJSONArray("data");

            // Ahora coloco los datos en el Listview, recycler
            // Crear el adaptador en un nuevo java class
        }else{
            Toast.makeText(this, ""+respuesta, Toast.LENGTH_SHORT).show();
        }
    }
}