package com.qf.h5.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.qf.h5.R;
import com.qf.h5.ui.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/22.
 */

public class OneFragment extends BaseFragment {
    public OneFragment() {
    }

    public static OneFragment newInstance(String tag) {
        OneFragment tabFragment = new OneFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tag", tag);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.one_fragment_layout;
    }

    @Override
    protected void initWidget(View root) {

    }

    @Override
    protected void initData() {

    }
}
