package com.example.vicky.lec4listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> studentList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList.add("vicky");
        studentList.add("amar");
        studentList.add("ashok");
        studentList.add("shivanshu");
        studentList.add("umesh");
        studentList.add("hardik");
        studentList.add("deba");
        studentList.add("vivek");
        studentList.add("vikas");
        studentList.add("mukesh");
        studentList.add("rocky");
        studentList.add("bittu");
        studentList.add("sandeep");
        studentList.add("chandan");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,
                R.layout.list_view,
                R.id.textView,
                studentList);

        final ListView listView = findViewById(R.id.listView);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("TAG", "onItemClick: "+i );

                String studentName=studentList.get(i);
                Toast.makeText(getBaseContext(),studentName,Toast.LENGTH_SHORT).show();
            }
        });
     }
}
