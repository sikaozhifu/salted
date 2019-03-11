package com.fish.salted.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping(value = "/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping(value = "/register")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "/checkout")
    public String toCheckOut(){
        return "checkout";
    }

    @RequestMapping(value = "/contact")
    public String toContact(){
        return "contact";
    }
    @RequestMapping(value = "/products")
    public String toProducts(){
        return "products";
    }

    @RequestMapping(value = "/single")
    public String toSingle(){
        return "single";
    }

    @RequestMapping(value = "/wishList")
    public String toWishList(){
        return "wishList";
    }
}
