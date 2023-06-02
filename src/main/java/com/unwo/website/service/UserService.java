package com.unwo.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unwo.website.bean.User;
import com.unwo.website.mapper.UserMapper;

@Repository
public class UserService {
    
    @Autowired
    private UserMapper userMapper;

    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
