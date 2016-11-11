package com.np.coordinatorlayoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.np.coordinatorlayoutdemo.demo1.CoordinatorDemo1Activity;
import com.np.coordinatorlayoutdemo.demo2.CoordinatorDemo2Activity;
import com.np.coordinatorlayoutdemo.demo3.CoordinatorDemo3Activity;

/**
 * http://www.jianshu.com/search?q=CoordinatorLayout&page=1&type=notes
 * http://www.jianshu.com/p/6394d738713c
 * http://blog.csdn.net/huachao1001/article/details/51554608
 * <p/>
 * http://www.jianshu.com/search?q=AppBarLayout&page=1&type=notes
 * http://www.jianshu.com/p/d159f0176576
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void demo1Click(View view) {
        startActivity(new Intent(this, CoordinatorDemo1Activity.class));
    }

    public void demo2Click(View view) {
        startActivity(new Intent(this, CoordinatorDemo2Activity.class));
    }

    public void demo3Click(View view) {
        startActivity(new Intent(this, CoordinatorDemo3Activity.class));
    }
}
