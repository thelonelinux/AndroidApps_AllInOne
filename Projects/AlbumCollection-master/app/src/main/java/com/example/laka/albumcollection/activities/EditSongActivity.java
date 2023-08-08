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
import com.example.laka.albumcollection.models.Song;



public class EditSongActivity extends MainActivity{
    private Song song;
    private Album album;
    private long songID;
    private SQLiteSongDatabase dbSong;
    private EditText songTitleField;
    private EditText trackNumberField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);
        init();
        setTitle("Editing song");
    }

    private void setSong()
    {
        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        if(params!=null){
            songID = params.getLong("id");
        }

        dbSong = new SQLiteSongDatabase(getApplicationContext());
        song = dbSong.find((int) songID);
        album = song.getAlbum();
    }

    private void redirectToAlbum(Album album)
    {
        Bundle params = new Bundle();
        params.putLong("id", album.getID());
        Intent intent = new Intent(getBaseContext(), SongsActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    private void backToAlbum() {
        final Button createCategoryBtn = (Button) findViewById(R.id.edit_backToAlbumNew);

        createCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToAlbum(album);
            }
        });
    }
    private void edit() {
        if (isFieldEmpty(songTitleField) || isFieldEmpty(trackNumberField)){
            showEmptyFieldToast();
        } else {
            editSong(songTitleField);
        }
    }

    private void editSong(EditText titleField) {

        Song newSong = new Song(song.getID(), (titleField.getText().toString()), Integer.parseInt(trackNumberField.getText().toString()), album);
        dbSong = new SQLiteSongDatabase(getApplicationContext());
        dbSong.update(newSong);

        showSuccessMessage();
        redirectToAlbum(album);
    }

    protected void saveSong() {
        final Button createCategoryBtn = (Button) findViewById(R.id.edit_createSong);

        createCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit();
            }
        });
    }

    private void setFields()
    {
        songTitleField = (EditText) findViewById(R.id.edit_songTitleField);
        trackNumberField = (EditText) findViewById(R.id.edit_track);
        songTitleField.setText(song.getTitle());
        trackNumberField.setText(String.valueOf(song.getPosition()));
    }

    private void showSuccessMessage() {
        showToast("Song saved");
    }

    private void init()
    {
        setSong();
        saveSong();
        backToAlbum();
        setFields();
    }

}
