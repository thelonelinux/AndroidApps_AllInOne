package com.example.vicky.lecture3implicitintent;

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

        Button btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);          //action
                intent.setData(Uri.parse("https://www.google.com"));  //data
                //startActivity(i);                 //start of activity intent and this is implicit intent
                                                 //explicit intent was that in which we have written something in one word text in one activity.xml and shown in another
                                                //  activity.xml we have done previously in the class lecture3


                Intent i = new Intent();
                i.setAction("harshit.dwivedi");
                i.putExtra("hello","world");
//                i.setData(Uri.parse("https://www.google.com"));
                startActivity(i);
            }
        });

    }
}
