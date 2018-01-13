package com.qf.h5.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qf.h5.R;
import com.qf.h5.adapter.GameListAdapter;
import com.qf.h5.bean.RecommendBean;
import com.qf.h5.ui.base.BaseFragment;
import com.qf.h5.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/27.
 */

public class GiftFragment extends BaseFragment {
    @Bind(R.id.slidingView)
    Banner banner;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    private String[] imageUrls = {
            "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner01
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner02
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner03
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner04
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner05
    };
    private GameListAdapter hotAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.gift_fragment_laytout;
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
        List<RecommendBean> recomList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                    , "斗地主"
                    , 1231, "策略"));
        }
        //recyclerView在套一层RelativeLayout可以使其整体滑动
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        hotAdapter = new GameListAdapter(getActivity(), recomList);
        recyclerView.setAdapter(hotAdapter);
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
}
