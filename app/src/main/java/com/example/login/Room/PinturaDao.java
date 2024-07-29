package com.example.login.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.login.Entity.Pintura;

import java.util.List;

@Dao
public interface PinturaDao {
    @Insert
    void insert(Pintura... pinturas);

    @Update
    void update(Pintura... pinturas);

    @Delete
    void delete(Pintura... pinturas);

    @Query("SELECT * FROM pintura")
    List<Pintura> getAllPinturas();
}
