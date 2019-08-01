package com.webchat.pojo;

import java.util.Date;

public class Messages {
    private Integer id;

    private String postmessage;//消息内容

    private Boolean status;//接收状态

    private Date posttime;//发送时间

    private String fromuserid;//发送者账号

    private String touserid;//接收者账号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostmessage() {
        return postmessage;
    }

    public void setPostmessage(String postmessage) {
        this.postmessage = postmessage == null ? null : postmessage.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }


    public String getFromuserid() {
        return fromuserid;
    }

    public void setFromuserid(String fromuserid) {
        this.fromuserid = fromuserid;
    }

    public String getTouserid() {
        return touserid;
    }

    public void setTouserid(String touserid) {
        this.touserid = touserid;
    }
}