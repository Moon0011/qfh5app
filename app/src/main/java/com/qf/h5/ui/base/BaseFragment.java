package com.qf.h5.ui.base;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qf.h5.R;
import com.qf.h5.utils.StringUtils;
import com.qf.h5.widget.GifView;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/21.
 */

public abstract class BaseFragment extends Fragment {
    protected View mRoot;
    protected LayoutInflater mInflater;
    private Dialog mDialog;

    protected abstract int getLayoutId();

    protected abstract void initWidget(View root);

    protected abstract void initData();

    protected void showToast(String msg) {
        if (!StringUtils.isEmpty(msg)) {
            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    protected void gotoActivity(Activity activity, Class nextActivity) {
        startActivity(new Intent(activity, nextActivity));
    }

    protected void gotoActivityWithBundle(Activity activity, Class nextActivity, Bundle bundle) {
        Intent intent = new Intent(activity, nextActivity);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRoot != null) {
            ViewGroup parent = (ViewGroup) mRoot.getParent();
            if (parent != null)
                parent.removeView(mRoot);
        } else {
            mRoot = inflater.inflate(getLayoutId(), container, false);
            mInflater = inflater;
            // Do something
            onBindViewBefore(mRoot);
            // Bind view
            ButterKnife.bind(this, mRoot);
            // Get savedInstanceState
            if (savedInstanceState != null)
                onRestartInstance(savedInstanceState);
            // Init
            initWidget(mRoot);
            initData();
        }
        return mRoot;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    protected void onBindViewBefore(View root) {
        // ...
    }

    protected void onRestartInstance(Bundle bundle) {

    }

    protected void showLoading() {
        try {
            mDialog = new Dialog(getActivity(), R.style.loading_customDialog);
            View view = LayoutInflater.from(getActivity()).inflate(
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
