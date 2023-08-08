package com.example.laka.albumcollection.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.example.laka.albumcollection.R;
//import com.example.laka.albumcollection.adapters.SongAdapter;
import com.example.laka.albumcollection.adapters.ArtistAdapter;
import com.example.laka.albumcollection.adapters.SongAdapter;
import com.example.laka.albumcollection.dao.SQLiteAlbumDatabase;
import com.example.laka.albumcollection.dao.SQLiteSongDatabase;
import com.example.laka.albumcollection.models.Album;
import com.example.laka.albumcollection.models.Artist;
import com.example.laka.albumcollection.models.Song;

import java.util.ArrayList;
import java.util.List;



public class SongsActivity extends MainActivity implements PopupMenu.OnMenuItemClickListener {

    private long albumID;
    private SQLiteAlbumDatabase dbAlbum;
    private SQLiteSongDatabase dbSong;
    private Album album;
    private ListView lv;
    private ListAdapter currentAdapter;
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        init();
        setTitle(album.getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.album_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete_album:
                deleteAlbum();
                return true;
            case R.id.action_edit_album:
                redirectAlbumEdit(albumID);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void deleteAlbum()
    {
        delete();
        showToast("Album deleted");
        gotoMain();
    }

    public void delete()
    {
        dbAlbum = new SQLiteAlbumDatabase(getApplicationContext());
        dbAlbum.delete(dbAlbum.find((int)albumID));
    }


    private void setButtonToAlbum()
    {
        final Button backBtn = (Button) findViewById(R.id.backToAlbumButton);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToAlbum();
            }
        });

    }

    private void setNewButton()
    {
        final Button newBtn = (Button) findViewById(R.id.newSongButton);

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendID();
            }
        });

    }

    private void sendID() {
        Bundle params = new Bundle();
        params.putLong("id", albumID);
        Intent intent = new Intent(getBaseContext(), NewSongActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void backToAlbum() {
        Bundle params = new Bundle();
        params.putLong("id", album.getArtist().getID());
        Intent intent = new Intent(getBaseContext(), AlbumsActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void setListView() {
        lv = (ListView) findViewById(R.id.songList);
        final ListAdapter songAdapter = new SongAdapter(
                (ArrayList<Song>) dbSong.all(album), getLayoutInflater(), this);
        lv.setAdapter(songAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentAdapter = songAdapter;
                currentPosition = position;
                showPopup(view);
            }
        });

    }

    private void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup, popup.getMenu());
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }

    private void setAlbum()
    {
        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        if(params!=null){
            albumID = params.getLong("id");
        }

        dbAlbum = new SQLiteAlbumDatabase(getApplicationContext());

        dbSong = new SQLiteSongDatabase(getApplicationContext());

        album = dbAlbum.find((int) albumID);
    }

    private void init()
    {
        setAlbum();
        setButtonToAlbum();
        setNewButton();
        setListView();
    }

    private void redirectAlbumEdit(long albumID)
    {
        Bundle params = new Bundle();
        params.putLong("id", albumID);
        Intent intent = new Intent(getBaseContext(), EditAlbumActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void redirectSongEdit(int songID)
    {
        Bundle params = new Bundle();
        params.putLong("id", songID);
        Intent intent = new Intent(getBaseContext(), EditSongActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    public void deleteSong(Song currentSong)
    {
        dbSong = new SQLiteSongDatabase(getApplicationContext());
        dbSong.delete(dbSong.find(currentSong.getID()));
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Song currentSong = dbSong.find((int )currentAdapter.getItemId(currentPosition));
        switch (item.getItemId()) {
            case R.id.action_delete_song:
                deleteSong(currentSong);
                showToast("Song deleted");
                backToAlbum();
                return true;
            case R.id.action_update_song:
                redirectSongEdit(currentSong.getID());
                return true;
            default:
                return false;
        }
    }
}