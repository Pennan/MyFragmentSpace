package com.np.toucheventtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/22 15:25
 */
public class MyLinearLayout extends LinearLayout {

    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        super.measureChild(child, parentWidthMeasureSpec, parentHeightMeasureSpec);
    }

    @Override
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        super.measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//        View childAt = getChildAt(0);
//        MyLinearLayout.LayoutParams lp = (MyLinearLayout.LayoutParams) childAt.getLayoutParams();
//        Log.i("MyButton", "width = " + childAt.getWidth() + "," + lp.width + ",specSize = "
//                + MeasureSpec.getSize(widthMeasureSpec));
//        int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
//                childAt.getPaddingLeft() + childAt.getPaddingRight() +
//                        lp.leftMargin + lp.rightMargin, lp.width);
//
//        int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec,
//                childAt.getPaddingBottom() + childAt.getPaddingTop() +
//                        lp.topMargin + lp.bottomMargin, lp.height);
//
//        childAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
//        Log.i("MyButton2", "specSize = "
//                + MeasureSpec.getSize(childWidthMeasureSpec));
//        setMeasuredDimension(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                Log.i("MyButton's Parent", "dispatchTouchEvent's ACTION_DOWN");
//                return false;
//            case MotionEvent.ACTION_MOVE:
//                Log.i("MyButton's Parent", "dispatchTouchEvent's ACTION_MOVE");
//                return false;
//            case MotionEvent.ACTION_UP:
//                Log.i("MyButton's Parent", "dispatchTouchEvent's ACTION_UP");
//                break;
//        }
        return super.dispatchTouchEvent(ev);
    }

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
