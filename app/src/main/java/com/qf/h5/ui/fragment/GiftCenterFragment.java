package com.qf.h5.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qf.h5.R;
import com.qf.h5.adapter.GiftCenterAdapter;
import com.qf.h5.bean.RecommendBean;
import com.qf.h5.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/22.
 */

public class GiftCenterFragment extends BaseFragment {
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    private GiftCenterAdapter giftCenterAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.gift_center_fragment_layout;
    }

    @Override
    protected void initWidget(View root) {
    }

    @Override
    protected void initData() {
        List<RecommendBean> recomList = new ArrayList<>();
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "小小军师"
                , 1231, "角色扮演"));
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"
                , "武神传说"
                , 1231, "角色扮演"));
        //热门
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        giftCenterAdapter = new GiftCenterAdapter(getActivity(), recomList);
        recyclerView.setAdapter(giftCenterAdapter);
    }
}
