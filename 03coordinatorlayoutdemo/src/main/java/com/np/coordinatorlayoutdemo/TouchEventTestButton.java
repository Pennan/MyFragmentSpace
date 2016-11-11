package com.np.coordinatorlayoutdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/7 16:47
 */
public class TouchEventTestButton extends Button {

    private static final String TAG = TouchEventTestButton.class.getSimpleName();

    public TouchEventTestButton(Context context) {
        super(context);
    }

    public TouchEventTestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventTestButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "Button's ACTION_DOWN");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "Button's ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "Button's ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }
}
