package com.example.gatosapi1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GatosDAO {
    @Query("select * from Gato")
    LiveData<List<Gato>> getGatos();

    @Insert
    void addGato(Gato gato);

    @Insert
    void addGatos(List<Gato> gatos);

    @Delete
    void deleteGato(Gato gato);

    @Query("DELETE FROM Gato")
    void deleteGatos();

}
