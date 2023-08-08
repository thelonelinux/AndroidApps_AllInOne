package com.example.vicky.lec5recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentArrayList.add(new Student("Vicky","Android","1234","Delhi"));
        studentArrayList.add(new Student("Rohit","Pandora","4567","New Delhi"));
        studentArrayList.add(new Student("Yogesh","Web","189234","Old Delhi"));
        studentArrayList.add(new Student("Rakesh","Elixir","7251234","Dwarka"));
        studentArrayList.add(new Student("Vikas","Android","1238954","Delhi"));
        studentArrayList.add(new Student("Ramesh","Android","0471234","New Delhi"));
        studentArrayList.add(new Student("Teak","Elixir","1234","Dwarka"));
        studentArrayList.add(new Student("Vicky","Pandora","750330","Delhi"));
        studentArrayList.add(new Student("Rakesh","Android","1234","Old Delhi"));
        studentArrayList.add(new Student("Rohit","Elixir","1234","Dwarka"));
        studentArrayList.add(new Student("Vicky","Android","750330","CP"));
        studentArrayList.add(new Student("Teaky","Web","1234","Dwarka"));
        studentArrayList.add(new Student("Vickteak","Elixir","1234","Old Delhi"));
        studentArrayList.add(new Student("Vikas","Pandora","750330","CP"));
        studentArrayList.add(new Student("Vikas","Android","1238954","Delhi"));
        studentArrayList.add(new Student("Ramesh","Android","0471234","New Delhi"));
        studentArrayList.add(new Student("Teak","Elixir","1234","Dwarka"));
        studentArrayList.add(new Student("Vicky","Pandora","750330","Delhi"));
        studentArrayList.add(new Student("Rakesh","Android","1234","Old Delhi"));
        studentArrayList.add(new Student("Rohit","Elixir","1234","Dwarka"));
        studentArrayList.add(new Student("Vicky","Android","750330","CP"));
        studentArrayList.add(new Student("Teaky","Web","1234","Dwarka"));
        studentArrayList.add(new Student("Vickteak","Elixir","1234","Old Delhi"));
        studentArrayList.add(new Student("Vikas","Pandora","750330","CP"));
        studentArrayList.add(new Student("Vikas","Android","1238954","Delhi"));
        studentArrayList.add(new Student("Ramesh","Android","0471234","New Delhi"));
        studentArrayList.add(new Student("Teak","Elixir","1234","Dwarka"));
        studentArrayList.add(new Student("Vicky","Pandora","750330","Delhi"));
        studentArrayList.add(new Student("Rakesh","Android","1234","Old Delhi"));
        studentArrayList.add(new Student("Rohit","Elixir","1234","Dwarka"));
        studentArrayList.add(new Student("Vicky","Android","750330","CP"));
        studentArrayList.add(new Student("Teaky","Web","1234","Dwarka"));
        studentArrayList.add(new Student("Vickteak","Elixir","1234","Old Delhi"));
        studentArrayList.add(new Student("Vikas","Pandora","750330","CP"));
        studentArrayList.add(new Student("Vikas","Android","1238954","Delhi"));
        studentArrayList.add(new Student("Ramesh","Android","0471234","New Delhi"));
        studentArrayList.add(new Student("Teak","Elixir","1234","Dwarka"));
        studentArrayList.add(new Student("Vicky","Pandora","750330","Delhi"));
        studentArrayList.add(new Student("Rakesh","Android","1234","Old Delhi"));
        studentArrayList.add(new Student("Rohit","Elixir","1234","Dwarka"));
        studentArrayList.add(new Student("Vicky","Android","750330","CP"));
        studentArrayList.add(new Student("Teaky","Web","1234","Dwarka"));
        studentArrayList.add(new Student("Vickteak","Elixir","1234","Old Delhi"));
        studentArrayList.add(new Student("Vikas","Pandora","750330","CP"));

        RecyclerView recyclerView=findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyStudentAdapter myStudentAdapter=new MyStudentAdapter(studentArrayList,this);
        recyclerView.setAdapter(myStudentAdapter);
    }
}
