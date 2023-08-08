package com.example.laka.albumcollection.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.laka.albumcollection.R;
import com.example.laka.albumcollection.models.Album;

import org.json.JSONObject;

import java.util.ArrayList;



public class AlbumAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Album> albums;
    private Context ctx;

    public AlbumAdapter(ArrayList<Album> albums, LayoutInflater inflater, Context ctx){
        this.inflater = inflater;
        this.albums = albums;
        this.ctx = ctx;
    }

    public void add(Album album){
        albums.add(album);
    }

    public void remove(int index){
        albums.remove(index);
    }

    @Override
    public int getCount() {
        return albums.size();
    }

    @Override
    public Object getItem(int i) {
        return albums.get(i);
    }

    @Override
    public long getItemId(int i) {
        return albums.get(i).getID();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Album album = albums.get(i);
        View v = inflater.inflate(R.layout.adapter_album_layout, null);
        ((TextView)v.findViewById(R.id.albumTitle)).setText(album.getTitle());
        return v;
    }

}
