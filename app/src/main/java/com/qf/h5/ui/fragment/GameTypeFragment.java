package com.qf.h5.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.h5.R;
import com.qf.h5.adapter.GameTypeAdapter;
import com.qf.h5.bean.GameTypeBean;
import com.qf.h5.ui.GameTypeListActivity;
import com.qf.h5.ui.base.BaseTabFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/22.
 */

public class GameTypeFragment extends BaseTabFragment implements GameTypeAdapter.OnRecyclerViewItemListener {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    private GameTypeAdapter gameTypeAdapter;
    List<GameTypeBean> gameTypeBeans;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.game_list_fragment_layout, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gameTypeBeans = new ArrayList<>();
        gameTypeBeans.add(new GameTypeBean("所有分类", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"));
        gameTypeBeans.add(new GameTypeBean("冒险", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"));
        gameTypeBeans.add(new GameTypeBean("角色", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1511528825612&di=733a2bd75c475ad5d7eba3e3e86dc86f&imgtype=0&src=http%3A%2F%2Fstatic.ewoka.com%2Fuploads%2Fallimg%2F140505%2F724256_140505115818_1_lit.jpg"));

        //热门
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        gameTypeAdapter = new GameTypeAdapter(getActivity(), gameTypeBeans);
        gameTypeAdapter.setOnRecyclerViewItemListener(this);
        recyclerView.setAdapter(gameTypeAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onItemClickListener(View view, int position) {
        Bundle b = new Bundle();
        b.putString("typename", gameTypeBeans.get(position).getTypName());
        gotoActivityWithBundle(getActivity(), GameTypeListActivity.class, b);
    }
}
