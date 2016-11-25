package com.np.dynamicproxydemo;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <B>Des</B>
 * InvocationHandler 调用处理程序接口类
 * @author ningpan 2016/11/23 18:10
 */
public class TimingInvocationHandler implements InvocationHandler {

    private Object target;

    public TimingInvocationHandler(Object object) {
        this.target = object;
    }

    public TimingInvocationHandler() {}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object invoke = method.invoke(target, args);
        Log.e("Dynamic_Proxy", method.getName() + " cost time is: " +
                (System.currentTimeMillis() - start));
        return invoke;
    }
}
