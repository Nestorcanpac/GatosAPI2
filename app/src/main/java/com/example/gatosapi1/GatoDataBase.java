package com.example.gatosapi1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Gato.class},version = 1)
public abstract class GatoDataBase extends RoomDatabase {
    private static GatoDataBase INSTANCE;

    public static GatoDataBase getDatabase(Context context){
        if (INSTANCE==null){
            INSTANCE=
                    Room.databaseBuilder(
                            context.getApplicationContext(),
                            GatoDataBase.class,"db"
                    ).build();
        }
        return INSTANCE;
    }
    public abstract GatosDAO getGatosDAO();

}
