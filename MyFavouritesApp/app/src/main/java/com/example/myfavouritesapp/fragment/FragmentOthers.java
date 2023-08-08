package com.example.myfavouritesapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfavouritesapp.CameraActivity.CameraActivity;
import com.example.myfavouritesapp.R;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class FragmentOthers extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_others,container,false);

        final FloatingActionButton fabOthers =(FloatingActionButton)view. findViewById(R.id.fabOthers);
        fabOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabOthers.setTitle("Pdf reader Opens opens");
//                Intent intent=new Intent(getContext(), CameraActivity.class);
//                startActivity(intent);
            }
        });

        Button btnBack=view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().remove(FragmentOthers.this)
                        .commit();
//               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new TabFragment1(), null).addToBackStack(null).commit();
            }
        });

        return view;

    }
}
