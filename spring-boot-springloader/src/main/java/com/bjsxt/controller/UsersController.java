package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lvyelanshan
 * @create 2019-11-20 18:55
 */
@Controller
public class UsersController {
    @RequestMapping("/show")
    public String showPage(){
        System.out.println("showPage...init...的方式");
        return "index";
    }
}
