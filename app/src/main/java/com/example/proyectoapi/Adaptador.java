package com.example.proyectoapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    JSONArray jsonArray;
    Context context;
    public Adaptador(Context context, JSONArray jsonArray){
        this.jsonArray =jsonArray; this.context=context;
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
        try {
            holder.tvNombre.setText(jsonArray.getJSONObject(position).getString("first_name"));
            holder.tvApellido.setText(jsonArray.getJSONObject(position).getString("last_name"));
            // Imagen
            //holder.ivImagen.setImageResource(R.mipmap.ic_launcher);
            String url=jsonArray.getJSONObject(position).get("avatar").toString();
            Picasso.with(context).load(url).into(holder.ivImagen);
        } catch (JSONException e) {
            // Error porque no se pudo obtener el Json
            throw new RuntimeException(e);
        }

    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Atributos
        TextView tvNombre, tvApellido;
        ImageView ivImagen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Relacion de los atributos con la vista
            tvNombre=itemView.findViewById(R.id.tvNombre);
            tvApellido=itemView.findViewById(R.id.tvApellido);
            ivImagen=itemView.findViewById(R.id.ivImagen);
        }
    }
}
