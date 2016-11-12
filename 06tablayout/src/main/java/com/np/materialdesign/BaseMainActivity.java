package com.np.materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.np.materialdesign.activity.CustomTabActivity;
import com.np.materialdesign.activity.MainActivity;

public class BaseMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_main);
    }

    public void clickAllBase(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickCustomTabLayout(View view) {
        Intent intent = new Intent(this, CustomTabActivity.class);
        startActivity(intent);
    }
}
