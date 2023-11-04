package com.example.gatosapi1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GatoAdapter extends ArrayAdapter<Gato> {


    public GatoAdapter(@NonNull Context context, int resource, List<Gato> gatos) {
        super(context, resource, gatos);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Gato gato=getItem(position);
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.gatos_row, parent, false);
        }

        TextView idGato=convertView.findViewById(R.id.gatoId);
        idGato.setText("El id es"+gato.getId());
        Log.i("El id es"+gato.getId(),"El id es"+gato.getId());

        return convertView;

    }


}
