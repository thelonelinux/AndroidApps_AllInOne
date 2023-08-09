package com.example.vicky.lecture4;

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

    ArrayList<String> studentList=new ArrayList<>();  //we made an arraylist named as studentList

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //putiing values in arraylist

        studentList.add("vicky");
        studentList.add("vikas");
        studentList.add("vikrant");
        studentList.add("vishal");
        studentList.add("vimal");
        studentList.add("vat");
        studentList.add("amar");
        studentList.add("umesh");
        studentList.add("Shlok");
        studentList.add("Omisha");
        studentList.add("Sasha");
        studentList.add("Biswaroop");
        studentList.add("Ansh");
        studentList.add("Sambhav");
        studentList.add("Kapil");
        studentList.add("Aman");
        studentList.add("Anurag");
        studentList.add("Vicky");
        studentList.add("Abha");
        studentList.add("Shivani");



        //this array adapter is used for listing the data into the given layout

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,
        R.layout.list_item,
                R.id.studentName,
                studentList);   //this contains layout,in which text to enter, and which arraylist is added
//
//        final ListView studentListView=findViewById(R.id.listViewStudents);
//        stu dentList.setAdapter(arrayAdapter);


        //now bring in the list from main xml

        final ListView studentListView=findViewById(R.id.listViewStudents);  //final means you cannot allocate a new memory of it. it canot be initialised again

        //attach adapter to it

        studentListView.setAdapter(arrayAdapter);   //upto here also can run the list or adapter.


        //now we are making toaster
        //which on clicking get the number it has

        //here int i is giving the current position

        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("TAG","onItemClick"+i);
                String studentName=studentList.get(i);
                Toast.makeText(getBaseContext(),studentName,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
