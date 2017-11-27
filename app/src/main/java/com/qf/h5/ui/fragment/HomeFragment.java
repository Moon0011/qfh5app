package com.qf.h5.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qf.h5.R;
import com.qf.h5.adapter.HotAdapter;
import com.qf.h5.adapter.NewAdapter;
import com.qf.h5.adapter.RecommendAdapter;
import com.qf.h5.bean.RecommendBean;
import com.qf.h5.ui.base.BaseTabFragment;
import com.qf.h5.utils.GlideImageLoader;
import com.qf.h5.widget.RoundedImageView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/22.
 */

public class HomeFragment extends BaseTabFragment {
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
    @Bind(R.id.img_recommend)
    RoundedImageView imgRecommend;
    @Bind(R.id.img_hot)
    RoundedImageView imgHot;
    @Bind(R.id.img_new)
    RoundedImageView imgNew;
    private String[] imageUrls = {
            "android.resource://com.qf.h5/mipmap/" + R.mipmap.ad_center01
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.ad_center02
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.ad_center03
    };
    private RecommendAdapter recommendAdapter;
    private NewAdapter newAdapter;
    private HotAdapter hotAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment_layout, null);
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
        List<RecommendBean> recomList = new ArrayList<>();
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "传奇来了"
                , 1231, "角色"));
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "凡人战八荒"
                , 1231, "塔防"));
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "大唐真龙"
                , 1231, "冒险"));
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "斗地主"
                , 1231, "策略"));
        //推荐
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recommendRecyclerView.setLayoutManager(gridLayoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), recomList);
        recommendRecyclerView.setAdapter(recommendAdapter);
        //热门
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        hotRecyclerView.setLayoutManager(linearLayoutManager);
        hotAdapter = new HotAdapter(getActivity(), recomList);
        hotRecyclerView.setAdapter(hotAdapter);
        //新品
        GridLayoutManager newGridLayoutManager = new GridLayoutManager(getContext(), 3);
        newRecyclerView.setLayoutManager(newGridLayoutManager);
        newAdapter = new NewAdapter(getActivity(), recomList);
        newRecyclerView.setAdapter(newAdapter);
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
}
