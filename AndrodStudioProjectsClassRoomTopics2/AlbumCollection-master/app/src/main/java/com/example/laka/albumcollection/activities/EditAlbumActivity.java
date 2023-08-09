package com.example.laka.albumcollection.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.laka.albumcollection.R;
import com.example.laka.albumcollection.dao.SQLiteAlbumDatabase;
import com.example.laka.albumcollection.dao.SQLiteSongDatabase;
import com.example.laka.albumcollection.models.Album;
import com.example.laka.albumcollection.models.Artist;
import com.example.laka.albumcollection.models.Song;



public class EditAlbumActivity extends MainActivity{
    private Artist artist;
    private Album album;
    private long albumID;
    private SQLiteAlbumDatabase dbAlbum;
    private EditText albumTitleField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_album);
        init();
        setTitle("Edit album");
    }

    private void setAlbum()
    {
        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        if(params!=null){
            albumID = params.getLong("id");
        }

        dbAlbum = new SQLiteAlbumDatabase(getApplicationContext());
        album = dbAlbum.find((int) albumID);
        artist = album.getArtist();
    }

    private void redirectToArtist(Artist artist)
    {
        Bundle params = new Bundle();
        params.putLong("id", artist.getID());
        Intent intent = new Intent(getBaseContext(), AlbumsActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void backToArtist() {
        final Button createCategoryBtn = (Button) findViewById(R.id.edit_backToArtistsButton);

        createCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToArtist(artist);
            }
        });
    }
    private void edit() {
        if (isFieldEmpty(albumTitleField)){
            showEmptyFieldToast();
        } else {
            editAlbum(albumTitleField);
        }
    }

    private void editAlbum(EditText albumTitleField) {

        Album newAlbum = new Album(album.getID(), (albumTitleField.getText().toString()), artist);
        dbAlbum = new SQLiteAlbumDatabase(getApplicationContext());
        dbAlbum.update(newAlbum);

        showSuccessMessage();
        redirectToArtist(artist);
    }

    protected void saveAlbum() {
        final Button createCategoryBtn = (Button) findViewById(R.id.edit_createAlbum);

        createCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit();
            }
        });
    }

    private void showSuccessMessage() {
        showToast("Album saved");
    }

    private void setFields()
    {
        albumTitleField = (EditText) findViewById(R.id.edit_albumTitleField);
        albumTitleField.setText(album.getTitle());
    }

    private void init()
    {
        setAlbum();
        setFields();
        saveAlbum();
        backToArtist();
    }
}