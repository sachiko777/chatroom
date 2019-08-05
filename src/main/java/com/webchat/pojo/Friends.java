package com.webchat.pojo;

//好友表
public class Friends {
    private Integer id;

    private Integer firendid;//好友id

    private Integer userid;//自己的id

    private String nickname;//好友备注

    private String friendAccount;//好友账号

    private Integer friendgroupid;//好友所在分组id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirendid() {
        return firendid;
    }

    public void setFirendid(Integer firendid) {
        this.firendid = firendid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getFriendgroupid() {
        return friendgroupid;
    }

    public void setFriendgroupid(Integer friendgroupid) {
        this.friendgroupid = friendgroupid;
    }


    public String getFriendAccount() {
        return friendAccount;
    }

    public void setFriendAccount(String friendAccount) {
        this.friendAccount = friendAccount;
    }
}