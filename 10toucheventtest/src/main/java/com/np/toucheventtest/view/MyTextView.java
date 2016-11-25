package com.np.toucheventtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/23 9:42
 */
public class MyTextView extends TextView {

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("MyTextView", "onTouchEvent's ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("MyTextView", "onTouchEvent's ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("MyTextView", "onTouchEvent's ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
