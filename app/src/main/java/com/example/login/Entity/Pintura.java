package com.example.login.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "pintura",
        foreignKeys = {
                @ForeignKey(entity = Autor.class,
                        parentColumns = "nombre",
                        childColumns = "artista",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Galeria.class,
                        parentColumns = "nombre",
                        childColumns = "galeria",
                        onDelete = ForeignKey.CASCADE)
        },
        indices = {@Index(value = "artista"), @Index(value = "galeria")})
public class Pintura {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "imagen_id")
    private int imagenId;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "artista")
    private String artista;

    @ColumnInfo(name = "estrellas")
    private String estrellas;

    @ColumnInfo(name = "descripcion")
    private String descripcion;

    @ColumnInfo(name = "galeria")
    private String galeria;

    @ColumnInfo(name = "audio")
    private int audio;

    // Constructor vacío necesario para Room
    @Ignore
    public Pintura() {}

    public Pintura(int imagenId, String nombre, String artista, String estrellas, String galeria, String descripcion, int audio) {
        this.imagenId = imagenId;
        this.nombre = nombre;
        this.artista = artista;
        this.estrellas = estrellas;
        this.descripcion = descripcion;
        this.galeria = galeria;
        this.audio = audio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(String estrellas) {
        this.estrellas = estrellas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGaleria() {
        return galeria;
    }

    public void setGaleria(String galeria) {
        this.galeria = galeria;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public void setAutorId(int id) {
    }

    public void setGaleriaId(int id) {
    }
}