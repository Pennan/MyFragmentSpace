package com.np.coordinatorlayoutdemo;

import android.content.Context;
import android.support.v4.view.NestedScrollingChild;
import android.util.AttributeSet;
import android.view.View;

/**
 * <B>Des</B>
 * http://www.jianshu.com/p/39fbc9f4f0c6
 *
 * https://segmentfault.com/a/1190000006657044
 * @author ningpan 2016/11/7 14:34
 */
public class CustomNestedScrollingChildView extends View implements NestedScrollingChild {
    public CustomNestedScrollingChildView(Context context) {
        super(context);
    }

    public CustomNestedScrollingChildView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomNestedScrollingChildView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /** 设置当前 View 能否滑动 */
    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        super.setNestedScrollingEnabled(enabled);
    }

    /** 判断当前 View 能否滑动 */
    @Override
    public boolean isNestedScrollingEnabled() {
        return super.isNestedScrollingEnabled();
    }

    /**
     * 启动嵌套滑动事件流
     * 1、寻找可以接收 NestedScroll 事件的 parent view，即实现了 NestedScrollingParent 接口的 ViewGroup
     * 2、通知该 parent view，现在我要把滑动的参数传递给你
     */
    @Override
    public boolean startNestedScroll(int axes) {
        return super.startNestedScroll(axes);
    }

    /** 停止嵌套滑动事件流 */
    @Override
    public void stopNestedScroll() {
        super.stopNestedScroll();
    }

    /** 是否存在接收 NestedScroll 事件的 parent view */
    @Override
    public boolean hasNestedScrollingParent() {
        return super.hasNestedScrollingParent();
    }

    /**
     * 在滑动之后向父 View 汇报滑动情况，包括 child view 消费的部分和 child view 没有消费的部分
     * @param dxConsumed x 方向已消费的滑动距离
     * @param dyConsumed y 方向已消费的滑动距离
     * @param dxUnconsumed x 方向未消费的滑动距离
     * @param dyUnconsumed y 方向未消费的滑动距离
     * @param offsetInWindow 如果 parent view 滑动导致了 child view 的窗口/位置发生了变化，
     *                       该参数 x(offsetInWindow[0]) y(offsetInWindow[1]) 方向的变化；
     *                       如果你记录了手指最后的位置，需要根据参数 offsetInWindow 计算偏移量，
     *                       才能保证下一次的 touch 事件的计算是正确的。
     * @return 如果 parent view 接受了它的滚动参数，进行了部分消费，则返回 true，否则返回 false。
     */
    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    /**
     * 在滑动之前，先问一下 parent view 是否需要滑动，
     * 即 child view 的 onInterceptTouchEvent 或 onTouchEvent 方法中调用。
     * 1、如果 parent view 滑动了一定距离，你需要重新计算一下 parent view 滑动后剩下给你的
     *      滑动距离剩余量，然后自己进行剩余的滑动。
     * 2、该方法的第三第四个参数返回 parent view 消费掉的滑动距离和 child view 的窗口偏移量，
     *      如果你记录了手指最后的位置，需要根据第四个参数 offsetInWindow 计算偏移量，
     *      才能保证下一次的 touch 事件的计算是正确的。
     * @param dx x 方向的滑动距离
     * @param dy y 方向的滑动距离
     * @param consumed 如果不为 null，则告诉 child view 现在 parent view 滑动的情况，
     *                 consumed[0] parent view 告诉 child view 水平方向滑动的距离(dx)，
     *                 consumed[0] parent view 告诉 child view 垂直方向滑动的距离(dy)
     * @param offsetInWindow 可选 length = 2 的数组，
     *                       如果 parent view 滑动导致 child view 的窗口(位置)发生了变化，
     *                       该参数返回 x(offsetInWindow[0]) y(offsetInWindow[1]) 方向的变化，
     *                       如果你记录了手指最后的位置，需要根据参数 offsetInWindow 计算偏移量，
     *                       才能保证下一次的touch事件的计算是正确的。
     * @return 如果parent view对滑动距离进行了部分消费，则返回true，否则为false。
     */
    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    /**
     * 在嵌套滑动的 child view 快速滑动之后在调用该函数向 parent view 汇报快速滑动情况。
     * @param velocityX 水平方向的速度
     * @param velocityY 垂直方向的速度
     * @param consumed true 表示 child view 快速滑动了，false 表示 child view 没有快速滑动
     * @return true 表示 parent view 快速滑动了，false 表示 parent view 没有快速滑动
     */
    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return super.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    /**
     * 在嵌套滑动的 child view 快速滑动之前告诉 parent view 快速滑动情况
     * @param velocityX 水平方向的速度
     * @param velocityY 垂直方向的速度
     * @return true 表示 parent view 快速滑动了，false 表示 parent view 没有快速滑动
     */
    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return super.dispatchNestedPreFling(velocityX, velocityY);
    }


}
