package com.example.gatosapi1;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class APIGato {
    private String BASE_URL="https://api.thecatapi.com/v1/images/search";

    ArrayList<Gato> getGatos(){
        Uri builtUri= Uri.parse(BASE_URL).buildUpon().build();
        String url=builtUri.toString();
        return doCall(url);
    }

    private ArrayList<Gato> doCall(String url){
        try{
            String Jresponse= HttpUtils.get(url);
            return processJson(Jresponse);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    private ArrayList<Gato> processJson(String Jresponse){
        ArrayList<Gato>listaGatos=new ArrayList<>();

        try {
            JSONObject jsonObject= new JSONObject(Jresponse);
            Gato gato=new Gato();
            JSONObject gatoJson=jsonObject.getJSONObject("id");
            gato.setId(gatoJson.getString("id"));
            listaGatos.add(gato);




        }catch (Exception e){
            e.printStackTrace();
        }
        return listaGatos;
    }



}
