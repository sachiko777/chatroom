package com.webchat.service.impl;

import com.webchat.mapper.UserMapper;
import com.webchat.pojo.UserNew;
import com.webchat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserNew queryUserById(String userId) {
        return userMapper.queryUserById(userId);
    }
}
