package com.qf.h5.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qf.h5.R;
import com.qf.h5.adapter.MFragmentPagerAdapter;
import com.qf.h5.ui.base.BaseTabFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/22.
 */

public class GameFragment extends BaseTabFragment {
    @Bind(R.id.img_logo)
    ImageView imgLogo;
    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.tab_viewpage)
    ViewPager tabViewpage;
    private String titleArr[] = {"推荐", "热门", "分类"};
    private List<Fragment> fragments = new ArrayList<>();

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
        fragments.add(new GameListFragment());
        fragments.add(new GameListFragment());
        fragments.add(new GameTypeFragment());
        tabViewpage.setAdapter(new MFragmentPagerAdapter(getChildFragmentManager(), titleArr, fragments));
        tablayout.setupWithViewPager(tabViewpage);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
