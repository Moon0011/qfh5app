package com.qf.h5.bean;

/**
 * Created by Administrator on 2017/11/24.
 */

public class RecommendBean {
    private String bgurl;
    private String gameName;
    private int count;
    private String icon;
    private String type;

    public RecommendBean(String bgurl, String icon, String gameName, int count, String type) {
        this.bgurl = bgurl;
        this.icon = icon;
        this.gameName = gameName;
        this.count = count;
        this.type = type;
    }

    public String getBgurl() {
        return bgurl;
    }

    public void setBgurl(String bgurl) {
        this.bgurl = bgurl;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
