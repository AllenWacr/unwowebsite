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

    public User selectUser(User user, String flag) {
        User selectUser;
        switch(flag) {
            case "id": selectUser = userMapper.selectUserById(user.getId()); break;
            case "username": selectUser = userMapper.selectUserByUsername(user.getUsername()); break;
            case "email": selectUser = userMapper.selectUserByEmail(user.getEmail()); break;
            default: return null;
        }
        return selectUser;
    }

    public int updateUser(User user, String flag) {
        int success;
        switch(flag) {
            case "username": success = userMapper.updateUserUsername(user); break;
            case "password": success = userMapper.updateUserPassword(user); break;
            default: success = -1;
        }
        return success;
    }

    public int deleteUser(User user) {
        return userMapper.deleteUser(user.getId());
    }

    public int login(User user) {
        int success;
        User authUser = userMapper.selectUserByUsername(user.getUsername());
        if(authUser != null) {
            if(authUser.getPassword().equals(user.getPassword())) {
                success = 0;
            } else {
                success = 1;
            }
        } else {
            success = -1;
        }
        return success;
    }
}
