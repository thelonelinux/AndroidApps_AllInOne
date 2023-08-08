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

import com.example.myfavouritesapp.AudioRecorderActivity.Recording;
import com.example.myfavouritesapp.AudioRecorderActivity.RecordingAdapter;
import com.example.myfavouritesapp.CameraActivity.CameraActivity;
import com.example.myfavouritesapp.CameraActivity.ImagePojo;
import com.example.myfavouritesapp.CameraActivity.MyCameraAdapter;
import com.example.myfavouritesapp.PaintActivity.PaintActivity;
import com.example.myfavouritesapp.R;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class FragmentCamera extends Fragment {

    private RecyclerView mRecyclerView;
    private MyCameraAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ImagePojo> imagePojos =new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        File root = android.os.Environment.getExternalStorageDirectory();
        String path = root.getAbsolutePath() + "/CustomImage";
        Log.d("Files", "Path: " + path);
        File directory = new File(path);
        File[] files = directory.listFiles();
        assert files != null;
        Log.d("Files", "Size: "+ files.length);

        for (int i = 0; i < files.length; i++) {

            Log.d("Files", "FileName:" + files[i].getName());
            String fileName = files[i].getName();
            String recordingUri = root.getAbsolutePath() + "/CustomImage" + fileName;

            ImagePojo imagePojo = new ImagePojo(fileName, Uri.parse(recordingUri));
            imagePojos.add(imagePojo);

        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_camera,container,false);


        mRecyclerView =view.findViewById(R.id.recyclerViewImages);
        mLayoutManager =new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter=new MyCameraAdapter(getContext(),imagePojos);
        mRecyclerView.setAdapter(mAdapter);

        final FloatingActionButton fabCamera =(FloatingActionButton)view. findViewById(R.id.fabCamera);
        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabCamera.setTitle("NotePad opens");
                Intent intent=new Intent(getContext(), CameraActivity.class);
                startActivity(intent);
            }
        });

        Button btnBack=view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().remove(FragmentCamera.this)
                        .commit();
//               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new TabFragment1(), null).addToBackStack(null).commit();
            }
        });

        return view;

    }
}
