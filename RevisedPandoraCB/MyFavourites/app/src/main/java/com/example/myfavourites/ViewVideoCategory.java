package com.example.myfavourites;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ViewVideoCategory extends AppCompatActivity {

    ArrayList<VideoInfo> viewVideoCategories ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_video_category);
        Intent intent =getIntent();

        viewVideoCategories = new ArrayList<>();

        viewVideoCategories.add(new VideoInfo("Video0001", R.drawable.icon));
        viewVideoCategories.add(new VideoInfo("Video0002", R.drawable.img_background));
        viewVideoCategories.add(new VideoInfo("Video0003", R.drawable.icon));
        viewVideoCategories.add(new VideoInfo("Video0004", R.drawable.icon));
        viewVideoCategories.add(new VideoInfo("Video0005", R.drawable.icon));
        viewVideoCategories.add(new VideoInfo("Video0006", R.drawable.img_background));
        viewVideoCategories.add(new VideoInfo("Video0007", R.drawable.icon));
        viewVideoCategories.add(new VideoInfo("Video0008", R.drawable.icon));
        viewVideoCategories.add(new VideoInfo("Video0009", R.drawable.icon));
        viewVideoCategories.add(new VideoInfo("Video0010", R.drawable.img_background));
        viewVideoCategories.add(new VideoInfo("Video0011", R.drawable.icon));
        viewVideoCategories.add(new VideoInfo("Video0012", R.drawable.icon));




        RecyclerView recyclerView = findViewById(R.id.recyclerViewVideo);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(viewVideoCategories,this);
        recyclerView.setAdapter(myCustomAdapter);



    }
}
