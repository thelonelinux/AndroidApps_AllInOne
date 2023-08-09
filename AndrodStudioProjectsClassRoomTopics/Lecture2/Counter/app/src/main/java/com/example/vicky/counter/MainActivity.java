package com.example.vicky.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview=findViewById(R.id.EditText1);
        button=findViewById(R.id.button1);
        button=findViewById(R.id.button2);
        button=findViewById(R.id.button3);


    }
}
