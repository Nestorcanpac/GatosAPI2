package com.example.gatosapi1;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.prefs.Preferences;

public class GatosViewModel extends AndroidViewModel {
    private final Application app;
    private final GatoDataBase GatoDatabase;
    private final GatosDAO gatosDAO;
    private LiveData<List<Gato>> gatos;


    public GatosViewModel(Application application){
        super(application);
        this.app=application;
        this.GatoDatabase=GatoDataBase.getDatabase(
                this.getApplication()
        );
        this.gatosDAO=GatoDatabase.getGatosDAO();
    }

    public LiveData<List<Gato>> getGatos() {
        return gatosDAO.getGatos();
    }

    public void reload(){
   //     Refresh

        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.myLooper());

        executorService.execute(() ->{
            APIGato apiGato=new APIGato();
            ArrayList<Gato> result=apiGato.getGatos();
            gatosDAO.deleteGatos();
            gatosDAO.addGatos(result);

        });
    }


}
