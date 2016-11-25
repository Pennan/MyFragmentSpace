package com.np.classtest.entity;

import android.util.Log;

import com.np.classtest.MainActivity;
import com.np.classtest.annotation.CoderAnnotation;

import java.util.Map;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/25 9:32
 */
@CoderAnnotation(value = "I'm Coder's superclass...")
public class Human {
    private String description;
    protected int flag;
    Map<String, String> maps;

    protected void speak(boolean isSpeak) {
        Log.i(MainActivity.TAG, isSpeak ? "会说话" : "不会说话");
    }

    public void bigger(boolean isBigger) {
        Log.i(MainActivity.TAG, isBigger ? "我是大人" : "我是小孩");
    }

    void canJava(boolean isSure) {
        Log.i(MainActivity.TAG, isSure ? "精通Java" : "傻小白");
    }

    private void speakEnglish(boolean isTrue) {
        Log.i(MainActivity.TAG, isTrue ? "我会讲英语" : "我不会讲英语");
    }
}
