package com.qf.h5.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qf.h5.R;
import com.qf.h5.adapter.ActAdapter;
import com.qf.h5.adapter.GameListAdapter;
import com.qf.h5.bean.RecommendBean;
import com.qf.h5.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/22.
 */

public class ActFragment extends BaseFragment {
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    private ActAdapter hotAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.act_fragment_layout;
    }

    @Override
    protected void initWidget(View root) {
    }

    @Override
    protected void initData() {
        List<RecommendBean> recomList = new ArrayList<>();
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "http://img3.imgtn.bdimg.com/it/u=817223843,4027520229&fm=214&gp=0.jpg"
                , "《侠客行》跨年团购双倍奖！令狐冲带你笑傲元旦"
                , 1231, "角色扮演"));
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "http://img3.imgtn.bdimg.com/it/u=817223843,4027520229&fm=214&gp=0.jpg"
                , "凡人战八荒"
                , 1231, "角色扮演"));
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "http://img3.imgtn.bdimg.com/it/u=817223843,4027520229&fm=214&gp=0.jpg"
                , "大唐真龙"
                , 1231, "角色扮演"));
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "http://img3.imgtn.bdimg.com/it/u=817223843,4027520229&fm=214&gp=0.jpg"
                , "斗地主"
                , 1231, "棋牌娱乐"));
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "http://img3.imgtn.bdimg.com/it/u=817223843,4027520229&fm=214&gp=0.jpg"
                , "传奇来了"
                , 1231, "角色扮演"));
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "http://img3.imgtn.bdimg.com/it/u=817223843,4027520229&fm=214&gp=0.jpg"
                , "凡人战八荒"
                , 1231, "角色扮演")); recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "http://img3.imgtn.bdimg.com/it/u=817223843,4027520229&fm=214&gp=0.jpg"
                , "传奇来了"
                , 1231, "角色扮演"));
        recomList.add(new RecommendBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511526181888&di=98054ebc2db8e614c3dc225fddc4d912&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c3db581050c2a84a0d304ff95d9f.jpg%401280w_1l_2o_100sh.jpg"
                , "http://img3.imgtn.bdimg.com/it/u=817223843,4027520229&fm=214&gp=0.jpg"
                , "凡人战八荒"
                , 1231, "角色扮演"));
        //热门
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        hotAdapter = new ActAdapter(getActivity(), recomList);
        recyclerView.setAdapter(hotAdapter);
    }
}
