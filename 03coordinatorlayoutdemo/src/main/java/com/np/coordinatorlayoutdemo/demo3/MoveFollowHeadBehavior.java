package com.np.coordinatorlayoutdemo.demo3;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.np.coordinatorlayoutdemo.R;

/**
 * <B>Des</B>
 * 变化事件
 * @author ningpan 2016/11/10 10:50
 */
public class MoveFollowHeadBehavior extends CoordinatorLayout.Behavior {

    private int lastBottom = -1;

    public MoveFollowHeadBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency.getId() == R.id.view_bead;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        if (lastBottom == -1) {
            lastBottom = dependency.getBottom();
        }
        if (child.getTop() != lastBottom) {
            int dy = dependency.getBottom() - lastBottom;
            lastBottom = dependency.getBottom();
            // 向上或向下移动 dy 的距离，正负值表示方向(负-向下,正-向上)
            // 向左或向右移动 yx 的距离 offsetLeftAndRight(dx)
            child.offsetTopAndBottom(dy);
        }
        return true;
    }
}
