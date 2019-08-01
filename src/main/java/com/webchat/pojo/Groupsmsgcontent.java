package com.webchat.pojo;

import java.util.Date;

//群信息表
public class Groupsmsgcontent {
    private Integer id;

    private Integer fromid;//发送者id

    private String fromuname;//发送者昵称

    private Date createtime;//发送时间

    private String content;//发送内容

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromid() {
        return fromid;
    }

    public void setFromid(Integer fromid) {
        this.fromid = fromid;
    }

    public String getFromuname() {
        return fromuname;
    }

    public void setFromuname(String fromuname) {
        this.fromuname = fromuname == null ? null : fromuname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}