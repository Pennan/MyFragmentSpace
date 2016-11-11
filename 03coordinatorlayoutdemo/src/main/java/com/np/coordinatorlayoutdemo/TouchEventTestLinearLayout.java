package com.np.coordinatorlayoutdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/7 16:53
 */
public class TouchEventTestLinearLayout extends LinearLayout {

    private static final String TAG = TouchEventTestLinearLayout.class.getSimpleName();

    public TouchEventTestLinearLayout(Context context) {
        super(context);
    }

    public TouchEventTestLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventTestLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "LinearLayout's dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "LinearLayout's dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "LinearLayout's dispatchTouchEvent ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "LinearLayout's onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "LinearLayout's onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "LinearLayout's onTouchEvent ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }
}
