package com.example.buttonclickinsidefragmentopennewfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create new fragment and transaction
        Fragment newFragment = new ExampleFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();


        Button btnSearch = (Button) view.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnSearch:
                        FragmentHome home = new FragmentHome();  //this is your new fragment.
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.activity_main_content_fragment, home);
                        ft.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);// it will anim while calling fragment.
                        ft.addToBackStack(null); // it will manage back stack of fragments.
                        ft.commit();
                        break;
                }
            }
        });

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new fragmentClass())
                .addToBackStack(null).commitAllowingStateLoss();
    }
}
