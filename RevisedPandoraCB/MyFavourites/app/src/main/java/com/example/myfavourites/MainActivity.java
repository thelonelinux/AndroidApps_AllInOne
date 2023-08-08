package com.example.myfavourites;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    Button btnNew;
    Button btnView;
    Button btnRemaining;
    Button btnCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnNew =findViewById(R.id.btnNew);
        btnCompleted=findViewById(R.id.btnCompleted);
        btnRemaining=findViewById(R.id.btnRemaining);
        btnView=findViewById(R.id.btnView);




        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),CategoryView.class);
                startActivity(intent);
//                finish();

            }
        });

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(),CategoryNew.class);
                startActivity(intent);
//                finish();
            }
        });

        btnCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(),CategoryComplete.class);
                startActivity(intent);
//                finish();

            }
        });

        btnRemaining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(),CategoryRem.class);
                startActivity(intent);
//                finish();
            }
        });
    }
}
