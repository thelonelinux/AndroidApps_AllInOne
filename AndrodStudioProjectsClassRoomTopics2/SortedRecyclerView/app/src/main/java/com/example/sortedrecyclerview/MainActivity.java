package com.example.sortedrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
    private ArrayAdapter<String> mListViewAdapter;
    private ExampleAdapter mRecyclerViewAdapter;
    private String[] mArrayNames = new String[]{"Daryl", "Rick", "Abraham", "Eugene"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();
        buildListView();

        Button buttonSort = findViewById(R.id.button_sort);
        buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortArray();
                sortArrayList();
            }
        });
    }

    private void sortArray() {
        Arrays.sort(mArrayNames);
        mListViewAdapter.notifyDataSetChanged();
    }

    private void sortArrayList() {
        Collections.sort(mExampleList, new Comparator<ExampleItem>() {
            @Override
            public int compare(ExampleItem o1, ExampleItem o2) {
                return o1.getText2().compareTo(o2.getText2());
            }
        });

        mRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "Daryl", "Dixon"));
        mExampleList.add(new ExampleItem(R.drawable.ic_audio, "Rick", "Grimes"));
        mExampleList.add(new ExampleItem(R.drawable.ic_sun, "Abraham", "Ford"));
        mExampleList.add(new ExampleItem(R.drawable.ic_android, "Eugene", "Porter"));
    }

    private void buildRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerViewAdapter = new ExampleAdapter(mExampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mRecyclerViewAdapter);
    }

    private void buildListView() {
        ListView listView = findViewById(R.id.listView);
        mListViewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mArrayNames);
        listView.setAdapter(mListViewAdapter);
    }
}