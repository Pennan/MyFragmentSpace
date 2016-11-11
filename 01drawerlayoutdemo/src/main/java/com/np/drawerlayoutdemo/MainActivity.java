package com.np.drawerlayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * https://www.sitepoint.com/material-design-android-design-support-library/
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void actionBarClick(View view) {
        startActivity(new Intent(this, ActionBarDrawerLayoutActivity.class));
    }

    public void toolbarClick(View view) {
        startActivity(new Intent(this, ToolbarDrawerLayoutActivity.class));
    }
}
