package com.webchat.mapper;

import com.webchat.pojo.Friendgroups;
import com.webchat.pojo.Friends;

import java.util.List;

public interface FriendMapper {
    /**
     * 通过用户id查询用户的好友列表
     * @param userId
     * @return
     */
    List<Friends> queryFriendById(Short userId);

    /**
     * 通过userid和分组id查询分组下的好友列表
     * @param gid
     * @return
     */
    List<Friends> queryFriendByGroupId(Short gid);

    /**
     * 通过userid查询分组信息
     * @param userId
     * @return
     */
    List<Friendgroups> queryFriendGroupsByUserId(Short userId);


}
