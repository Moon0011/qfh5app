package com.qf.h5.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.qf.h5.bean.UserInfo;
import com.qf.h5.cache.DataCleanManager;
import com.qf.h5.utils.MethodsCompat;
import com.qf.h5.utils.StringUtils;
import com.squareup.leakcanary.LeakCanary;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.qf.h5.common.UIHelper.isMethodsCompat;

/**
 * Created by Administrator on 2017/11/22.
 */

public class H5Application extends Application {
    private List<Activity> oList;
    private static H5Application instance;
    private boolean isLogin = false;
    private static boolean sIsAtLeastGB;
    private static String PREF_NAME = "pdl.pref";
    private boolean login;

    public boolean isLogin() {
        return login;
    }

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            sIsAtLeastGB = true;
        }
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public static H5Application getInstance() {
        return instance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        oList = new ArrayList<Activity>();
        instance = this;
        init_xUtil();
        initLogin();
    }

    private String getFlurryKey() {
        ApplicationInfo appInfo = null;
        try {
            appInfo = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String msg = appInfo.metaData.getString("flurry_key");
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        return msg;
    }

    private void init_xUtil() {
        x.Ext.init(this);//继承MultiDexApplication解决部分机型xUtil初始化问题
        x.Ext.setDebug(false);
    }

    private void initLogin() {
        UserInfo userInfo = getLoginUser();
        if (null != userInfo && userInfo.getUser_id() > 0) {
            login = true;
        } else {
            this.cleanLoginInfo();
        }
    }

    /**
     * 添加Activity
     */
    public void addActivity_(Activity activity) {
        if (!oList.contains(activity)) {
            oList.add(activity);//把当前Activity添加到集合中
        }
    }

    /**
     * 销毁单个Activity
     */
    public void removeActivity_(Activity activity) {
        if (oList.contains(activity)) {
            oList.remove(activity);
            activity.finish();
        }
    }

    /**
     * 销毁所有的Activity
     */
    public void removeALLActivity_() {
        for (Activity activity : oList) {
            activity.finish();
        }
    }

    /**
     * 清除app缓存
     */
    public void clearAppCache() {
        DataCleanManager.cleanDatabases(this);
        // 清除数据缓存
        DataCleanManager.cleanInternalCache(this);
        // 2.2版本才有将应用缓存转移到sd卡的功能
        if (isMethodsCompat(Build.VERSION_CODES.FROYO)) {
            DataCleanManager.cleanCustomCache(MethodsCompat
                    .getExternalCacheDir(this));
        }
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static void apply(SharedPreferences.Editor editor) {
        if (sIsAtLeastGB) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public static void set(String key, int value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putInt(key, value);
        apply(editor);
    }

    public static void set(String key, boolean value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(key, value);
        apply(editor);
    }

    public static void set(String key, String value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(key, value);
        apply(editor);
    }

    public static boolean get(String key, boolean defValue) {
        return getPreferences().getBoolean(key, defValue);
    }

    public static String get(String key, String defValue) {
        return getPreferences().getString(key, defValue);
    }

    public static int get(String key, int defValue) {
        return getPreferences().getInt(key, defValue);
    }

    public static long get(String key, long defValue) {
        return getPreferences().getLong(key, defValue);
    }

    public static float get(String key, float defValue) {
        return getPreferences().getFloat(key, defValue);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static SharedPreferences getPreferences() {
        SharedPreferences pre = instance.getSharedPreferences(PREF_NAME,
                Context.MODE_MULTI_PROCESS);
        return pre;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static SharedPreferences getPreferences(String prefName) {
        return instance.getSharedPreferences(prefName,
                Context.MODE_MULTI_PROCESS);
    }

    /**
     * 保存登录信息
     */
    public void saveUserInfo(final UserInfo userInfo) {
        this.login = true;
        setProperties(new Properties() {
            {
                setProperty("user.user_id", String.valueOf(userInfo.getUser_id()));
                setProperty("user.username", userInfo.getUsername());
                setProperty("user.pwd", userInfo.getPwd());
                setProperty("user.credits", String.valueOf(userInfo.getCredits()));
                setProperty("user.qq", String.valueOf(userInfo.getQq()));
                setProperty("user.expire", userInfo.getExpire());
                setProperty("user.pay_card", String.valueOf(userInfo.getPay_card()));
                setProperty("user.invite_code", String.valueOf(userInfo.getInvite_code()));
            }
        });
    }

    /**
     * 更新用户信息
     */
    public void updateUserInfo(final UserInfo userInfo) {
        setProperties(new Properties() {
            {
                setProperty("user.expire", userInfo.getExpire());
            }
        });
    }

    /**
     * 获得登录用户的信息
     */
    public UserInfo getLoginUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUser_id(StringUtils.toInt(getProperty("user.user_id"), 0));
        userInfo.setUsername(getProperty("user.username"));
        userInfo.setPwd(getProperty("user.pwd"));
        userInfo.setCredits(StringUtils.toInt(getProperty("user.credits")));
        userInfo.setQq(getProperty("user.qq"));
        userInfo.setExpire(getProperty("user.expire"));
        userInfo.setPay_card(getProperty("user.pay_card"));
        userInfo.setInvite_code(getProperty("user.invite_code"));
        return userInfo;
    }

    /**
     * 清除登录信息
     */
    public void cleanLoginInfo() {
        this.login = false;
        removeProperty("user.user_id", "user.username", "user.pwd", "user.credits", "user.qq",
                "user.expire", "user.pay_card", "user.invite_code");
    }

    /**
     * 用户注销
     */
    public void Logout() {
        cleanLoginInfo();
        this.login = false;
    }

    public String getProperty(String key) {
        String res = AppConfig.getAppConfig(this).get(key);
        return res;
    }

    public void setProperties(Properties ps) {
        AppConfig.getAppConfig(this).set(ps);
    }

    public void removeProperty(String... key) {
        AppConfig.getAppConfig(this).remove(key);
    }
}
