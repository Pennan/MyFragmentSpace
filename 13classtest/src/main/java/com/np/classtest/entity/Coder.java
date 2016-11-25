package com.np.classtest.entity;

import android.util.Log;

import com.np.classtest.MainActivity;
import com.np.classtest.annotation.CoderAnnotation;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/24 17:38
 */
@CoderAnnotation(value = "I'm Coder...")
public class Coder extends Human {
    @CoderAnnotation(value = "Coder's field(name)")
    private String name;
    private int age;
    String msg;

    @Override
    public String toString() {
        return "Coder{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", msg='" + msg + '\'' +
                '}';
    }

    @CoderAnnotation(value = "Coder's method(showMsg)")
    public void showMsg(String name, int age) {
        Log.i(MainActivity.TAG, "name = " + name + ",age = " + age);
    }

    private void showMsg(String name, int age, Integer a) {
        Log.i(MainActivity.TAG, "name = " + name + ",age = " + age + ",a = " + a);
    }

    protected void say(String msg) {
        Log.i(MainActivity.TAG, msg);
    }

    void sayHello(String msg) {
        Log.i(MainActivity.TAG, msg);
    }

    public Coder() {
    }

    @CoderAnnotation(value = "Coder's Constructor...")
    public Coder(String name, int age) {

        this.name = name;
        this.age = age;
    }

    private Coder(String name) {
        Log.i(MainActivity.TAG, "name = " + name);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
