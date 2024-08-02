package com.example.login;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.login.Entity.Autor;
import com.example.login.Entity.Galeria;
import com.example.login.Entity.Pintura;
import com.example.login.Room.AutorDao;
import com.example.login.Room.GaleriaDao;
import com.example.login.Room.PinturaDao;

@Database(entities = {Pintura.class, Autor.class, Galeria.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PinturaDao pinturaDao();
    public abstract AutorDao autorDao();
    public abstract GaleriaDao galeriaDao();
}


