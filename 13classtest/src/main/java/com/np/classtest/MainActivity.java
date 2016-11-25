package com.np.classtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.np.classtest.annotation.CoderAnnotation;
import com.np.classtest.entity.Coder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// java 反射机制的学习
public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName() + "_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getClassName();
//        getPublicMethodTest();
//        getPrivateMethodTest();
//        getProtectedMethodTest();
//        getDefaultMethodTest();
//        getParentClassMethodTest();
//        getAllMethodTest();
//        getFieldTest();
//        getConstructorTest();
        getAnnotationTest();
    }

    private void getAnnotationTest() {
        // 获取 类 上的注解
//        Class<Coder> aClass = Coder.class;
//        // 判断 Coder 类上是否有 CoderAnnotation 注解类
//        if (aClass.isAnnotationPresent(CoderAnnotation.class)) {
//            // 获取注解类
//            CoderAnnotation coderAnnotation = aClass.getAnnotation(CoderAnnotation.class);
//            String value = coderAnnotation.value();
//            Log.i(MainActivity.TAG, "value = " + value);
//        }
        // 获取 构造器 上的注解
        try {
            Class<Coder> aClass = Coder.class;
            Constructor<Coder> constructor = aClass.getConstructor(String.class, int.class);
            // 判断 该构造器 上是否有 CoderAnnotation 注解类
            if (constructor.isAnnotationPresent(CoderAnnotation.class)) {
                CoderAnnotation coderAnnotation = constructor.getAnnotation(CoderAnnotation.class);
                String value = coderAnnotation.value();
                Log.i(MainActivity.TAG, "value = " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取 方法 上的注解
        try {
            Class<Coder> aClass = Coder.class;
            Method method = aClass.getMethod("showMsg", String.class, int.class);
            // 判断 该方法 上是否有 CoderAnnotation 注解类
            if (method.isAnnotationPresent(CoderAnnotation.class)) {
                CoderAnnotation coderAnnotation = method.getAnnotation(CoderAnnotation.class);
                String value = coderAnnotation.value();
                Log.i(MainActivity.TAG, "value = " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取 成员变量 上的注解
        try {
            Class<Coder> aClass = Coder.class;
            Field nameField = aClass.getDeclaredField("name");
            // 判断 该成员变量 上是否有 CoderAnnotation 注解类
            if (nameField.isAnnotationPresent(CoderAnnotation.class)) {
                CoderAnnotation coderAnnotation = nameField.getAnnotation(CoderAnnotation.class);
                String value = coderAnnotation.value();
                Log.i(MainActivity.TAG, "value = " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取 父类 类上的注解
        try {
            Class<Coder> aClass = Coder.class;
            int modifiers = aClass.getModifiers();
            Class<?>[] interfaces = aClass.getInterfaces();
            aClass.getMethods();
            aClass.getFields();
            aClass.getConstructors();
            aClass.getAnnotations();
            // 获取父类的类类型
            Class<? super Coder> superclass = aClass.getSuperclass();
            // 判断 父类 上是否有 CoderAnnotation 注解类
            if (superclass.isAnnotationPresent(CoderAnnotation.class)) {
                CoderAnnotation coderAnnotation = superclass.getAnnotation(CoderAnnotation.class);
                String value = coderAnnotation.value();
                Log.i(MainActivity.TAG, "value = " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getConstructor 和 getDeclaredConstructor 方法 和 获取 方法/属性 同理
     */
    private void getConstructorTest() {
        try {

//            Class<Coder> aClass = Coder.class;
//            Constructor<Coder> constructor = aClass.getConstructor(String.class, int.class);
//            Coder coder = constructor.newInstance("Pennan", 20);
//            Log.i(MainActivity.TAG, "coder = " + coder);
            Class<Coder> aClass = Coder.class;
            Constructor<Coder> constructor = aClass.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            Coder coder = constructor.newInstance("Pennan");
            Log.i(MainActivity.TAG, "coder = " + coder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getFieldTest() {
        try {
            // 私有方法
//            Class<Coder> aClass = Coder.class;
//            Field nameField = aClass.getDeclaredField("name");
//            Coder coder = aClass.newInstance();
//            nameField.setAccessible(true);
//            // 为属性赋值
//            nameField.set(coder, "大神的小弟");
//            // 获取该属性值
//            Object o = nameField.get(coder);
            // 默认修饰符以上  getDeclaredField 和 getField 都能获取到
//            Class<Coder> aClass = Coder.class;
//            Field msgField = aClass.getField("msg");
//            Coder coder = aClass.newInstance();
//            msgField.set(coder, "I'm Coder!");
//            Object o = msgField.get(coder);
//            Log.i(MainActivity.TAG, "name = " + o.toString());
            // 获取其父类的属性 getField 和 getDeclaredField 同 getMethod 和 getDeclaredMethod 一样
            Class<Coder> aClass = Coder.class;
            Field mapsField = aClass.getField("maps");
            Coder coder = aClass.newInstance();
            Map<String, String> map = new HashMap<>();
            map.put("key", "I'm Map!");
            mapsField.set(coder, map);
            String key = ((Map<String, String>) mapsField.get(coder)).get("key");
            Log.i(MainActivity.TAG, "name = " + key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getMethod 可以获取到其父类 以及 本身类 除了 private 以外所有的方法
     * getDeclaredMethod 能获取本身所有方法，获取不到其父类的任何方法
     *  如果调用 getDeclaredMethod 获取到的私有方法,则还需 method.setAccessible(true);
     *  否则会调用失败。
     */
    private void getParentClassMethodTest() {
        try {
            Class<Coder> aClass = Coder.class;
            // 通过 getMethod 方法可以获取其父类的 默认的、protected、public 修饰的方法
            // 不能获取到其父类的 private 修饰的方法
//            Method method = aClass.getMethod("speak", boolean.class);
//            Method method = aClass.getMethod("bigger", boolean.class);
//            Method method = aClass.getMethod("canJava", boolean.class);
            Method method = aClass.getMethod("speakEnglish", boolean.class);

            // 通过 getDeclaredMethod 方法获取不到父类的方法
//            Method method = aClass.getDeclaredMethod("speak", boolean.class);
//            Method method = aClass.getDeclaredMethod("bigger", boolean.class);
            Coder coder = aClass.newInstance();
            method.invoke(coder, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAllMethodTest() {
        Class<Coder> aClass = Coder.class;
        Method[] methods = aClass.getMethods();
        Method[] declaredMethods = aClass.getDeclaredMethods();
    }

    private void getDefaultMethodTest() {
        try {
            Class<Coder> aClass = Coder.class;
            Method method = aClass.getMethod("sayHello", String.class);
            Coder coder = aClass.newInstance();
            method.invoke(coder, "say, Hello!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getProtectedMethodTest() {
        try {
            Class<Coder> aClass = Coder.class;
            Method method = aClass.getMethod("say", String.class);
            Coder coder = aClass.newInstance();
            method.invoke(coder, "hello, Coder!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getPrivateMethodTest() {
        try {
//            Class<?> aClass = Class.forName("com.np.classtest.entity.Coder");
//            Method method = aClass.getDeclaredMethod("showMsg", String.class, int.class, Integer.class);
//            method.setAccessible(true);
//            Object o = aClass.newInstance();
//
//            method.invoke(o, "Pennan", 20, 1);
            Coder coder = new Coder();
            Class<? extends Coder> aClass = coder.getClass();
            // 如果 showMsg 是私有方法,则调用的时候,需要 method.setAccessible(true)
            Method method = aClass.getDeclaredMethod("showMsg", String.class, int.class);
            method.invoke(coder, "Cool", 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getPublicMethodTest() {
        try {
            Class<?> aClass = Class.forName("com.np.classtest.entity.Coder");
            Method method = aClass.getMethod("showMsg", String.class, int.class);
            Object o = aClass.newInstance();
            method.invoke(o, "Pennan", 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getClassName() {
        Class<Coder> aClass = Coder.class;
        Log.i(TAG, aClass.getName());
        Coder coder = new Coder();
        Class<? extends Coder> aClass1 = coder.getClass();
        Log.i(TAG, aClass1.getName());
        try {
            Class<?> aClass2 = Class.forName("com.np.classtest.entity.Coder");
            Log.i(TAG, aClass2.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
