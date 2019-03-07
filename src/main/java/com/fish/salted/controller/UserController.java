package com.fish.salted.controller;

import com.fish.salted.entity.User;
import com.fish.salted.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(
            @RequestParam("username")String username,
            @RequestParam("password")String password,
            HttpSession session,
            HttpServletRequest request){
        User user = userService.login(username, password);
        if (user == null){
            //登录失败
            request.setAttribute("loginMessage", "用户名或者密码错误！");
            return "forward:/page/login";
        }
        //登录成功
        session.setAttribute("user", user);
        return "redirect:/page/index";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(User user,HttpServletRequest request){
        User exist = userService.getUserByUsername(user.getUsername());
        if (exist != null){
            request.setAttribute("registerMessage", "该用户名已注册！");
            return "forward:/page/register";
        }
        Integer result = userService.register(user);
        if (result == 1){
            //注册成功
            return "redirect:/page/login";
        }
        request.setAttribute("registerMessage", "注册失败，请联系管理员...");
        return "forward:/page/register";
    }
}
