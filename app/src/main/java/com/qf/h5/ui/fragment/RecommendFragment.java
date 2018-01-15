package com.qf.h5.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qf.h5.BuildConfig;
import com.qf.h5.R;
import com.qf.h5.adapter.RecommendAdapter;
import com.qf.h5.bean.RecommendBean;
import com.qf.h5.ui.GameDetailActivity;
import com.qf.h5.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2018/1/15.
 */

public class RecommendFragment extends BaseFragment implements RecommendAdapter.OnRecyclerViewItemListener {
    @Bind(R.id.recommend_recyclerview)
    RecyclerView recommendRecyclerView;
    private RecommendAdapter recommendAdapter;
    private List<RecommendBean> recomList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.recommend_fragment_layout;
    }

    @Override
    protected void initWidget(View root) {
    }

    @Override
    protected void initData() {
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
    }

    @Override
    public void onItemClickListener(View view, int position) {
        Bundle b = new Bundle();
        b.putString("gamename", recomList.get(position).getGameName());
        gotoActivityWithBundle(getActivity(), GameDetailActivity.class, b);
    }
}
