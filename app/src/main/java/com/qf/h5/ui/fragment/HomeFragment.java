package com.qf.h5.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qf.h5.R;
import com.qf.h5.adapter.GameListAdapter;
import com.qf.h5.adapter.MViewPagerAdapter;
import com.qf.h5.adapter.RecommendAdapter;
import com.qf.h5.bean.RecommendBean;
import com.qf.h5.ui.base.BaseFragment;
import com.qf.h5.utils.GlideImageLoader;
import com.qf.h5.widget.MViewPager;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/11/22.
 */

public class HomeFragment extends BaseFragment {
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
    private RecyclerView recommendRecycleview, hotRecycleView, newRecycleView, actRecycleView;
    private String[] imageUrls = {
            "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner01
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner02
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner03
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner04
            , "android.resource://com.qf.h5/mipmap/" + R.mipmap.banner05
    };
    private boolean isShowSearch = false;
    private View view1, view2, view3, view4;
    private LayoutInflater mInflater;
    private final List<View> mViewList = new ArrayList<>();
    private final String[] mTitleArr = {"精品推荐", "热门", "新上架", "活动"};
    private RecommendAdapter recommendAdapter;
    private GameListAdapter gameListAdapter;
    private List<RecommendBean> datas;

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment_layout;
    }

    @Override
    protected void initWidget(View root) {
        tvTitle.setVisibility(View.VISIBLE);
        etSearch.setVisibility(View.GONE);
        banner.setImages(Arrays.asList(imageUrls))
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .isAutoPlay(true)
                .setDelayTime(2500)
                .setIndicatorGravity(BannerConfig.CENTER)
                .setImageLoader(new GlideImageLoader())
                .start();
        mInflater = LayoutInflater.from(getActivity());
        view1 = mInflater.inflate(R.layout.recommend_fragment_layout, null);
        view2 = mInflater.inflate(R.layout.hot_fragment_layout, null);
        view3 = mInflater.inflate(R.layout.new_fragment_layout, null);
        view4 = mInflater.inflate(R.layout.activity_fragment_layout, null);
        recommendRecycleview = (RecyclerView) view1.findViewById(R.id.recommend_recyclerview);
        hotRecycleView = (RecyclerView) view2.findViewById(R.id.hot_recyclerview);
        newRecycleView = (RecyclerView) view3.findViewById(R.id.new_recyclerview);
        actRecycleView = (RecyclerView) view4.findViewById(R.id.act_recyclerview);
    }

    @Override
    protected void initData() {
        datas = new ArrayList<>();
        datas.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "传奇来了"
                , 1231, "角色"));
        datas.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "凡人战八荒"
                , 1231, "塔防"));
        datas.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "大唐真龙"
                , 1231, "冒险"));
        datas.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "斗地主"
                , 1231, "策略"));
        datas.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "传奇来了"
                , 1231, "角色"));
        datas.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "凡人战八荒"
                , 1231, "塔防"));
        datas.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "大唐真龙"
                , 1231, "冒险"));
        datas.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "斗地主"
                , 1231, "策略"));

        mViewList.clear();
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);

        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleArr[0]), true);
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleArr[1]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleArr[2]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleArr[3]));

        MViewPagerAdapter mAdapter = new MViewPagerAdapter(mViewList, mTitleArr);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        initRecommend();
        initHot();
        initNew();
        initActivity();
    }

    private void initRecommend() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recommendRecycleview.setLayoutManager(gridLayoutManager);
        recommendAdapter = new RecommendAdapter(getActivity(), datas);
        recommendRecycleview.setAdapter(recommendAdapter);
    }

    private void initHot() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        hotRecycleView.setLayoutManager(linearLayoutManager);
        gameListAdapter = new GameListAdapter(getActivity(), datas);
        hotRecycleView.setAdapter(gameListAdapter);
    }

    private void initNew() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        newRecycleView.setLayoutManager(linearLayoutManager);
        gameListAdapter = new GameListAdapter(getActivity(), datas);
        newRecycleView.setAdapter(gameListAdapter);
    }

    private void initActivity() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        actRecycleView.setLayoutManager(linearLayoutManager);
        gameListAdapter = new GameListAdapter(getActivity(), datas);
        actRecycleView.setAdapter(gameListAdapter);
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
}
