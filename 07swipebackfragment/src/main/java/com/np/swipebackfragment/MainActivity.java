package com.np.swipebackfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.np.swipebackfragment.fragment.BaseFragment;
import com.np.swipebackfragment.fragment.OneFragment;

public class MainActivity extends AppCompatActivity implements BaseFragment.OnAddFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        getWindow().getDecorView().setBackgroundDrawable(null);
        if (savedInstanceState == null) {
            Log.i("GG", "正常启动....");
            loadFragment(new OneFragment());
        } /*else {
            Toast.makeText(MainActivity.this, "App被强杀了...", Toast.LENGTH_SHORT).show();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            for (Fragment fragment : fragments) {
                if (fragment.getTag().equals(OneFragment.class.getSimpleName())) {
                    transaction.show(fragment);
                } else {
                    transaction.hide(fragment);
                }
            }
            transaction.commit();
        }*/
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

    @Override
    public void onAddFragment(Fragment fromFragment, Fragment toFragment) {
        addFragment(fromFragment, toFragment);
    }

    private void addFragment(Fragment fromFragment, Fragment toFragment) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.h_fragment_enter, R.anim.h_fragment_exit,
                        R.anim.h_fragment_pop_enter, R.anim.h_fragment_pop_exit)
                .add(R.id.container_layout, toFragment, toFragment.getClass().getSimpleName())
                .hide(fromFragment)
                .addToBackStack(toFragment.getClass().getSimpleName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            overridePendingTransition(0, R.anim.slide_out_to_right);
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
