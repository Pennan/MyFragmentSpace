package com.np.swipebackfragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.np.swipebackfragment.R;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/14 11:34
 */
public class BaseFragment extends Fragment {
    // 当内存重启后,保存当前 Fragment 的状态(是否显示)
    private static final String SAVE_STATE_IS_HIDDEN = "SAVE_STATE_IS_HIDDEN";
    protected Context mContext;
    protected boolean isRootFragment = false; // 是否为根 Fragment

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (mContext instanceof OnAddFragmentListener) {
            mOnAddFragmentListener = (OnAddFragmentListener) mContext;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOnAddFragmentListener = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 当内存重启后,回复 Fragment 的状态(防止 Fragment 重叠)
        if (savedInstanceState != null) {
            boolean isHidden = savedInstanceState.getBoolean(SAVE_STATE_IS_HIDDEN);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            if (isHidden) {
                transaction.hide(this);
            } else {
                transaction.show(this);
            }
            transaction.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // 当内存重启后,保存当前 Fragment 的状态(是否显示)
        outState.putBoolean(SAVE_STATE_IS_HIDDEN, isHidden());
    }

    protected void _initToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (transit == FragmentTransaction.TRANSIT_FRAGMENT_OPEN) {
            if (enter) {
                if (isRootFragment) {
                    return AnimationUtils.loadAnimation(getContext(), R.anim.no_anim);
                }
                return AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_to_right);
            }
        } else if (transit == FragmentTransaction.TRANSIT_FRAGMENT_CLOSE) {
            return AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_to_right);
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    protected OnAddFragmentListener mOnAddFragmentListener;

    public void setOnAddFragmentListener(OnAddFragmentListener addFragmentListener) {
        mOnAddFragmentListener = addFragmentListener;
    }

    public interface OnAddFragmentListener {
        void onAddFragment(Fragment fromFragment, Fragment toFragment);
    }
}
