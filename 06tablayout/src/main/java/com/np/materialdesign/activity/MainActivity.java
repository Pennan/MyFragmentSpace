package com.np.materialdesign.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.np.materialdesign.R;
import com.np.materialdesign.fragment.EightFragment;
import com.np.materialdesign.fragment.FiveFragment;
import com.np.materialdesign.fragment.FourFragment;
import com.np.materialdesign.fragment.NineFragment;
import com.np.materialdesign.fragment.OneFragment;
import com.np.materialdesign.fragment.SevenFragment;
import com.np.materialdesign.fragment.SixFragment;
import com.np.materialdesign.fragment.TenFragment;
import com.np.materialdesign.fragment.ThreeFragment;
import com.np.materialdesign.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Material Design 之 Tabs<br>
 * Material Design 是 Android 5.0 以上才有的效果<br>
 * 参考文章：http://www.androidhive.info/2015/09/android-material-design-working-with-tabs/
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;

    /**
     * TabLayout 中的 tab 是否显示 icon
     * false：显示 icon 和 text
     * true：只显示 icon
     */
    private boolean isOnlyShowIcon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        tablayout.getTabAt(0).setIcon(R.mipmap.ic_hongxin);
        tablayout.getTabAt(1).setIcon(R.mipmap.ic_phone);
        tablayout.getTabAt(2).setIcon(R.mipmap.ic_touxiang);
    }

    private void setupViewPager() {
        ViewPagerAdapter mainAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mainAdapter.addFragment(new OneFragment(), "One");
        mainAdapter.addFragment(new TwoFragment(), "Two");
        mainAdapter.addFragment(new ThreeFragment(), "Three");
        viewpager.setAdapter(mainAdapter);
    }

    private void setupViewPager2() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new OneFragment(), "One");
        viewPagerAdapter.addFragment(new TwoFragment(), "Two");
        viewPagerAdapter.addFragment(new ThreeFragment(), "Three");
        viewPagerAdapter.addFragment(new FourFragment(), "Four");
        viewPagerAdapter.addFragment(new FiveFragment(), "Five");
        viewPagerAdapter.addFragment(new SixFragment(), "Six");
        viewPagerAdapter.addFragment(new SevenFragment(), "Seven");
        viewPagerAdapter.addFragment(new EightFragment(), "Eight");
        viewPagerAdapter.addFragment(new NineFragment(), "Nine");
        viewPagerAdapter.addFragment(new TenFragment(), "Ten");
        viewpager.setAdapter(viewPagerAdapter);
    }

    private void initToolbar() {
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        toolbar.inflateMenu(R.menu.menu_toolbar);
        toolbar.setTitle("Fixed Bars");
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_toolbar_item1:
                        isOnlyShowIcon = false;
                        setupViewPager();
                        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
                        tablayout.setupWithViewPager(viewpager);
                        break;
                    case R.id.menu_toolbar_item2:
                        isOnlyShowIcon = false;
                        setupViewPager();
                        tablayout.setTabGravity(TabLayout.GRAVITY_CENTER);
                        tablayout.setupWithViewPager(viewpager);
                        break;
                    case R.id.menu_toolbar_item3:
                        isOnlyShowIcon = false;
                        setupViewPager();
                        tablayout.setTabMode(TabLayout.MODE_FIXED);
                        tablayout.setupWithViewPager(viewpager);
                        break;
                    case R.id.menu_toolbar_item4:
                        isOnlyShowIcon = false;
                        setupViewPager2();
                        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                        tablayout.setupWithViewPager(viewpager);
                        setupTabIcons();
                        break;
                    case R.id.menu_toolbar_item5:
                        isOnlyShowIcon = true;
                        setupViewPager();
                        tablayout.setupWithViewPager(viewpager);
                        setupTabIcons();
                        break;
                }
                return false;
            }
        });
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
            CharSequence charSequence;
            // 在 TabLayout 中的 tab 有 icon 的前提下
            if (isOnlyShowIcon) { // 只显示 icon
                charSequence = null;
            } else { // 即显示 icon 又显示 text
                charSequence = titleList.get(position);
            }
            return charSequence;
        }
    }
}
