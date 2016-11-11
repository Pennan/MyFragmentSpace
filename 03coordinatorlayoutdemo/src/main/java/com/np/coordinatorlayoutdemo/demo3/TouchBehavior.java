package com.np.coordinatorlayoutdemo.demo3;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/9 10:18
 */
public class TouchBehavior extends CoordinatorLayout.Behavior implements NestedScrollingChild {

    private NestedScrollingChildHelper mChildHelper;
    private float ox;
    private float oy;
    private int[] consumed = new int[2];
    private int[] offsetInWindow = new int[2];

    public TouchBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        if (mChildHelper == null) {
            mChildHelper = new NestedScrollingChildHelper(child);
            // 对外发出滑动触摸事件
            setNestedScrollingEnabled(true);
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ox = ev.getX();
                oy = ev.getY();
                // 触摸在 child 控件外面(ps：onTouch 事件是从 CoordinatorLayout 分发下来的，
                // 所以这里的 onTouchEvent 并不是我们控件自己的 onTouch 事件)
                // 分析:触摸范围控制,如果点击 child 控件外面,则 直接 return true,那么 startNestedScroll() 将不会被调用到,
                // 那么 ACTION_DOWN 事件里的 dispatchNestedPreScroll 将失效.
                if (ox < child.getLeft() || oy < child.getTop() || ox > child.getRight() || oy > child.getBottom()) {
                    return true;
                }
                // 开始滑动
                startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
                break;
            case MotionEvent.ACTION_MOVE:
                float x = ev.getX();
                float y = ev.getY();

                // 计算滑动偏移量
                int dx = (int) (x - ox);
                int dy = (int) (y - oy);
                
                if (Math.abs(dx) < Math.abs(dy)) {
                    // 分发触摸事件给 parent view 处理
                    // why '-dy' not 'dy' ?：因为 滑动方向 和 滑动偏移量 成反比
                    dispatchNestedPreScroll(dx, -dy, consumed, offsetInWindow);
                }
                break;
            case MotionEvent.ACTION_UP:
                // 停止触摸滑动事件
                stopNestedScroll();
                break;
        }
        return true;
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        mChildHelper.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return mChildHelper.isNestedScrollingEnabled();
    }

    @Override
    public boolean startNestedScroll(int axes) {
        return mChildHelper.startNestedScroll(axes);
    }

    @Override
    public void stopNestedScroll() {
        mChildHelper.stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        return mChildHelper.hasNestedScrollingParent();
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return mChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return mChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }
}
