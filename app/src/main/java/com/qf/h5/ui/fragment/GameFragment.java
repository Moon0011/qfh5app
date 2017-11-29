package com.qf.h5.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.flyco.tablayout.SegmentTabLayout;
import com.qf.h5.R;
import com.qf.h5.ui.base.BaseFragment;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/22.
 */

public class GameFragment extends BaseFragment {
    @Bind(R.id.img_logo)
    ImageView imgLogo;
    @Bind(R.id.tablayout)
    SegmentTabLayout tablayout;
    private String titleArr[] = {"推荐", "热门", "分类"};

    @Override
    protected int getLayoutId() {
        return R.layout.game_fragment_layout;
    }

    @Override
    protected void initWidget(View root) {
    }

    @Override
    protected void initData() {
        ArrayList<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new GameListFragment());
        mFragments.add(new GameListFragment());
        mFragments.add(new GameTypeFragment());
        tablayout.setTabData(titleArr, getActivity(), R.id.fl_change, mFragments);
    }
}
