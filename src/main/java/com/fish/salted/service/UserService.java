package com.fish.salted.service;

import com.fish.salted.entity.User;

public interface UserService {
    //登录
    User login(String username,String password);

    //注册
    Integer register(User user);

    //查询数据库中是否已经注册改用户名
    User getUserByUsername(String username);
}
