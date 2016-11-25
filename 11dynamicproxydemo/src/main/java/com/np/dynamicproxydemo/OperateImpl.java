package com.np.dynamicproxydemo;

import android.util.Log;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/23 18:06
 */
public class OperateImpl implements Operate {

    @Override
    public void operateMethod1() {
        Log.i("Dynamic_Proxy", "invoke operateMethod1");
        sleep(110);
    }

    @Override
    public void operateMethod2() {
        Log.i("Dynamic_Proxy", "invoke operateMethod2");
        sleep(120);
    }

    @Override
    public void operateMethod3() {
        Log.i("Dynamic_Proxy", "invoke operateMethod3");
        sleep(130);
    }

    private void sleep(long millSeconds) {
        try {
            Thread.sleep(millSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
