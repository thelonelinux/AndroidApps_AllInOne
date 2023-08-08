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



public class EditArtistActivity extends MainActivity{
    private Artist artist;
    private long artistID;
    private SQLiteArtistDatabase dbArtist;
    private EditText artistNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_artist);
        init();
        setTitle("Edit artist");
    }

    private void setAlbum()
    {
        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        if(params!=null){
            artistID = params.getLong("id");
        }

        dbArtist = new SQLiteArtistDatabase(getApplicationContext());
        artist = dbArtist.find((int) artistID);
    }


    private void edit() {
        if (isFieldEmpty(artistNameField)){
            showEmptyFieldToast();
        } else {
            editArtist(artistNameField);
        }
    }

    private void backToMain() {
        final Button createCategoryBtn = (Button) findViewById(R.id.edit_backToMainButton);

        createCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoMain();
            }
        });
    }

    private void editArtist(EditText artistNameField) {

        Artist newArtist = new Artist(artist.getID(), (artistNameField.getText().toString()));

        dbArtist = new SQLiteArtistDatabase(getApplicationContext());
        dbArtist.update(newArtist);

        showSuccessMessage();
        gotoMain();
    }

    protected void saveArtist() {
        final Button createCategoryBtn = (Button) findViewById(R.id.edit_createArtist);

        createCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit();
            }
        });
    }

    private void setFields()
    {
        artistNameField = (EditText) findViewById(R.id.edit_artistNameField);
        artistNameField.setText(artist.getName());
    }

    private void showSuccessMessage() {
        showToast("Artist saved");
    }

    private void init()
    {
        setAlbum();
        setFields();
        saveArtist();
        backToMain();
    }
}
