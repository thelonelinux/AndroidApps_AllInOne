package com.example.vicky.listviewcustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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

        ListView listView=findViewById(R.id.listView);
        listView.setAdapter(new MyCustomAdapter());

    }

    class MyCustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return studentArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater li= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

//            View rowView=li.inflate(R.layout.list_item,viewGroup,false);

            View rowView;
            if (view==null){
                rowView=li.inflate(R.layout.list_item,viewGroup,false);

                ViewHolder viewHolder=new ViewHolder(rowView);

//                viewHolder.batch=rowView.findViewById(R.id.studentBatch);
//                viewHolder.name=rowView.findViewById(R.id.studentName);
//                viewHolder.location=rowView.findViewById(R.id.studentLocation);
//                viewHolder.number=rowView.findViewById(R.id.studentNumber);
//                viewHolder.btn=rowView.findViewById(R.id.button);

                rowView.setTag(viewHolder);

            } else {
                rowView=view;
            }

            Student currentStudent = studentArrayList.get(i);

            ViewHolder vh= (ViewHolder) rowView.getTag();

            vh.name.setText(currentStudent.getName());
            vh.number.setText(currentStudent.getNumber());
            vh.batch.setText(currentStudent.getBatch());
            vh.location.setText(currentStudent.getLocation());


            vh.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

//            TextView studentName=rowView.findViewById(R.id.studentName);
//            TextView studentBatch=rowView.findViewById(R.id.studentBatch);
//            TextView studentNumber=rowView.findViewById(R.id.studentNumber);
//            TextView studentLocation=rowView.findViewById(R.id.studentLocation);

//            studentName.setText(currentStudent.getName());
//            studentBatch.setText(currentStudent.getBatch());
//            studentNumber.setText(currentStudent.getNumber());
//            studentLocation.setText(currentStudent.getLocation());

//            Button button=rowView.findViewById(R.id.button);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    //do whatever you wnat to do for button onclick here;
//                }
//            });

            return rowView;
        }
    }

    class ViewHolder{
        TextView name,batch,number,location;
        Button btn;

        public ViewHolder(View inflatedView){
            batch=inflatedView.findViewById(R.id.studentBatch);
            name=inflatedView.findViewById(R.id.studentName);
            number=inflatedView.findViewById(R.id.studentNumber);
            location=inflatedView.findViewById(R.id.studentLocation);
            btn=inflatedView.findViewById(R.id.button);
        }
    }
}
