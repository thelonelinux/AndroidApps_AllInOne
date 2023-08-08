package com.example.myfavouritesapp.VideoActivity;


import android.net.Uri;



public class VideoPojo {
    private String name;
    private Uri uri;

    public VideoPojo(String name, Uri uri){
        this.name=name;
        this.uri=uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}