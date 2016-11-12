package com.np.appbarlayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * http://www.jianshu.com/p/d159f0176576
 * http://www.jianshu.com/p/b09a1ac96dd6
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.tv_main_content)).setText("一、Toolbar 的用处\n" +
                "Toolbar 是用于 替代 ActionBar 而诞生的 组件，那为啥要替换它呢？总应该有它的理由吧：\n" +
                "①、ActionBar 能做的 Toolbar 都能做\n" +
                "②、ActionBar 只能固定在顶部，不能移动。而 Toolbar 可以让我们随意摆放，这就带来了更多的灵活性和效果了。\n" +
                "二、Toolbar 的使用\n" +
                "既然 Toolbar 是用来替换 ActionBar，在使用的时候，总要先把 ActionBar 给隐藏吧。\n" +
                "隐藏的方法有很多，可以通过代码的方式，可以通过配置文件的方式，我们主要通过配置文件的方式来隐藏，在我们的 style.xml 中的 AppTheme 标签中加入如下两行：\n" +
                "<item name=windowActionBar>false</item>\n" +
                "<item name=windowNoTitle>true</item>\n" +
                "注意：是 windowActionBar 而不是 android:windowActionbar\n" +
                "当然也可以自定义 style，将上面两行加入其中，并且将这个新建的 style 标签作为 清单文件中 application 节点 的 theme，还可以选择通过将 AppTheme 的 parent 设置为Theme.AppCompat.Light.NoActionBar 的方式。方法很多，可以自己随便选。\n" +
                "三、其他类似组件\n" +
                "Matrial Design 提供了许多组件，其中 AppBarLayout、CollapsingToolbarLayout 和 Toolbar 一样都是针对 ActionBar 的，就是针对我们App的顶部 bar 玩出各种花样。" +
                "CoordinateLayout 是继承自 FrameLayout。\n" +
                "CoordinateLayout 被称之为 协调布局，那么它协调什么呢？自然就是 嵌套在其内部的 Child View。\n" +
                "CoordinateLayout 充当一个中间层的作用，一边接受内部其他组件的事件，一边将接收的事件传递给内部的其他组件。\n" +
                "Behavior 就是 CoordinateLayout 传递事件的媒介，Behavior 定义了 CoordinateLayout 中直接子 View 的的行为规范，决定了当收到不同的事件时，做出怎样的处理。");
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mToolbar.setTitle("this is toolbar");
        setSupportActionBar(mToolbar);
    }
}
