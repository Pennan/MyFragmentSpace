package com.np.toucheventtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/22 15:16
 */
public class MyButton extends Button {

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("MyButton", "onTouchEvent's ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("MyButton", "onTouchEvent's ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("MyButton", "onTouchEvent's ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
