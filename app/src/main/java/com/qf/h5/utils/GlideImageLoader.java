package com.qf.h5.utils;

import android.content.Context;
import android.widget.ImageView;

import com.qf.h5.R;
import com.qf.h5.common.GlideApp;
import com.youth.banner.loader.ImageLoader;


public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //具体方法内容自己去选择，次方法是为了减少banner过多的依赖第三方包，所以将这个权限开放给使用者去选择
        GlideApp.with(context.getApplicationContext())
                .load(path)
                .placeholder(R.mipmap.error_pic)
                .error(R.mipmap.error_pic)
                .into(imageView);
    }

//    @Override
//    public ImageView createImageView(Context context) {
//        //圆角
//        return new RoundAngleImageView(context);
//    }
}
