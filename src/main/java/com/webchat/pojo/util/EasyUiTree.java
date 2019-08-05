package com.webchat.pojo.util;

import java.util.List;

public class EasyUiTree {
    private int id;//父id-子id
    private String text;//显示内容
    private String state;//节点状态
    private String attributes;//自定义属性
    private List<EasyUiTree> children;//子节点

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public List<EasyUiTree> getChildren() {
        return children;
    }

    public void setChildren(List<EasyUiTree> children) {
        this.children = children;
    }
}
