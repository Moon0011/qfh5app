package com.qf.h5.common;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import com.qf.h5.utils.FileUtils;
import com.qf.h5.utils.MethodsCompat;
import com.qf.h5.utils.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;



/**
 * Created by Administrator on 2017/9/20.
 */

public class UIHelper {

    // 手机网络类型
    public static final int NETTYPE_WIFI = 0x01;
    public static final int NETTYPE_CMWAP = 0x02;
    public static final int NETTYPE_CMNET = 0x03;

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }

    public static void notification(Context context, String title, String content) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);//设置通知的方式，震动、LED灯、音乐等
        builder.setAutoCancel(true);//点击通知后，状态栏自动删除通知
        builder.setSmallIcon(android.R.drawable.ic_media_play);//设置小图标
//        builder.setContentIntent(PendingIntent.getActivity(context, 0x102, new Intent(this, RaingRecived.class), 0));//设置点击通知后将要启动的程序组件对应的PendingIntent
        Notification notification = builder.build();
        notificationManager.notify(0x101, notification);
    }


    public static int getNetworkType() {
        int netType = 0;
        ConnectivityManager connectivityManager = (ConnectivityManager) H5Application
                .getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return netType;
        }
        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_MOBILE) {
            String extraInfo = networkInfo.getExtraInfo();
            if (!StringUtils.isEmpty(extraInfo)) {
                if (extraInfo.toLowerCase().equals("cmnet")) {
                    netType = NETTYPE_CMNET;
                } else {
                    netType = NETTYPE_CMWAP;
                }
            }
        } else if (nType == ConnectivityManager.TYPE_WIFI) {
            netType = NETTYPE_WIFI;
        }
        return netType;
    }

    public static int getVersionCode() {
        int versionCode = 0;
        try {
            versionCode = H5Application.getInstance()
                    .getPackageManager()
                    .getPackageInfo(H5Application.getInstance().getPackageName(),
                            0).versionCode;
        } catch (PackageManager.NameNotFoundException ex) {
            versionCode = 0;
        }
        return versionCode;
    }

    /**
     * 计算缓存的大小
     */
    public static String caculateCacheSize(Context context) {
        long fileSize = 0;
        String cacheSize = "0KB";
        File filesDir = context.getFilesDir();
        File cacheDir = context.getCacheDir();

        fileSize += FileUtils.getDirSize(filesDir);
        fileSize += FileUtils.getDirSize(cacheDir);
        // 2.2版本才有将应用缓存转移到sd卡的功能
        if (isMethodsCompat(android.os.Build.VERSION_CODES.FROYO)) {
            File externalCacheDir = MethodsCompat
                    .getExternalCacheDir(context);
            fileSize += FileUtils.getDirSize(externalCacheDir);
//            fileSize += FileUtils.getDirSize(new File(
//                    FileUtils.getSDCardPath()
//                            + File.separator + HttpConfig.CACHEPATH));
        }
        if (fileSize > 0)
            cacheSize = FileUtils.formatFileSize(fileSize);
        return cacheSize;
    }

    public static boolean isMethodsCompat(int VersionCode) {
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        return currentVersion >= VersionCode;
    }

    /**
     * 清除app缓存
     */
    public static void clearAppCache(final Activity activity) {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    Toast.makeText(activity, "缓存清除成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(activity, "缓存清除失败", Toast.LENGTH_SHORT).show();
                }
            }
        };
        new Thread() {
            @Override
            public void run() {
                Message msg = new Message();
                try {
                    H5Application.getInstance().clearAppCache();
                    msg.what = 1;
                } catch (Exception e) {
                    e.printStackTrace();
                    msg.what = -1;
                }
                handler.sendMessage(msg);
            }
        }.start();
    }

    public static void call(Context context, String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    public static boolean isDataABigger(String data1, String data2) {
        int res = data1.compareTo(data2);
        if (res > 0)
            return true;
        else
            return false;
    }

    public static String getCurrTime() {
        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return tempDate.format(new java.util.Date());
    }

    //版本名
    public static String getVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }

    //版本号
    public static int getVersionCode(Context context) {
        return getPackageInfo(context).versionCode;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;
        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pi;
    }


    public static boolean isPhone(String phone) {
        String PHONE_PATTERN = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        boolean isPhone = Pattern.compile(PHONE_PATTERN).matcher(phone).matches();
        return isPhone;
    }

    public static final String getCurrData() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");
        return sDateFormat.format(new java.util.Date());
    }
}
