package com.np.dynamicproxydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Proxy;

// 参考文章：http://a.codekk.com/detail/Android/Caij/%E5%85%AC%E5%85%B1%E6%8A%80%E6%9C%AF%E7%82%B9%E4%B9%8B%20Java%20%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimingInvocationHandler timingInvocationHandler = new TimingInvocationHandler(new OperateImpl());
        // 为指定的接口返回动态创建类的一个实例
        Operate operate = (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class},
                timingInvocationHandler);
        operate.operateMethod1();
        operate.operateMethod2();
        operate.operateMethod3();
    }
}
