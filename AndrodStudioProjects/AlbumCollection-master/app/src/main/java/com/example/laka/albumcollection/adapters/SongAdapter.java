package com.example.laka.albumcollection.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.laka.albumcollection.R;
import com.example.laka.albumcollection.models.Song;


import java.util.ArrayList;



public class SongAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Song> songs;;
    private Context ctx;
    private Song song;

    public SongAdapter(ArrayList<Song> songs, LayoutInflater inflater, Context ctx){
        this.inflater = inflater;
        this.songs = songs;
        this.ctx = ctx;
    }

    public void add(Song song){
        songs.add(song);
    }

    public void remove(int index){
        songs.remove(index);
    }

    public void delete()
    {

    }
    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int i) {
        return songs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return songs.get(i).getID();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        song = songs.get(i);
        View v = inflater.inflate(R.layout.adapter_song_layout, null);
        ((TextView)v.findViewById(R.id.songTitle)).setText(song.getTitle());
        ((TextView)v.findViewById(R.id.trackField)).setText(String.valueOf(song.getPosition()));
        return v;
    }
}
