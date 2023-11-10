package com.example.gatosapi1;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

public class GatosViewModel extends AndroidViewModel {
    private final Application app;
    private final GatoDataBase GatoDatabase;
    private final GatosDAO movieDao;
    private LiveData<List<Gato>> gatos;


    public GatosViewModel(Application application){
        super(application);
        this.app=application;
        this.GatoDatabase=GatoDataBase.getDatabase(
                this.getApplication()
        );
        this.movieDao=GatoDatabase.getGatosDAO();
    }

    public LiveData<List<Gato>> getGatos() {
        return movieDao.getGatos();
    }

    public void reload(){
   //     Refresh
    }

    private class RefreshDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(
                    app.getApplicationContext()
            );
            String pais = preferences.getString("pais", "es");
            String tipusConsulta = preferences.getString(
                    "tipus_consulta", "vistes"
            );

            //RottenTomatoesAPI api = new RottenTomatoesAPI();
            ArrayList<Gato> result;
            if (tipusConsulta.equals("vistes")) {

              //  result = api.getPeliculesMesVistes(pais);
            } else {
               // result = api.getProximesEstrenes(pais);
            }

            movieDao.deleteGatos();
            //movieDao.addGatos(result);
            return null;
        }

    }
}
