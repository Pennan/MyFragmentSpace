package com.np.coordinatorlayoutdemo.demo1;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * <B>Des</B>
 * 随着手指的移动而移动
 * @author ningpan 2016/11/3 17:09
 */
public class DependencyView extends View {
    public DependencyView(Context context) {
        super(context);
    }

    public DependencyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DependencyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int lastX;
    int lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int currX = (int) event.getRawX();
        int currY = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) getLayoutParams();
                int left = layoutParams.leftMargin + currX - lastX;
                int top = layoutParams.topMargin + currY - lastY;

                layoutParams.leftMargin = left;
                layoutParams.topMargin = top;
                setLayoutParams(layoutParams);
                requestLayout();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        lastX = currX;
        lastY = currY;
        return true;
    }
}
