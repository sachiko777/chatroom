package com.webchat.mapper;

import com.webchat.pojo.UserNew;

public interface UserMapper {

    //通过用户账号查询用户信息
    UserNew queryUserById(String userId);
}
