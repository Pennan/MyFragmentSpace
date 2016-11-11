package com.np.coordinatorlayoutdemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/5 11:15
 */
public class CleanableEditText extends EditText {

    private Drawable mDrawable;
    private Context mContext;

    public CleanableEditText(Context context) {
        this(context, null);
    }

    public CleanableEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CleanableEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        mDrawable = getCompoundDrawables()[2];
        if (mDrawable == null) {
            mDrawable = mContext.getResources().getDrawable(R.drawable.common_selector_btn_del);
        }
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

        // 设置内间距
        this.setPadding(dp2px(10), 0, dp2px(8), 0);
        this.setGravity(Gravity.CENTER_VERTICAL);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateCleanable(length(), true);
            }
        };
        this.addTextChangedListener(textWatcher);
        this.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                updateCleanable(length(), hasFocus);
            }
        });
    }

    /**
     * 当内容不为空，而且获得焦点，才显示右侧删除图标
     * @param length 输入文本的长度
     * @param hasFocus 是否有焦点
     */
    private void updateCleanable(int length, boolean hasFocus) {
        if (length > 0 && hasFocus) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, mDrawable, null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 点击的时候 获取焦点
        setFocusable(true);
        setFocusableInTouchMode(true);
        // 获取到右边的 Drawable,左上右下(0,1,2,3)
        Drawable rightDrawable = getCompoundDrawables()[2];
        if (rightDrawable != null && event.getAction() == MotionEvent.ACTION_UP) {
            // 检查点击的位置是否为右边的删除图标
            int leftEdgeOfRightDrawable = getRight() - getPaddingRight() - rightDrawable.getBounds().width();
            if (event.getRawX() >= leftEdgeOfRightDrawable) {
                setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        mDrawable = null;
        super.finalize();
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}
