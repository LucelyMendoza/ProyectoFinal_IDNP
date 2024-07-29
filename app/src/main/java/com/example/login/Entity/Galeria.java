package com.example.login.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "galeria")
public class Galeria {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nombre;
    public String descripcion;
}

