package com.qf.h5.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.flyco.tablayout.SegmentTabLayout;
import com.qf.h5.R;
import com.qf.h5.ui.base.BaseFragment;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/22.
 */

public class BenefitsFragment extends BaseFragment {
    @Bind(R.id.tablayout)
    SegmentTabLayout tablayout;
    private String titleArr[] = {"礼包中心", "激萌图库"};

    @Override
    protected int getLayoutId() {
        return R.layout.benefit_fragment_layout;
    }

    @Override
    protected void initWidget(View root) {
    }

    @Override
    protected void initData() {
        ArrayList<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new GiftCenterFragment());
        mFragments.add(new MengPicFragment());
        tablayout.setTabData(titleArr, getActivity(), R.id.fl_change, mFragments);
    }
}
