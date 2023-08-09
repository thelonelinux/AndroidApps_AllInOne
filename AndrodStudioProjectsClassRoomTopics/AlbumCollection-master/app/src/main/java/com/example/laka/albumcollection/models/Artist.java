package com.example.laka.albumcollection.models;



import android.content.Context;

import java.util.List;

import com.example.laka.albumcollection.dao.SQLiteArtistDatabase;

import java.util.List;

public class Artist {
    private int ID;
    private String name;
    private static SQLiteArtistDatabase dao;

    public Artist(int ID, String name)
    {
        this.ID = ID;
        this.name = name;
    }

    public Artist(String name)
    {
        this.name = name;
    }

    public int getID(){return ID;}

    public String getName(){return name;}

    public void setName(String title){this.name = name;}

    @Override

    public String toString() {
        return name;
    }

    public static List<Artist> all(Context context) {
        dao = new SQLiteArtistDatabase(context);
        return dao.all();
    }
}
