   package com.example.bollywoodgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

   public class MainActivity extends AppCompatActivity
   {

       Button b1,button1;
       TextView tv1;
       EditText edittext;
       String movie_name;
       @Override
       protected void onCreate(Bundle savedInstanceState)
       {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
           edittext=(EditText) findViewById(R.id.editText);
           addListenerOnButton();

       }

       public void addListenerOnButton() {

           edittext = (EditText)findViewById(R.id.editText);

           InputFilter filter = new InputFilter() {
               public CharSequence filter(CharSequence source, int start,
                                          int end, Spanned dest, int dstart, int dend) {

                   for (int i = start; i < end; i++) {
                       if (!Character.toString(source.charAt(i)).matches("[a-zA-Z0-9 ]+")) {
                           edittext.setError("Only letters, digits allowed");
                           return "";

                       }
                   }
                   return null;
               }
           };
           edittext.setFilters(new InputFilter[] { filter });




           button1 = (Button) findViewById(R.id.button2);
           button1.setOnClickListener(new View.OnClickListener() {

               public void onClick(View view) {

                   EditText editText = (EditText)findViewById(R.id.editText);
                   String text = editText.getText().toString();
                   Intent myIntent = new Intent(view.getContext(), NextActivity.class);
                   myIntent.putExtra("text", text);
                   startActivity(myIntent);

               }
           });
       }

       @Override
       public boolean onCreateOptionsMenu(Menu menu)
       {
           // Inflate the menu; this adds items to the action bar if it is present.
           getMenuInflater().inflate(R.menu.main, menu);
           return true;
       }




   }