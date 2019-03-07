package com.fish.salted.service.impl;

import com.fish.salted.dao.UserMapper;
import com.fish.salted.entity.User;
import com.fish.salted.service.UserService;
import com.fish.salted.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        String md5Password = MD5Utils.md5(password);
        return userMapper.login(username, md5Password);
    }

    @Override
    public Integer register(User user) {
        user.setPassword(MD5Utils.md5(user.getPassword()));
        return userMapper.insert(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}
