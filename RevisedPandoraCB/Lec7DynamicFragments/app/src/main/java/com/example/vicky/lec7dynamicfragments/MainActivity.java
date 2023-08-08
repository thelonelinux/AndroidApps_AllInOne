package com.example.vicky.lec7dynamicfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayoutB,new FragmentB())
                .commit();

//        Button btn=findViewById(R.id.addBtn);
//        final EditText etAdd= findViewById(R.id.etAdd);




//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                name=etAdd.getText().toString();
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.frameLayout,new FragmentA(name))
//                        .commit();
//            }
//        });
    }
}
