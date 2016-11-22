package com.np.swipebackfragment.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.np.swipebackfragment.R;

public class TenFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_ten, container, false);
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar_ten);
        _initToolbar(toolbar, "Ten Page");
        return inflate;
    }
}
