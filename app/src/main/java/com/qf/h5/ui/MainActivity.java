package com.qf.h5.ui;

import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.qf.h5.R;
import com.qf.h5.ui.base.BaseActivity;
import com.qf.h5.ui.fragment.BenefitsFragment;
import com.qf.h5.ui.fragment.GameTypeFragment;
import com.qf.h5.ui.fragment.HomeFragment;

public class MainActivity extends BaseActivity {
    private FragmentTabHost mTabHost;
    private final Class fragmentArray[] = {HomeFragment.class, GameTypeFragment.class, BenefitsFragment.class, BenefitsFragment.class};
    private int mTitleArray[] = {R.string.homepage, R.string.game, R.string.fuli, R.string.personal};
    private int mImageViewArray[] = {R.drawable.tab_home, R.drawable.tab_game, R.drawable.tab_fuli, R.drawable.tab_personal};
    private String mTextviewArray[] = {"首页", "游戏", "福利", "个人"};

    @Override
    protected int getLayoutById() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.contentPanel);
        int fragmentCount = fragmentArray.length;
        for (int i = 0; i < fragmentCount; ++i) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.getTabWidget().setDividerDrawable(null);
        }
        mTabHost.setCurrentTab(0);
    }

    @Override
    protected void initData() {
    }

    private View getTabItemView(int index) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_tab_layout, null);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        icon.setImageResource(mImageViewArray[index]);
        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(mTitleArray[index]);
        return view;
    }
}
