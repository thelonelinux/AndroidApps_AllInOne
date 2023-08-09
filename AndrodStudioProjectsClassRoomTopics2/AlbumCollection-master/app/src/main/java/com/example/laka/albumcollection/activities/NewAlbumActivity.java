package com.example.laka.albumcollection.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.laka.albumcollection.R;
import com.example.laka.albumcollection.dao.SQLiteAlbumDatabase;
import com.example.laka.albumcollection.dao.SQLiteArtistDatabase;
import com.example.laka.albumcollection.models.Album;
import com.example.laka.albumcollection.models.Artist;



public class NewAlbumActivity extends MainActivity{
    private long artistID;
    private EditText albumTitleField;
    private Album album;
    private Artist artist;
    private SQLiteArtistDatabase dbArtist;
    private SQLiteAlbumDatabase dbAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_album);
        init();
        setTitle("New album");
    }

    private void setArtist()
    {
        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        if(params!=null){
            artistID = params.getLong("id");
        }
        dbArtist = new SQLiteArtistDatabase(getApplicationContext());
        artist = dbArtist.find((int) artistID);
    }

    private void create() {
        if (isFieldEmpty(albumTitleField)){
            showEmptyFieldToast();
        } else {
            createAlbum(albumTitleField);
        }
    }

    private void createAlbum(EditText nameField) {

        album = new Album((nameField.getText().toString()), artist);
        dbAlbum = new SQLiteAlbumDatabase(getApplicationContext());

        dbAlbum.create(album);

        showSuccessMessage();
        redirectToArtist(artist);
    }

    protected void saveAlbum() {
        final Button createCategoryBtn = (Button) findViewById(R.id.createAlbum);

        createCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                albumTitleField = (EditText) findViewById(R.id.albumTitleField);
                create();
            }
        });
    }

    protected void backToArtist() {
        final Button createCategoryBtn = (Button) findViewById(R.id.backToArtistsButton);

        createCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToArtist(artist);
            }
        });
    }

    private void showSuccessMessage() {
        showNotification("Album created");
    }

    private void redirectToArtist(Artist artist)
    {
        Bundle params = new Bundle();
        params.putLong("id", artist.getID());
        Intent intent = new Intent(getBaseContext(), AlbumsActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void init()
    {
        setArtist();
        saveAlbum();
        backToArtist();
    }
}
