package com.qf.h5.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qf.h5.R;
import com.qf.h5.ui.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hover on 2018/1/15.
 */

public class GameDetailActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_header)
    TextView tvHeader;
    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.game_logo)
    ImageView gameLogo;
    @Bind(R.id.titleLayout)
    LinearLayout titleLayout;

    @Override
    protected int getLayoutById() {
        return R.layout.game_detail_layout;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        tvTitle.setText(getIntent().getExtras().getString("gamename"));
        tvHeader.setText(getIntent().getExtras().getString("gamename"));
    }

    @OnClick({R.id.img_back, R.id.game_logo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.game_logo:
                break;
        }
    }
}
