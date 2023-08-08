package com.example.fragmenttab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class main_fragment extends Fragment
{
    LinearLayout mLayout;
    Button mButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mLayout = (LinearLayout) inflater.inflate(R.layout.main_view, null);
        mButton = (Button) mLayout.findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Fragment mFragment = new third_fragment_view();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
//              ft.replace(R.id.Maincontainer, mFragment);
                ft.replace(R.id.main_fragment, mFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return mLayout;
    }
}