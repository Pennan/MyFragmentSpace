package com.np.drawerlayoutdemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * https://developer.android.com/about/versions/android-5.0.html
 * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/0925/1713.html#commettop
 * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0303/2522.html
 */
public class ActionBarDrawerLayoutActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mListView;
    private String[] lvDatas = new String[] {"Android", "JavaSE", "JavaEE", "C++"};
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_drawer_layout);
        mTitle = getTitle();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mListView = (ListView) findViewById(R.id.lv_left);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lvDatas);
        mListView.setAdapter(mAdapter);

        // android 6.0 以上需要使用 getSupportActionBar 而不是 getActionBar,否则报错
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.open_drawer, R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // 调用 onPrepareOptionsMenu 方法
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // 调用 onPrepareOptionsMenu 方法
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mListView.setOnItemClickListener(new OnDrawerItemClickListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_title, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 使用该方法相当于更加优雅的实现了下面 注释 掉的代码的功能.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            /*case android.R.id.home:
                boolean isOpen = mDrawerLayout.isDrawerOpen(mListView);
                if (isOpen) {
                    mDrawerLayout.closeDrawer(mListView);
                } else {
                    mDrawerLayout.openDrawer(mListView);
                }
                break;*/
            case R.id.main_title_navigation:
                Toast.makeText(ActionBarDrawerLayoutActivity.this, "GG", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    class OnDrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    /** 选择 Drawer item 的时候转换 Fragment 页面 */
    private void selectItem(int position) {
        String data = lvDatas[position];
        Fragment fragment = new FlanetFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FlanetFragment.FRAGMENT_TAG, data);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();

        mListView.setItemChecked(position, true);
        setTitle(data);
        mDrawerLayout.closeDrawer(mListView);
    }

    public static class FlanetFragment extends Fragment {
        public static final String FRAGMENT_TAG = "FRAGMENT_FLANET";
        private String name;
        public FlanetFragment() {}

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_planet, container, false);
            String tag = getArguments().getString(FRAGMENT_TAG);
            name = "Fragment_" + tag;
            ((TextView) view.findViewById(R.id.tv_fragment_planet_content)).setText(name);

            getActivity().setTitle(name);
            return view;
        }
    }
}
