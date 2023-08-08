package com.example.vicky.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    TextView textView;
    int add=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        textView=findViewById(R.id.textView);


    }

    public void addition(View view) {
        String num1=editText.getText().toString();
        String num2=editText2.getText().toString();
        final int n1=Integer.parseInt(num1);
        final int n2=Integer.parseInt(num2);
        add=n1+n2;
        textView.setText(String.valueOf(add));
    }

    public void subtraction(View view) {
        String num1=editText.getText().toString();
        String num2=editText2.getText().toString();
        final int n1=Integer.parseInt(num1);
        final int n2=Integer.parseInt(num2);
        int sub=n1-n2;
        textView.setText(String.valueOf(sub));


    }
}
