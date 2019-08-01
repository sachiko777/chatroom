package com.webchat.pojo;

import java.util.Date;

public class UserNew {
    private Integer id;

    private String userid;//登录id

    private String nickname;//昵称

    private String password;//密码

    private Boolean sex;//性别

    private Date birthday;//生日

    private String headimg;//头像

    private Integer userstatusid;//用户状态id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public Integer getUserstatusid() {
        return userstatusid;
    }

    public void setUserstatusid(Integer userstatusid) {
        this.userstatusid = userstatusid;
    }
}