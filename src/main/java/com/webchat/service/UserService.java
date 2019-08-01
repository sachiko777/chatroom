package com.webchat.service;

import com.webchat.pojo.UserNew;

public interface UserService {
    //通过用户账号查询用户信息
    UserNew queryUserById(String userId);
}
