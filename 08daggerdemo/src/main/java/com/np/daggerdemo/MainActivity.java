package com.np.daggerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.np.daggerdemo.entity.Coder;
import com.np.daggerdemo.entity.People;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Boss mBoss;

    @Inject
    @Level("low")
    Coder lowLevelCoder;

    @Inject
    @Level("high")
    Coder highLevelCoder;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List list = new ArrayList();
        list.add(1);
        list.add("1");
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Toolbar toolbar = null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        ObjectGraph.create(AppModule.class).inject(this);
//        AppModule appModule = new AppModule();
//        lowLevelCoder = appModule.provideLowLevelCoder();
//        highLevelCoder = appModule.providerHighLevelCoder();
//        Log.i("Level", "lowLevel = " + lowLevelCoder.getName() + "," + lowLevelCoder.getPower());
//        Log.i("Level", "highLevel = " + highLevelCoder.getName() + "," + highLevelCoder.getPower());
        Set<People> peoples = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            peoples.add(new People(i, "Pennan"));
        }
        Log.i("Level1", peoples.size() + "");
    }

}
