package com.example.login;

public class Pintura {
    //private int id;
    private int imagenId;
    private String nombre;
    private String artista ;
    private String estrellas ;
    private String descripcion;
    private String galeria;
    private int audio;

    /*@Override //
    public String toString() {
        return "Pintura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", artista='" + artista + '\'' +
                ", estrellas='" + estrellas + '\'' +
                '}';
    }
*/
    public Pintura(int imagenId, String nombre, String artista, String estrellas, String galeria, String descripcion, int audio) {
        this.nombre = nombre;
        this.artista = artista;
        this.estrellas = estrellas;
        this.imagenId = imagenId;
        this.galeria = galeria;
        this.descripcion = descripcion;
        this.audio = audio;
    }

    //public int getId() {
        //return id;
    //}

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

   // public void setId(int id) {
        //this.id = id;
   // }

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
}
