package com.qf.h5.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/27.
 */

public class UserInfo implements Serializable {
    /**
     * username : qf001
     * qq : null
     * user_id : 7
     * credits : 99500
     * expire : 2017-09-26 16:58:57
     * pay_card : null
     */

    private String username;
    private String pwd;
    private Object qq;
    private int user_id;
    private int credits;
    private String expire;
    private String invite_code;
    private Object pay_card;

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getQq() {
        return qq;
    }

    public void setQq(Object qq) {
        this.qq = qq;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public Object getPay_card() {
        return pay_card;
    }

    public void setPay_card(Object pay_card) {
        this.pay_card = pay_card;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", qq=" + qq +
                ", user_id=" + user_id +
                ", credits=" + credits +
                ", expire='" + expire + '\'' +
                ", pay_card=" + pay_card +
                '}';
    }
}
