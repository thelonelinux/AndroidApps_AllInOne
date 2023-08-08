package com.example.myfavouritesapp.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myfavouritesapp.AudioRecorderActivity.AudioActivity;
import com.example.myfavouritesapp.CameraActivity.CameraActivity;
import com.example.myfavouritesapp.NotepadActivity.NotepadActivity;
import com.example.myfavouritesapp.PaintActivity.PaintActivity;
import com.example.myfavouritesapp.R;
import com.example.myfavouritesapp.VideoActivity.VideoActivity;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.Objects;

public class TabFragment1 extends Fragment {

    private Intent intent;





    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.tab_fragment1, container, false);

        final View rootView =  inflater.inflate(R.layout.tab_fragment1, container, false);

//        intent = new Intent(getActivity(), RecordingListActivity.class);
//        tvAudio = (TextView) rootView.findViewById(R.id.tvAudio);
//        tvAudio.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                startActivity(intent);
//            }
//        });
//
//        intent = new Intent(getActivity(), RecordingListActivity.class);
//        //    TextView tvAudio;
//        line1Audio.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                startActivity(intent);
//            }
//        });



        /**For Floating Action Button
         * In the HomeButton TabLayout
         * */

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu)rootView. findViewById(R.id.multiple_actions);



        final FloatingActionButton actionA = (FloatingActionButton)rootView. findViewById(R.id.action_camera);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionA.setTitle("Camera opens");
                Intent intent=new Intent(getContext(), CameraActivity.class);
                startActivity(intent);

            }
        });



        final FloatingActionButton actionB =(FloatingActionButton)rootView. findViewById(R.id.action_video);
        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionB.setTitle("Video opens");
                Intent intent=new Intent(getContext(), VideoActivity.class);
                startActivity(intent);
            }
        });


        final FloatingActionButton actionC =(FloatingActionButton)rootView. findViewById(R.id.action_notepad);
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionC.setTitle("Notepad opens");
                Intent intent=new Intent(getContext(), NotepadActivity.class);
                startActivity(intent);
            }
        });

        final FloatingActionButton actionD =(FloatingActionButton)rootView. findViewById(R.id.action_audio);
        actionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionD.setTitle("AudioRecorder opens");
                Intent intent=new Intent(getContext(), AudioActivity.class);
                startActivity(intent);
            }
        });

        final FloatingActionButton actionE =(FloatingActionButton)rootView. findViewById(R.id.action_paint);
        actionE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionE.setTitle("AudioRecorder opens");
                Intent intent=new Intent(getContext(), PaintActivity.class);
                startActivity(intent);
            }
        });


        /** For the category, (Video, Audio, Notepad, Paint , Camera, Others)
         * onclick Handled Here
         *
         */



        final LinearLayout line1Audio = (LinearLayout)rootView.findViewById(R.id.line1Audio);

        line1Audio.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {

                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayout,new FragmentAudio())
                        .commit();

            }
        });

        final LinearLayout line1Video = (LinearLayout)rootView.findViewById(R.id.line1Video);

        line1Video.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {

                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayout,new FragmentVideo())
                        .commit();

            }
        });

        final LinearLayout line2Notepad = (LinearLayout)rootView.findViewById(R.id.line2Notepad);

        line2Notepad.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {

                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayout,new FragmentNotepad())
                        .commit();

            }
        });

        final LinearLayout line2Paint = (LinearLayout)rootView.findViewById(R.id.line2Paint);

        line2Paint.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {

                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayout,new FragmentPaint())
                        .commit();

            }
        });

        final LinearLayout line3Camera = (LinearLayout)rootView.findViewById(R.id.line3Camera);

        line3Camera.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {

                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayout,new FragmentCamera())
                        .commit();

            }
        });


        final LinearLayout line3Others = (LinearLayout)rootView.findViewById(R.id.line3Others);

        line3Others.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {

                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                        .add(R.id.frameLayout,new FragmentOthers())
                        .commit();

            }
        });


        return rootView;


    }

}
