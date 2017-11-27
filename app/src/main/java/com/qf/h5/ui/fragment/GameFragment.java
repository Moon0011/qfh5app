package com.qf.h5.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.flyco.tablayout.SegmentTabLayout;
import com.qf.h5.R;
import com.qf.h5.ui.base.BaseTabFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/22.
 */

public class GameFragment extends BaseTabFragment {
    @Bind(R.id.img_logo)
    ImageView imgLogo;
    @Bind(R.id.tablayout)
    SegmentTabLayout tablayout;
    private String titleArr[] = {"推荐", "热门", "分类"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.game_fragment_layout, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new GameListFragment());
        mFragments.add(new GameListFragment());
        mFragments.add(new GameTypeFragment());
        tablayout.setTabData(titleArr, getActivity(), R.id.fl_change, mFragments);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
