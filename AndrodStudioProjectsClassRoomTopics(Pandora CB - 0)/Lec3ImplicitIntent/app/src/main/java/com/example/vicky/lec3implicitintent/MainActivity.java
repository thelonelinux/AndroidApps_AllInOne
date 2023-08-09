package com.example.vicky.lec3implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent();

//                i.setAction(Intent.ACTION_VIEW);
//
//                i.setData(Uri.parse("https://www.google.com"));

//                i.setAction(Intent.ACTION_DIAL);
//
//                i.setData(Uri.parse("tel://7503307527"));


                i.setAction("vicky-kumar");

//                i.setData(Uri.parse("tel://7503307527"));

                startActivity(i);
            }
        });
    }
}
