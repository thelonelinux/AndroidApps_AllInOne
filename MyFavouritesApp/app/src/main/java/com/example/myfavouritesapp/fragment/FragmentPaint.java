package com.example.myfavouritesapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfavouritesapp.PaintActivity.*;
import com.example.myfavouritesapp.PaintActivity.MyPaintAdapter;
import com.example.myfavouritesapp.PaintActivity.PaintActivity;
import com.example.myfavouritesapp.PaintActivity.PaintPojo;
import com.example.myfavouritesapp.R;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class FragmentPaint extends Fragment {


    private RecyclerView mRecyclerView;
    private MyPaintAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<PaintPojo> paintPojos =new ArrayList<>();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        File root = android.os.Environment.getExternalStorageDirectory();
        String path = root.getAbsolutePath() + "/Pictures";
        Log.d("Files", "Path: " + path);
        File directory = new File(path);
        File[] files = directory.listFiles();
        assert files != null;
        Log.d("Files", "Size: "+ files.length);

        for (int i = 0; i < files.length; i++) {

            Log.d("Files", "FileName:" + files[i].getName());
            String fileName = files[i].getName();
            String recordingUri = root.getAbsolutePath() + "/Pictures" + fileName;

            PaintPojo paintPojo=new PaintPojo(fileName,Uri.parse(recordingUri));
            paintPojos.add(paintPojo);

        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_paint,container,false);

        mRecyclerView =view.findViewById(R.id.recyclerViewPaint);
        mLayoutManager =new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter=new MyPaintAdapter(getContext(),paintPojos);
        mRecyclerView.setAdapter(mAdapter);


        final FloatingActionButton fabPaint =(FloatingActionButton)view. findViewById(R.id.fabPaint);
        fabPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabPaint.setTitle("NotePad opens");
                Intent intent=new Intent(getContext(), PaintActivity.class);
                startActivity(intent);
            }
        });

        Button btnBack=view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().remove(FragmentPaint.this)
                        .commit();
//               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new TabFragment1(), null).addToBackStack(null).commit();
            }
        });

        return view;

    }
}
