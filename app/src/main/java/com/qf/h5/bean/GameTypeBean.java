package com.qf.h5.bean;

/**
 * Created by Administrator on 2017/11/27.
 */

public class GameTypeBean {
    private String typName;
    private String typeLogo;

    public GameTypeBean(String typName, String typeLogo) {
        this.typName = typName;
        this.typeLogo = typeLogo;
    }

    public String getTypName() {
        return typName;
    }

    public void setTypName(String typName) {
        this.typName = typName;
    }

    public String getTypeLogo() {
        return typeLogo;
    }

    public void setTypeLogo(String typeLogo) {
        this.typeLogo = typeLogo;
    }
}
