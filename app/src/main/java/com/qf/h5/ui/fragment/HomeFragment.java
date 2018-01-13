package com.qf.h5.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.h5.R;
import com.qf.h5.adapter.MFragmentPagerAdapter;
import com.qf.h5.ui.base.BaseFragment;
import com.qf.h5.utils.GlideImageLoader;
import com.qf.h5.widget.MViewPager;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/22.
 */

public class HomeFragment extends Fragment {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.et_search)
    EditText etSearch;
    @Bind(R.id.slidingView)
    Banner banner;
    @Bind(R.id.mtabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.tab_viewpage)
    MViewPager mViewPager;
    private Fragment[] mFragmentArrays = new Fragment[]{new GameListFragment(), new GameListFragment(), new GameListFragment(), new GameListFragment()};
    private String[] imageUrls = {
            "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner01
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner02
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner03
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner04
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner05
    };
    private final String[] mTabTitles = {"精品推荐", "热门", "新上架", "活动"};
    private boolean isShowSearch = false;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.home_fragment_layout, null);
            ButterKnife.bind(this, rootView);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTitle.setVisibility(View.VISIBLE);
        etSearch.setVisibility(View.GONE);
        banner.setImages(Arrays.asList(imageUrls))
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .isAutoPlay(true)
                .setDelayTime(2500)
                .setIndicatorGravity(BannerConfig.CENTER)
                .setImageLoader(new GlideImageLoader())
                .start();
        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (null != banner) {
            banner.startAutoPlay();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (null != banner) {
            banner.stopAutoPlay();
        }
    }

    @OnClick({R.id.img_logo, R.id.img_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_logo:
                break;
            case R.id.img_search:
                if (isShowSearch) {
                    tvTitle.setVisibility(View.GONE);
                    etSearch.setVisibility(View.VISIBLE);
                    isShowSearch = !isShowSearch;
                } else {
                    tvTitle.setVisibility(View.VISIBLE);
                    etSearch.setVisibility(View.GONE);
                    isShowSearch = !isShowSearch;
                }
                break;
        }
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }

        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];
        }
    }
}
