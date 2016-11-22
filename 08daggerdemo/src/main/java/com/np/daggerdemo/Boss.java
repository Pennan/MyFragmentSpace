package com.np.daggerdemo;

import android.util.Log;

import javax.inject.Inject;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/21 15:38
 */
public class Boss {

    @Inject
    public Boss() {
        Log.i("Boss", "Boss's structure");
    }

}
