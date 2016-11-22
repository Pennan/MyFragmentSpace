package com.np.annotationtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.np.annotationtest.annotation.InheritedAnnotation1;
import com.np.annotationtest.annotation.InheritedAnnotation2;
import com.np.annotationtest.entity.Child;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Class<Child> clazz = Child.class;
        Log.i(Constant.TAG, "对类进行测试......");
        // 判断该 类 是否有这个注解类
        if (clazz.isAnnotationPresent(InheritedAnnotation1.class)) {
            // 通过 类 的 Class 反射获取其注解类，并调用其方法
            Log.i(Constant.TAG, clazz.getAnnotation(InheritedAnnotation1.class).value1());
        }
        if (clazz.isAnnotationPresent(InheritedAnnotation2.class)) {
            Log.i(Constant.TAG, clazz.getAnnotation(InheritedAnnotation2.class).value2());
        }

        Log.d(Constant.TAG, "对 method1 进行测试......");
        try {
            // 判断该 方法 是否有这个注解类
            Method method1 = clazz.getMethod("method1", null);
            if (method1.isAnnotationPresent(InheritedAnnotation1.class)) {
                Log.d(Constant.TAG, method1.getAnnotation(InheritedAnnotation1.class).value1());
            }
            if (method1.isAnnotationPresent(InheritedAnnotation2.class)) {
                Log.d(Constant.TAG, method1.getAnnotation(InheritedAnnotation2.class).value2());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Log.e(Constant.TAG, "对 method2 进行测试......");
        try {
            Method method2 = clazz.getMethod("method2", null);
            if (method2.isAnnotationPresent(InheritedAnnotation1.class)) {
                Log.e(Constant.TAG, method2.getAnnotation(InheritedAnnotation1.class).value1());
            }
            if (method2.isAnnotationPresent(InheritedAnnotation2.class)) {
                Log.e(Constant.TAG, method2.getAnnotation(InheritedAnnotation2.class).value2());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Log.i(Constant.TAG, "对 成员变量 进行测试......");
        try {
            Field value = clazz.getField("value");
            // 判断该 成员变量 是否有这个注解类
            if (value.isAnnotationPresent(InheritedAnnotation1.class)) {
                Log.i(Constant.TAG, value.getAnnotation(InheritedAnnotation1.class).value1());
            }
            if (value.isAnnotationPresent(InheritedAnnotation2.class)) {
                Log.i(Constant.TAG, value.getAnnotation(InheritedAnnotation2.class).value2());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
