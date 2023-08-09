package com.example.myfavourites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryView extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_category);

        Intent intent=getIntent();

        TextView tvVideo=findViewById(R.id.tvVideo);
        TextView tvAudio=findViewById(R.id.tvAudio);
        TextView tvNotepad=findViewById(R.id.tvNotepad);
        TextView tvPaint=findViewById(R.id.tvPaint);
        TextView tvCamera=findViewById(R.id.tvCamera);
        TextView tvOthers=findViewById(R.id.tvOthers);


        tvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CategoryView.this,ViewVideoCategory.class);
                startActivity(intent);

            }
        });





    }
}
