package com.example.vicky.onclicklistener;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b=findViewById(R.id.btnText);

         final Context ctx = this;  //we have made context here or has access to context. also here we have used final bcoz in for anonymous class we need to
        //write either final or global the anonymous class (OnClickListener at run time makes the copy of the context so that again it wont be changed.
        //otherwise it wont work properly.

//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        };

        //this below is the best way to add click . since such click has unique key action and can be used in
        //case there are more than one buttons. since each will have their own Onclicklistener.


        //here OnClickListener is the anonymous class to make a click.

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //handle clicks for button1

                //Toast.makeText(getBaseContext(),"hello i am a toast",Toast.LENGTH_SHORT).show();         //another way to get context using getbasebcontext();

                Toast.makeText(MainActivity.this,"Hello I am a toast for 1",Toast.LENGTH_SHORT).show();  //by using own class context

               // Toast.makeText(ctx,"Hello I am a toast",Toast.LENGTH_SHORT).show();   //by using the created context in this class above;
            }
        });

        Button b2 = findViewById(R.id.button2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //handle clicks for button2

                Toast.makeText(ctx,"Hello I am a toast for 2",Toast.LENGTH_LONG).show();   //by using the created context in this class above;

            }
        });



    }
}
