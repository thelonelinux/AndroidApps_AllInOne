package com.example.vicky.lecture3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //THIS IS EXAMPLE OF EXPLICIT INTENT

       Button btnAlpha2=findViewById(R.id.btnAlpha2);
       final EditText txtAlpha=findViewById(R.id.txtAlpha);
       btnAlpha2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name=txtAlpha.getText().toString();
               Intent i=new Intent(MainActivity.this,SecondActivity.class);     //WE USE TWO ACTIVITY.XML FILES TO RELATE THEM AND HENCE EXPLICIT INTENT
               i.putExtra("KEY",name);
               i.putExtra("KEY2",5);
               startActivity(i);
               finish(); //kills the activity onDestroy won't close the activity;
           }
       });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
