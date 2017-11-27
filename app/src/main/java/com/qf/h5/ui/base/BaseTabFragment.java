package com.qf.h5.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.qf.h5.R;
import com.qf.h5.utils.StringUtils;
import com.qf.h5.widget.GifView;


/**
 * Created by Administrator on 2017/10/31.
 */

public class BaseTabFragment extends Fragment {
    private Dialog mDialog;

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
