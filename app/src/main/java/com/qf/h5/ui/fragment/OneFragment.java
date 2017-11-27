package com.qf.h5.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qf.h5.R;
import com.qf.h5.ui.base.BaseTabFragment;
import com.qf.h5.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/22.
 */

public class OneFragment extends BaseTabFragment {
    @Bind(R.id.img_logo)
    ImageView imgLogo;
    @Bind(R.id.slidingView)
    Banner banner;
    @Bind(R.id.recommendRecyclerView)
    RecyclerView recommendRecyclerView;
    @Bind(R.id.hotRecyclerView)
    RecyclerView hotRecyclerView;
    @Bind(R.id.newRecyclerView)
    RecyclerView newRecyclerView;
    private String[] imageUrls = {
            "android.resource://com.qf.h5/mipmap/" + R.mipmap.ad_center01
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.ad_center02
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.ad_center03
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.one_fragment_layout, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        banner.setImages(Arrays.asList(imageUrls))
                .isAutoPlay(true)
                .setDelayTime(2500)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setImageLoader(new GlideImageLoader())
                .start();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.img_recommend_arrow, R.id.img_hot_arrow, R.id.img_new_arrow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_recommend_arrow:
                break;
            case R.id.img_hot_arrow:
                break;
            case R.id.img_new_arrow:
                break;
        }
    }
}
