package com.example.gatosapi1;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class APIGato {
    private String BASE_URL="https://api.thecatapi.com/v1";

    ArrayList<Gato> getGatos(){
        Uri builtUri= Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("images")
                .appendPath("search")
                .appendQueryParameter("limit","10")
                .build();
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

            JSONArray jsonArray=new JSONArray(Jresponse);
            for(int i=0;i<jsonArray.length();i++){
                Gato gato=new Gato();
                JSONObject gatoJson=jsonArray.getJSONObject(i);
                gato.setId(gatoJson.getString("id"));
                gato.setImage(gatoJson.getString("url"));
                gato.setWeight(gatoJson.getInt("width"));
                gato.setHeight(gatoJson.getInt("height"));
                listaGatos.add(gato);

            }




        }catch (Exception e){
            e.printStackTrace();
        }
        return listaGatos;
    }



}
