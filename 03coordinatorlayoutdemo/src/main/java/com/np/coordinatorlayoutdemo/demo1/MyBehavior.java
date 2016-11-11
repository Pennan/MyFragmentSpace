package com.np.coordinatorlayoutdemo.demo1;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/3 17:04
 */
public class MyBehavior extends CoordinatorLayout.Behavior<Button> {

    private int screenWidth;

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        this.screenWidth = metrics.widthPixels;
    }

    /**
     * 当 dependency 发生变化时（位置、宽高等），执行该方法
     * @return true：child 跟随 dependency 发生变化，false：不跟随 dependency 变化
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button child, View dependency) {
        int top = dependency.getTop();
        int left = dependency.getLeft();

        int x = screenWidth - left - child.getWidth();
        int y = top;
        setPosition(child, x, y);
        return true;
    }

    private void setPosition(Button child, int x, int y) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        child.setLayoutParams(layoutParams);
    }

    /**
     * 判断 child 布局是否依赖 dependency
     * @return true：依赖，false：child 不依赖 dependency
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        return dependency instanceof DependencyView;
    }
}
