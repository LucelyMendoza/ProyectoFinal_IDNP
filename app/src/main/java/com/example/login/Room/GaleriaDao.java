package com.example.login.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.login.Entity.Galeria;

import java.util.List;

@Dao
public interface GaleriaDao {
    @Insert
    void insert(Galeria... galerias);

    @Update
    void update(Galeria... galerias);

    @Delete
    void delete(Galeria... galerias);

    @Query("SELECT * FROM galeria")
    List<Galeria> getAllGalerias();
}

