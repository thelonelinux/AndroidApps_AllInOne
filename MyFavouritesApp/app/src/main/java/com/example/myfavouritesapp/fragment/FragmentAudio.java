package com.example.myfavouritesapp.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
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

import com.example.myfavouritesapp.AudioRecorderActivity.AudioActivity;
import com.example.myfavouritesapp.AudioRecorderActivity.Recording;
import com.example.myfavouritesapp.AudioRecorderActivity.RecordingAdapter;
import com.example.myfavouritesapp.R;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

@SuppressLint("ValidFragment")
public class FragmentAudio extends Fragment {

    private RecyclerView mRecyclerView;
    private RecordingAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Recording> recordingArrayList=new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        File root = android.os.Environment.getExternalStorageDirectory();
        String path = root.getAbsolutePath() + "/VoiceRecorderSimplifiedCoding/Audios";
        Log.d("Files", "Path: " + path);
        File directory = new File(path);
        File[] files = directory.listFiles();
        assert files != null;
        Log.d("Files", "Size: "+ files.length);

        for (int i = 0; i < files.length; i++) {

            Log.d("Files", "FileName:" + files[i].getName());
            String fileName = files[i].getName();
            String recordingUri = root.getAbsolutePath() + "/VoiceRecorderSimplifiedCoding/Audios/" + fileName;

            Recording recording = new Recording(recordingUri,fileName,false);
            recordingArrayList.add(recording);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_audio,container,false);

        mRecyclerView =view.findViewById(R.id.recyclerViewRecordings);
        mLayoutManager =new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter=new RecordingAdapter(getContext(),recordingArrayList);
        mRecyclerView.setAdapter(mAdapter);

        final FloatingActionButton actionD =(FloatingActionButton)view. findViewById(R.id.fabVoice);
        actionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionD.setTitle("AudioRecorder opens");
                Intent intent=new Intent(getContext(), AudioActivity.class);
                startActivity(intent);
            }
        });

        Button btnBack=view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().remove(FragmentAudio.this)
                        .commit();
//               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new TabFragment1(), null).addToBackStack(null).commit();
            }
        });




        return view;
    }


}
