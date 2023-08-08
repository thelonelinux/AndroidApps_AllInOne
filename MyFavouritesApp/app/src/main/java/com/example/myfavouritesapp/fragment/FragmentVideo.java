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

import com.example.myfavouritesapp.CameraActivity.ImagePojo;
import com.example.myfavouritesapp.CameraActivity.MyCameraAdapter;
import com.example.myfavouritesapp.NotepadActivity.NotepadActivity;
import com.example.myfavouritesapp.R;
import com.example.myfavouritesapp.VideoActivity.MyVideoAdapter;
import com.example.myfavouritesapp.VideoActivity.VideoActivity;
import com.example.myfavouritesapp.VideoActivity.VideoPojo;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class FragmentVideo extends Fragment {


    private RecyclerView mRecyclerView;
    private MyVideoAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<VideoPojo> videoPojos =new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        File root = android.os.Environment.getExternalStorageDirectory();
        String path = root.getAbsolutePath() + "/Movies/camera2VideoImage";
        Log.d("Files", "Path: " + path);
        File directory = new File(path);
        File[] files = directory.listFiles();
        assert files != null;
        Log.d("Files", "Size: "+ files.length);

        for (int i = 0; i < files.length; i++) {

            Log.d("Files", "FileName:" + files[i].getName());
            String fileName = files[i].getName();
            String recordingUri = root.getAbsolutePath() + "/Movies/camera2VideoImage" + fileName;

            VideoPojo videoPojo = new VideoPojo(fileName, Uri.parse(recordingUri));
            videoPojos.add(videoPojo);

        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_video,container,false);

        mRecyclerView =view.findViewById(R.id.recyclerViewVideo);
        mLayoutManager =new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter=new MyVideoAdapter(getContext(),videoPojos);
        mRecyclerView.setAdapter(mAdapter);

        final FloatingActionButton fabVideo =(FloatingActionButton)view. findViewById(R.id.fabVideo);
        fabVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabVideo.setTitle("Video opens");
                Intent intent=new Intent(getContext(), VideoActivity.class);
                startActivity(intent);
            }
        });

        Button btnBack=view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().remove(FragmentVideo.this)
                        .commit();
//               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new TabFragment1(), null).addToBackStack(null).commit();
            }
        });

        return view;

    }
}
