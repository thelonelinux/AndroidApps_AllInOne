package com.example.laka.albumcollection.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.laka.albumcollection.R;
import com.example.laka.albumcollection.adapters.AlbumAdapter;
import com.example.laka.albumcollection.dao.SQLiteAlbumDatabase;
import com.example.laka.albumcollection.dao.SQLiteArtistDatabase;
import com.example.laka.albumcollection.models.Album;
import com.example.laka.albumcollection.models.Artist;

import java.util.ArrayList;
import java.util.List;



public class AlbumsActivity extends MainActivity{
    private long artistID;
    private SQLiteArtistDatabase dbArtist;
    private SQLiteAlbumDatabase dbAlbum;
    private Artist artist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        init();
        setTitle(artist.getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.artist_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete_artist:
                deleteArtist();
                return true;
            case R.id.action_update_artist:
                redirectArtistEdit(artistID);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void redirectArtistEdit(long artistID)
    {
        Bundle params = new Bundle();
        params.putLong("id", artistID);
        Intent intent = new Intent(getBaseContext(), EditArtistActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void deleteArtist()
    {
        delete();
        showToast("Artist deleted");
        gotoMain();
    }

    public void delete()
    {
        dbArtist = new SQLiteArtistDatabase(getApplicationContext());
        dbArtist.delete(dbArtist.find((int) artistID));
    }

    private void setButtonToArtists()
    {
        final Button backBtn = (Button) findViewById(R.id.backToArtistsButton);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoMain();
            }
        });

    }

    private void setNewButton()
    {
        final Button newBtn = (Button) findViewById(R.id.newAlbumButton);

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendID();
            }
        });

    }

    private void sendID() {
        Bundle params = new Bundle();
        params.putLong("id", artistID);
        Intent intent = new Intent(getBaseContext(), NewAlbumActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void setListView() {

        ListView lv = (ListView) findViewById(R.id.albumList);
        final ListAdapter albumAdapter = new AlbumAdapter(
                (ArrayList<Album>) dbAlbum.all(artist), getLayoutInflater(), this);
        lv.setAdapter(albumAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sendID(albumAdapter, position);
            }
        });
    }

    private void sendID(ListAdapter albumAdapter, int position) {
        Bundle params = new Bundle();
        params.putLong("id", albumAdapter.getItemId(position));
        Intent intent = new Intent(getBaseContext(), SongsActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void setDb()
    {
        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        if(params!=null){
            artistID = params.getLong("id");
        }

        dbArtist = new SQLiteArtistDatabase(getApplicationContext());
        dbAlbum = new SQLiteAlbumDatabase(getApplicationContext());
        artist = dbArtist.find((int) artistID);
    }

    private void init()
    {
        setDb();
        setButtonToArtists();
        setNewButton();
        setListView();
    }
}
