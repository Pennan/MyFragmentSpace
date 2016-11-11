package com.np.coordinatorlayoutdemo.demo2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.np.coordinatorlayoutdemo.R;

/**
 * <B>Des</B>
 * 分析：
 * ①、TouchBehavior 绑定的 view 为 被依赖者(即 onStartNestedScroll 方法中的 target),
 *    HeadHideBehavior 绑定的 view 为 依赖者(即 onStartNestedScroll 方法中的 child),
 * ②、TouchBehavior 实现了 NestedScrollingChild 接口,调用了 startNestedScroll 和 dispatchNestedPreScroll 方法,
 *    HeadHideBehavior 会对 NestedScrollingChild 发出的事件做出响应,即调用 onStartNestedScroll 和 nestedPreScroll 方法
 * 原理：(NestedScrollingChild 主动发出的滑动事件会传递给 NestedScrollingParent(即 CoordinatorLayout),
 * NestedScrollingParent 做出响应,然后将事件交给 绑定 child 的 Behavior 中执行与 NestedScrollingParent
 * 相同的方法来做出对触摸事件的响应)
 * @author ningpan 2016/11/9 17:20
 */
public class HeadHideBehavior extends CoordinatorLayout.Behavior {

    private boolean isHideHead = false;
    private boolean isAnimating = false;
    private static final int SCROLL_VALUE = 50;
    private static final int ANIMATION_DURATION = 500;
    private int childHeight;

    public HeadHideBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        if (target.getId() == R.id.view_body) {
            if (childHeight == 0) {
                childHeight = child.getHeight();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        if (isAnimating) { // 如果正在执行动画,则不执行滑动事件
            return;
        }
        if (dy > 0 && Math.abs(dy) > SCROLL_VALUE && !isHideHead) { // target 是向上滑动 并且 child 是显示的
            hide(child, target);
        } else if (dy < 0 && Math.abs(dy) < SCROLL_VALUE && isHideHead) { // target 是向下滑动的 并且 child 是隐藏的
            show(child, target);
        }
    }

    private void show(final View child, final View target) {
        isHideHead = false;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, childHeight);
        valueAnimator.setDuration(ANIMATION_DURATION);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (child.getBottom() < childHeight) {
                    int value = (int) animation.getAnimatedValue();
                    isAnimating = value != childHeight;
                    child.layout(child.getLeft(), value - childHeight, child.getRight(), value);
                    target.layout(target.getLeft(), value, target.getRight(), target.getBottom());
                }
            }
        });
        valueAnimator.start();
    }

    private void hide(final View child, final View target) {
        isHideHead = true;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, childHeight);
        valueAnimator.setDuration(ANIMATION_DURATION);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (child.getBottom() > 0) {
                    int value = (int) animation.getAnimatedValue();
                    isAnimating = value != childHeight;
                    child.layout(child.getLeft(), -value, child.getRight(), - value + childHeight);
                    target.layout(target.getLeft(), - value + childHeight, target.getRight(), target.getBottom());
                }
            }
        });
        valueAnimator.start();
    }
}
