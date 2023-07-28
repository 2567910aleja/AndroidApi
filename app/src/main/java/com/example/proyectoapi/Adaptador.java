package com.example.proyectoapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    JSONArray jsonArray;
    public Adaptador(Context context, JSONArray jsonArray){
        this.jsonArray =jsonArray;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_usuarios, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        // Colocar los datos del json a cada elemento o vista

    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Atributos
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Relacion de los atributos con la vista
        }
    }
}
