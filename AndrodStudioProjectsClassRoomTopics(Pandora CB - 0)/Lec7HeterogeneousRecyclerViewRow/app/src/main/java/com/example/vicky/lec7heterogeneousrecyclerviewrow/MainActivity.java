package com.example.vicky.lec7heterogeneousrecyclerviewrow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Object> myArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.rvObjects);

        myArrayList.add(new ImageUrl("https://randomuser.me/api/portraits/men/76.jpg"));
        myArrayList.add(new Name("Vicky"));
        myArrayList.add(new ImageUrl("https://randomuser.me/api/portraits/men/72.jpg"));
        myArrayList.add(new Name("Rohit"));
        myArrayList.add(new ImageUrl("https://randomuser.me/api/portraits/men/73.jpg"));
        myArrayList.add(new Name("Rahul"));
        myArrayList.add(new ImageUrl("https://randomuser.me/api/portraits/men/74.jpg"));
        myArrayList.add(new Name("Pankaj"));
        myArrayList.add(new ImageUrl("https://randomuser.me/api/portraits/men/78.jpg"));
        myArrayList.add(new Name("Aryan"));
        myArrayList.add(new ImageUrl("https://randomuser.me/api/portraits/men/79.jpg"));
        myArrayList.add(new Name("Amar"));
        myArrayList.add(new ImageUrl("https://randomuser.me/api/portraits/men/70.jpg"));
        myArrayList.add(new Name("Bhola"));
        myArrayList.add(new ImageUrl("https://randomuser.me/api/portraits/men/71.jpg"));
        myArrayList.add(new ImageUrl("https://randomuser.me/api/portraits/men/3.jpg"));
        myArrayList.add(new Name("Rahu"));
        myArrayList.add(new ImageUrl("https://randomuser.me/api/portraits/men/4.jpg"));
        myArrayList.add(new Name("Pank"));
        myArrayList.add(new ImageUrl("https://randomuser.me/api/portraits/men/8.jpg"));
        myArrayList.add(new Name("Aryan"));

        HeterogeneousAdapter heterogeneousAdapter = new HeterogeneousAdapter(myArrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(heterogeneousAdapter);
    }
}
