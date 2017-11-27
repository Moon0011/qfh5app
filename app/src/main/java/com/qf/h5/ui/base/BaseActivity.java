package com.qf.h5.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


import com.qf.h5.R;
import com.qf.h5.common.H5Application;
import com.qf.h5.utils.StringUtils;
import com.qf.h5.widget.GifView;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/21.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    private H5Application application;
    private BaseActivity oContext;
    private Dialog mDialog, mDialog2;

    protected abstract int getLayoutById();

    protected abstract void initView();

    protected abstract void initData();

    protected void gotoActivity(Activity activity, Class nextActivity) {
        startActivity(new Intent(activity, nextActivity));
    }

    protected void gotoActivityWithBundle(Activity activity, Class nextActivity, Bundle bundle) {
        Intent intent = new Intent(activity, nextActivity);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        mContext = this;
        oContext = this;
        if (application == null) {
            application = (H5Application) getApplication();
        }
        addActivity();
        if (getLayoutById() != 0) {
            setContentView(getLayoutById());
        }
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected void hideBottomUIMenu() {//隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity();
    }

    protected String getStringRes(int resid) {
        return getResources().getString(resid);
    }

    protected void showToast(String msg) {
        if (!StringUtils.isEmpty(msg)) {
            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        }
    }

    protected void showToast(int resid) {
        String msg = getResources().getString(resid);
        if (!StringUtils.isEmpty(msg)) {
            Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        }
    }

    public void addActivity() {
        application.addActivity_(oContext);
    }

    public void removeActivity() {
        application.removeActivity_(oContext);
    }

    public void removeALLActivity() {
        application.removeALLActivity_();
    }

    protected void showLoading() {
        try {
            mDialog = new Dialog(mContext, R.style.loading_customDialog);
            View view = LayoutInflater.from(mContext).inflate(
                    R.layout.loading_layout, null);
            GifView gifView = (GifView) view.findViewById(R.id.gifView);
            gifView.setMovieResource(R.raw.loading);
            mDialog.setCancelable(false);
            mDialog.setCanceledOnTouchOutside(false);
            mDialog.setContentView(view);
            if (null != mDialog && !mDialog.isShowing()) {
                mDialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void showLoading2(final Activity activity) {
        try {
            if (mDialog2 != null && mDialog2.isShowing()) {
                mDialog2.dismiss();
            }
            mDialog2 = new Dialog(mContext, R.style.loading_customDialog);
            mDialog2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    activity.finish();
                }
            });
            View view = LayoutInflater.from(mContext).inflate(
                    R.layout.loading_layout, null);
            GifView gifView = (GifView) view.findViewById(R.id.gifView);
            mDialog2.setCanceledOnTouchOutside(false);
            gifView.setMovieResource(R.raw.loading);
            mDialog2.setContentView(view);
            if (null != mDialog2 && !mDialog2.isShowing()) {
                mDialog2.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void dismissLoading2() {
        try {
            if (null != mDialog2 && mDialog2.isShowing()) {
                mDialog2.dismiss();
                mDialog2 = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void dismissLoading() {
        try {
            if (null != mDialog && mDialog.isShowing()) {
                mDialog.dismiss();
                mDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
