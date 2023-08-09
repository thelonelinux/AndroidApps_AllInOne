package com.example.laka.albumcollection.activities;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.laka.albumcollection.R;
import com.example.laka.albumcollection.dao.SQLiteAlbumDatabase;
import com.example.laka.albumcollection.dao.SQLiteArtistDatabase;
import com.example.laka.albumcollection.dao.SQLiteSongDatabase;
import com.example.laka.albumcollection.models.Album;import com.example.laka.albumcollection.models.Song;

public class NewSongActivity extends MainActivity {
    private long albumID;
    private EditText songTitleField;
    private EditText trackNumberField;
    private Album album;
    private Song song;
    private SQLiteSongDatabase dbSong;
    private SQLiteAlbumDatabase dbAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);
        init();
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
    }

    private void create() {
        if (isFieldEmpty(songTitleField) || isFieldEmpty(trackNumberField)){
            showEmptyFieldToast();
        } else {
            createSong(songTitleField);
        }
    }

    private void createSong(EditText titleField) {

        song = new Song((titleField.getText().toString()), Integer.parseInt(trackNumberField.getText().toString()), album);
        dbSong = new SQLiteSongDatabase(getApplicationContext());
        dbSong.create(song);

        showSuccessMessage();
        redirectToAlbum(album);
    }

    protected void saveSong() {
        final Button createCategoryBtn = (Button) findViewById(R.id.createSong);

        createCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                songTitleField = (EditText) findViewById(R.id.songTitleField);
                trackNumberField = (EditText) findViewById(R.id.track);
                create();
            }
        });
    }

    private void backToAlbum() {
        final Button createCategoryBtn = (Button) findViewById(R.id.backToAlbumNew);

        createCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToAlbum(album);
            }
        });
    }

    private void showSuccessMessage() {
        showNotification("Song created");
    }

    private void redirectToAlbum(Album album)
    {
        Bundle params = new Bundle();
        params.putLong("id", album.getID());
        Intent intent = new Intent(getBaseContext(), SongsActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void init()
    {
        setAlbum();
        saveSong();
        backToAlbum();
    }
}
