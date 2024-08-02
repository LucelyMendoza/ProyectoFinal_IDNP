package com.example.login.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.OnConflictStrategy;

import com.example.login.Entity.Autor;

import java.util.List;

@Dao
public interface AutorDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Autor... autores);

    @Update
    void update(Autor... autores);

    @Delete
    void delete(Autor... autores);

    @Query("SELECT * FROM autor")
    List<Autor> getAllAutores();

    @Query("SELECT * FROM autor WHERE nombre = :nombre LIMIT 1")
    Autor getByName(String nombre);
}