package com.np.swipebackfragment.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.np.swipebackfragment.R;

public class SixFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_six, container, false);
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar_six);
        _initToolbar(toolbar, "Six Page");

        inflate.findViewById(R.id.btn_six).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnAddFragmentListener.onAddFragment(SixFragment.this, new SevenFragment());
            }
        });
        return inflate;
    }
}
