package com.example.laka.albumcollection.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.laka.albumcollection.R;
import com.example.laka.albumcollection.dao.SQLiteArtistDatabase;
import com.example.laka.albumcollection.models.Artist;



public class NewArtistActivity extends MainActivity {

    private Artist artist;
    private SQLiteArtistDatabase db;
    private EditText nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_artist);
        setListeners();
    }

    private void createArtist(EditText nameField) {

        artist = new Artist(nameField.getText().toString());
        db = new SQLiteArtistDatabase(getApplicationContext());
        db.create(artist);

        showSuccessMessage();
        changeActivity(getBaseContext(), MainActivity.class);
    }


    protected void saveArtist() {
        final Button createCategoryBtn = (Button) findViewById(R.id.createArtist);

        createCategoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameField = (EditText) findViewById(R.id.nameField);
                create();
            }
        });
    }

    private void create() {
        if (isFieldEmpty(nameField)){
            showEmptyFieldToast();
        } else {
            createArtist(nameField);
        }
    }
    private void setButtonToMain() {
        final Button backBtn = (Button) findViewById(R.id.btToArtists);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(getBaseContext(), MainActivity.class);
            }
        });
    }

    private void showSuccessMessage() {
        showNotification("Artist created");
    }

    private void setListeners()
    {
        saveArtist();
        setButtonToMain();
    }
}
