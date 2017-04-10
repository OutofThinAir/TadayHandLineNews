package com.outofthinair.tadaynews.bean;

/**
 * Created by Administrator on 2017/3/24.
 */

public class UserBean {
    private int id;
    private String uname;
    private String headPic;
    private String login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", headPic='" + headPic + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
