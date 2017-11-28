package com.qf.h5.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.qf.h5.R;
import com.qf.h5.ui.base.BaseFragment;
import com.qf.h5.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.Arrays;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/28.
 */

public class OpenServiceFragment extends BaseFragment {
    @Bind(R.id.slidingView)
    Banner banner;
    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.tab_viewpager)
    ViewPager tabViewpager;
    private String[] imageUrls = {
            "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner01
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner02
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner03
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner04
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner05
    };
    private Fragment[] mFragmentArrays = new Fragment[]{new GameListFragment(), new GameListFragment()};
    private String[] mTabTitles = new String[]{"今日最新", "未来一周"};


    @Override
    protected int getLayoutId() {
        return R.layout.open_service_fragment_layout;
    }

    @Override
    protected void initWidget(View root) {
        banner.setImages(Arrays.asList(imageUrls))
                .isAutoPlay(true)
                .setDelayTime(2500)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    @Override
    protected void initData() {
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getFragmentManager());
        tabViewpager.setAdapter(pagerAdapter);
        tablayout.setupWithViewPager(tabViewpager);
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
