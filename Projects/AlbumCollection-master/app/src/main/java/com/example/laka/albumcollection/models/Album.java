package com.example.laka.albumcollection.models;

import android.content.Context;

import java.util.List;

import com.example.laka.albumcollection.dao.SQLiteAlbumDatabase;
import com.example.laka.albumcollection.dao.SQLiteArtistDatabase;

import java.util.List;


public class Album {

    private int ID;
    private String title;
    private Artist artist;
    private static SQLiteAlbumDatabase dao;

    public Album(int ID, String title, Artist artist)
    {
        this.ID = ID;
        this.title = title;
        this.artist = artist;
    }

    public Album(String title, Artist artist)
    {
        this.title = title;
        this.artist = artist;
    }

    public int getID(){return ID;}

    public String getTitle(){return title;}

    public Artist getArtist(){return artist;}

    public void setTitle(String title){this.title = title;}

    public void setArtist(Artist artist){this.artist = artist;}

    @Override
    public String toString() {
        return title;
    }

    public static List<Album> all(Context context, Artist artist) {
        dao = new SQLiteAlbumDatabase(context);
        return dao.all(artist);
    }

}
