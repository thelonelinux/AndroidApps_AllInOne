package com.example.vicky.clickhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn);
        Button button2 = findViewById(R.id.btn2);
        TextView textView = findViewById(R.id.message);

        textView.setOnClickListener(this);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Handle the clicks here
        switch (v.getId()){
            case  R.id.btn :
                //Handle first button click
                break;
            case R.id.btn2:
                //Handle second button click
                break;
            case R.id.message:
                //Handle textView click
                break;
        }
    }
}
