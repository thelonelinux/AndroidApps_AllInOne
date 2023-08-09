package com.example.laka.albumcollection.models;

import android.content.Context;

import java.util.List;

import com.example.laka.albumcollection.dao.SQLiteArtistDatabase;
import com.example.laka.albumcollection.dao.SQLiteSongDatabase;


public class Song {

    private int ID;
    private String title;
    private int position;
    private Album album;
    private static SQLiteSongDatabase dao;

    public Song(int ID, String title, int position, Album album)
    {
        this.ID = ID;
        this.position = position;
        this.title = title;
        this.album = album;
    }

    public Song(String title, int position, Album album)
    {
        this.title = title;
        this.position = position;
        this.album = album;
    }

    public int getID(){return ID;}

    public String getTitle(){return title;}

    public int getPosition(){return position;}

    public Album getAlbum(){return album;}

    public void setTitle(String title){this.title = title;}

    public void setAlbum(Album album){this.album = album;}

    @Override

    public String toString() {
        return "Album " + album.getTitle() + " | Song: " + title;
    }

}
