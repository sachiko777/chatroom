package com.webchat.service;

import com.webchat.pojo.util.EasyUiTree;

import java.util.List;

public interface FriendService {

    public List<EasyUiTree> findFriendListByParentId(Short userid,Short pid);

}
