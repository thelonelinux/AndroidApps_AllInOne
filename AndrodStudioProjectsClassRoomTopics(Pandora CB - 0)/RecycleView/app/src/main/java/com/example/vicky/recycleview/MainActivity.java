package com.example.vicky.recycleview;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Omisha", "C++", "131415", "Dwarka"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Omisha", "C++", "131415", "Dwarka"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Omisha", "C++", "131415", "Dwarka"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Omisha", "C++", "131415", "Dwarka"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Omisha", "C++", "131415", "Dwarka"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Omisha", "C++", "131415", "Dwarka"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));
        studentArrayList.add(new Student("Omisha", "C++", "131415", "Dwarka"));
        studentArrayList.add(new Student("Harshit", "Android", "123", "Delhi"));
        studentArrayList.add(new Student("Naman", "Android", "456", "New Delhi"));
        studentArrayList.add(new Student("Ashutosh", "Web", "789", "Dwarka"));
        studentArrayList.add(new Student("Shlok", "Web", "101112", "Pitampura"));


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyStudentAdapter myStudentAdapter = new MyStudentAdapter(studentArrayList,this);
        recyclerView.setAdapter(myStudentAdapter);
    }
}

//    ArrayList<Student> studentsArrayList=new ArrayList<>(); //here ArrayList is using Student class as input data which class is made and hence datas
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        studentsArrayList.add(new Student("harshit","android","123","delhi"));
//        studentsArrayList.add(new Student("vicky","android","123","delhi"));
//        studentsArrayList.add(new Student("hat","android","123","delhi"));
//        studentsArrayList.add(new Student("aakash","webd","126563","dwarka"));
//        studentsArrayList.add(new Student("rohit","droid","881263","space"));
//        studentsArrayList.add(new Student("rohin","android","1263","delhi"));
//        studentsArrayList.add(new Student("batijt","android","1263","delhi"));
//        studentsArrayList.add(new Student("rshjg","android","1263","delhi"));
//        studentsArrayList.add(new Student("rsinjiut","android","1263","delhi"));
//        studentsArrayList.add(new Student("khuyugrsit","android","1263","delhi"));
//        studentsArrayList.add(new Student("kijrsit","android","1263","delhi"));
//        studentsArrayList.add(new Student("rocky","android","1263","delhi"));
//        studentsArrayList.add(new Student("rivki","android","1263","delhi"));
//
//
//        //taking layout list
//        //here listview is layout
//        //studentList is variable assingned to it
//        //this is setting an adapter
//
//        ListView studentList = findViewById(R.id.listView);
//
//
//        //attaching layout to the adapter
//
//        studentList.setAdapter(new MyCustomAdapter());
//
//
//
//
//    }
//
//
//    //now we cant simply use a simple adapter here bcoz we have four textviews and adapter is applicable for only one textviews
//    //so we create our own adapters.
//
//    //so lets an inner class here for adapter
//    //here base adapter is base class which extends array adapter
//
//    //so that base adapter can extract all in .
//
//    //base adapter is an abstract class
//    //so we have to override some of its method
//
//
//    class MyCustomAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return studentsArrayList.size();   //gives how much time the loop runs
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;                 //for getting the item at x position
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;                         //like in whatsapp chat . green for sender and white for receiver. for heterogeneous use only
//        }
//
//
//        //this defines the view of particular row
//
//        @Override
//
//        //here return type is view
//        //view is used for viewing and checking which is inflated and all you know for giving view
//        //at t=0 app is first check and check for object view and out of screen and inflated so null
//        //then check at second and so on and rest ok yaar samajh gya
//
//        public View getView(int i, View view, ViewGroup viewGroup) {
//
//            //now since we have to convert xml into view we need a system service
//            //so we use layout inflater for converting
//            //
//
//            LayoutInflater li=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//            Log.e("TAG","getview:"+ view);
//
//
//            //creating a rowview variabel to make a list. rowview is item_row.xml
//            //it contains layout,viewgroup,and boolean
//            //viewgroup first calculate the size and so gives the view
//            //you know what is viewgroup as in first class.
//            //boolean gives that you want to see view now or not
//            //true means jaise hi inflate hua shoe krdo
//            //false means abhi mat dalo bcoz we want to do some more operations in its view looks
//
//            View rowView=li.inflate(R.layout.item_row,viewGroup,false);  //this line is creating a new view only. empty initially
//            Student currentStudent;   //getting instance of the current student. so we can take name batch number and location.
//            currentStudent = studentsArrayList.get(i);
//
//
//            //this is the modified view
//
//            TextView studentName=rowView.findViewById(R.id.studentName);
//            TextView studentBatch=rowView.findViewById(R.id.studentBatch);        //here onclick wont works
//            TextView studentNumber=rowView.findViewById(R.id.studentNumber);
//            TextView studentLocation=rowView.findViewById(R.id.studentLocation);
//            Button btn=rowView.findViewById(R.id.idBtn);
//
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    //Do something
//                }
//            });
//
//            studentName.setText(currentStudent.getName());        //and so here currrentstudent instance is used.
//            studentBatch.setText(currentStudent.getBatch());
//            studentNumber.setText(currentStudent.getNumber());
//            studentLocation.setText(currentStudent.getLocation());
//
//
//
//            return rowView;
//        }
//    }
//}
