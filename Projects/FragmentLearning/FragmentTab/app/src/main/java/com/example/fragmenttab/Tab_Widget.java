package com.example.fragmenttab;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Tab_Widget extends TabActivity {

    TabHost tabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_host);

        tabHost = getTabHost();

        tabHost.addTab(tabHost.newTabSpec("Tab1")
                .setIndicator("Tab1")
                .setContent(new Intent().setClass(this, main_activity.class)));

        tabHost.addTab(tabHost.newTabSpec("Tab2")
                .setIndicator("Tab2")
                .setContent(new Intent().setClass(this, second_activity.class)));

        tabHost.addTab(tabHost.newTabSpec("Tab3")
                .setIndicator("Tab3")
                .setContent(new Intent().setClass(this, third_activity.class)));

        tabHost.setCurrentTab(0);
    }
}
