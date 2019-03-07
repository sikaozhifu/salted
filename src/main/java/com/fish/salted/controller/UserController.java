package com.fish.salted.controller;

import com.fish.salted.entity.User;
import com.fish.salted.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    @ResponseBody
    public Map<String,Object> register(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        @RequestParam("email")String email){
        Map<String,Object> map = new HashMap<>();
        User exist = userService.getUserByUsername(username);
        if (exist != null){
            map.put("registerMessage", "该用户名已注册！");
            return map;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        Integer result = userService.register(user);
        if (result == 1){
            //注册成功
            map.put("registerMessage", "注册成功");
            return map;
        }
        map.put("registerMessage", "注册失败，请联系管理员...");
        return map;
    }
}
