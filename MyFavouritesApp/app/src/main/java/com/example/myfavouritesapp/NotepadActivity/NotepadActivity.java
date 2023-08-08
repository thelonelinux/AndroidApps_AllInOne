package com.example.myfavouritesapp.NotepadActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.JsonWriter;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfavouritesapp.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class NotepadActivity extends AppCompatActivity {

    Button newButton,saveButton,openButton;
    EditText text;
    private NotePojo note;
    private List<NotePojo> noteList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        newButton=(Button)findViewById(R.id.newButton);
        saveButton=(Button)findViewById(R.id.saveButton);
        openButton=(Button)findViewById(R.id.openButton);
        text=(EditText)findViewById(R.id.text);
    }

    public void buttonAction(View v) {
        final EditText fileName=new EditText(this);
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setView(fileName);

        if (v.getId() == R.id.saveButton) {
            ad.setMessage("Save File");

            ad.setPositiveButton("Save",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        FileOutputStream fout = openFileOutput(fileName.getText().toString() + ".txt", Context.MODE_APPEND);
                        fout.write(text.getText().toString().getBytes());

                    }catch(Exception e){
                            Toast.makeText(getApplicationContext(), "Error Occured: " + e, Toast.LENGTH_LONG).show();
                        }

                }
            });

            ad.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            ad.show();

        }

        if(v.getId()==R.id.openButton) {
            ad.setMessage("Open File");

            ad.setPositiveButton("Open",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    int c;
                    text.setText("");

                    try {
                        FileInputStream fin = openFileInput(fileName.getText().toString()+".txt");

                        while ((c = fin.read()) != -1)
                        {
                            text.setText((text.getText().toString() + Character.toString((char) c)));
                        }
                    }catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error Occured: "+e,Toast.LENGTH_LONG).show();
                    }
                }
            });

            ad.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            ad.show();
        }

        if(v.getId()==R.id.newButton) {
            text.setText("");
        }
    }


}