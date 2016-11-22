package com.np.swipebackfragment.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.np.swipebackfragment.R;

public class OneFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        isRootFragment = true;

        View inflate = inflater.inflate(R.layout.fragment_one, container, false);
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar_one);
        _initToolbar(toolbar, "One Page");
        
        inflate.findViewById(R.id.btn_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnAddFragmentListener.onAddFragment(OneFragment.this, new TwoFragment());
            }
        });
        return inflate;
    }
}
