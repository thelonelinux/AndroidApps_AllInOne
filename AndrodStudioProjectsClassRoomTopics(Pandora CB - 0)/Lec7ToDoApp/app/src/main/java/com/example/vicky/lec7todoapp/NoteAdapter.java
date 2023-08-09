package com.example.vicky.lec7todoapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyHolder> {

    private ArrayList<Note> noteArrayList;
    private Context ctx;

    public NoteAdapter(ArrayList<Note> noteArrayList, Context ctx) {
        this.noteArrayList = noteArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View inflatedView=LayoutInflater.from(ctx).inflate(R.layout.item_row,viewGroup,false);
        MyHolder myHolder=new MyHolder(inflatedView);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        Note currentNote=noteArrayList.get(i);
        myHolder.noteTv.setText(currentNote.getTitle());

    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        TextView noteTv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            noteTv=itemView.findViewById(R.id.tvNote);
        }
    }
}
