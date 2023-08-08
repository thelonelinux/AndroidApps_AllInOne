package com.example.myfavouritesapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
//import android.widget.Toolbar;

import com.example.myfavouritesapp.AudioRecorderActivity.AudioActivity;
import com.example.myfavouritesapp.CameraActivity.CameraActivity;
import com.example.myfavouritesapp.NotepadActivity.NotepadActivity;
import com.example.myfavouritesapp.PaintActivity.PaintActivity;
import com.example.myfavouritesapp.VideoActivity.VideoActivity;
import com.example.myfavouritesapp.adapter.PagerAdapter;
import com.example.myfavouritesapp.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    /**Permission code;*/

    public static final int PERMISSION_CODE = 12345;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**In the first run of the app Grant the permissions first*/

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED &&
                ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)==PackageManager.PERMISSION_DENIED &&
                ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)==PackageManager.PERMISSION_DENIED &&
        ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED) {

            /**If the app does not have the required permissions, then request those permissions
               This normally happens when the app was installed for the first time*/

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSION_CODE);
        }
        else  if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)==PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

//            Toast.makeText(this , "Permission Granted Already", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "Please enable permissions", Toast.LENGTH_SHORT).show();

        }

        /**For Toolbar and header and TabLayout and viewpager*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("MyFavourites");
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        //with icons

//        tabLayout.addTab(tabLayout.newTab().setText("Android Studio").setIcon(R.drawable.android));
//        tabLayout.addTab(tabLayout.newTab().setText("Visual Studio").setIcon(R.drawable.visualstudio));
//        tabLayout.addTab(tabLayout.newTab().setText("Netbeans").setIcon(R.drawable.netbeans));

        //icons

        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("New"));
        tabLayout.addTab(tabLayout.newTab().setText("Done"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        /**
         * For Floating Action Button in Home Screen*/

//        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
//
//
//
//        final FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_camera);
//        actionA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                actionA.setTitle("Camera opens");
//                Intent intent=new Intent(getBaseContext(), CameraActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//
//
//        final FloatingActionButton actionB =(FloatingActionButton) findViewById(R.id.action_video);
//        actionB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                actionB.setTitle("Video opens");
//                Intent intent=new Intent(getBaseContext(), VideoActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        final FloatingActionButton actionC =(FloatingActionButton) findViewById(R.id.action_notepad);
//        actionC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                actionC.setTitle("Notepad opens");
//                Intent intent=new Intent(getBaseContext(), NotepadActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        final FloatingActionButton actionD =(FloatingActionButton) findViewById(R.id.action_audio);
//        actionD.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                actionD.setTitle("AudioRecorder opens");
//                Intent intent=new Intent(getBaseContext(), AudioActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        final FloatingActionButton actionE =(FloatingActionButton) findViewById(R.id.action_paint);
//        actionE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                actionE.setTitle("AudioRecorder opens");
//                Intent intent=new Intent(getBaseContext(), PaintActivity.class);
//                startActivity(intent);
//            }
//        });
    }


    /**Permission method**/

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_CODE) {
            //Handle the result for location permission

            //Check to see if the permission was granted or not
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2]==PackageManager.PERMISSION_GRANTED && grantResults[3]==PackageManager.PERMISSION_GRANTED) {


                //Location has been granted
                Toast.makeText(this, "Thank you for granting the permission", Toast.LENGTH_SHORT).show();


            } else {

                Toast.makeText(this, "Please enable All the Permissions", Toast.LENGTH_LONG).show();

                new AlertDialog.Builder(this)
                        .setTitle("Permission needed")
                        .setMessage("These permissions are needed for the smooth running of this app")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_EXTERNAL_STORAGE},
                                        PERMISSION_CODE);
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                /**This will close the app activity;**/

                                finish();

//                                onDestroy();
                            }
                        })
                        .create().show();


            }
        }

//        } else {
//                //Permission isn't granted, show another alertdialog to the user telling as to why you need the
//                // permission
//
//
//
//            Toast.makeText(this, "Please grant the location permission", Toast.LENGTH_SHORT).show();
//            finish();
//        }
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }

}