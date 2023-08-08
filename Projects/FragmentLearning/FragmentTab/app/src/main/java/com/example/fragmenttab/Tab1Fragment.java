package com.example.fragmenttab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class Tab1Fragment extends Fragment {
    LinearLayout mLayout;
    /** (non-Javadoc)
     * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (container == null) {


            return null;
        }

        LinearLayout theLayout = (LinearLayout)inflater.inflate(R.layout.tab_frag1_layout, container, false);

        // Register for the Button.OnClick event

        Button b = (Button)theLayout.findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {



            @Override

            public void onClick(View v) {

                Fragment mFragment = new third_fragment_view();
                android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.container, mFragment);
                ft.addToBackStack(null);
                ft.commit();


            }

        });

        return theLayout;

    }
}
