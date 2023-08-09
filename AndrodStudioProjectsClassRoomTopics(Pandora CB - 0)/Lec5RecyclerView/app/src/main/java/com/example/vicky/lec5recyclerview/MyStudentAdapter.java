package com.example.vicky.lec5recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyStudentAdapter extends RecyclerView.Adapter<MyStudentAdapter.MyViewHolder> {

    private ArrayList<Student> studentArrayList;
    private Context context;


    public MyStudentAdapter(ArrayList<Student> students,Context ctx){
        studentArrayList=students;
        context=ctx;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater lif=LayoutInflater.from(context);
        View inflatedView=lif.inflate(R.layout.item_row,viewGroup,false);

        return new MyViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Student currentStudent= studentArrayList.get(i);
        myViewHolder.location.setText(currentStudent.getLocation());
        myViewHolder.number.setText(currentStudent.getNumber());
        myViewHolder.batch.setText(currentStudent.getBatch());
        myViewHolder.name.setText(currentStudent.getName());


    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

       TextView name,batch,number,location;
       Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.studentName);
            batch=itemView.findViewById(R.id.studentBatch);
            number=itemView.findViewById(R.id.studentNumber);
            location=itemView.findViewById(R.id.studentLocation);
            button=itemView.findViewById(R.id.button);
        }
    }
}
