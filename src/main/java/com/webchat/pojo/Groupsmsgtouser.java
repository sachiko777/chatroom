package com.webchat.pojo;

import java.util.Date;

//群消息关联表
public class Groupsmsgtouser {
    private Integer id;

    private Integer userid;//接收者id

    private Integer groupmessageid;//群消息id

    private Boolean state;//接收状态

    private Date createtime;//发送时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGroupmessageid() {
        return groupmessageid;
    }

    public void setGroupmessageid(Integer groupmessageid) {
        this.groupmessageid = groupmessageid;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}