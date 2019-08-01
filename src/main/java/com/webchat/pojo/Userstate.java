package com.webchat.pojo;

//用户状态表
public class Userstate {
    private Integer id;

    private String statename;//状态名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename == null ? null : statename.trim();
    }
}