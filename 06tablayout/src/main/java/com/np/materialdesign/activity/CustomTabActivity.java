package com.np.materialdesign.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.np.materialdesign.R;
import com.np.materialdesign.fragment.OneFragment;
import com.np.materialdesign.fragment.ThreeFragment;
import com.np.materialdesign.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义 TabLayout 中 tab 内容的显示方式（即 icon 和 text 的排列方式）
 */
public class CustomTabActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tab);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolbar();

        viewpager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager();

        tablayout = (TabLayout) findViewById(R.id.tablayout);
        tablayout.setupWithViewPager(viewpager);
        setupTabIcons();
    }

    // 为 TabLayout 中的 指定 tab 添加图片
    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("One");
        tabOne.setGravity(Gravity.CENTER);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_hongxin, 0, 0, 0);
        tablayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Two");
        tabTwo.setGravity(Gravity.CENTER);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_phone, 0, 0, 0);
        tablayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Three");
        tabThree.setGravity(Gravity.CENTER);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_touxiang, 0, 0, 0);
//        tabThree.setCompoundDrawablePadding(2);
        tablayout.getTabAt(2).setCustomView(tabThree);
    }

    private void setupViewPager() {
        ViewPagerAdapter mainAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mainAdapter.addFragment(new OneFragment(), "One");
        mainAdapter.addFragment(new TwoFragment(), "Two");
        mainAdapter.addFragment(new ThreeFragment(), "Three");
        viewpager.setAdapter(mainAdapter);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Custom TabLayout tabs");
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            titleList.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}
