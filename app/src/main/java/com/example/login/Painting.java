package com.example.login;

public class Painting {
    private String title;
    private String artist;
    private int imageResourceId;

    public Painting(String title, String artist, int imageResourceId) {
        this.title = title;
        this.artist = artist;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getImageResourceId() { return imageResourceId; }
}