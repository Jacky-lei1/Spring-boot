package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lvyelanshan
 * @create 2019-11-20 15:44
 */
@Controller
public class UsersController {

    //空指针异常
    @RequestMapping("/show3")
    public String showUsers(){
        String str = null;
        str.length();
        return "index";
    }

    //算数异常
    @RequestMapping("/show4")
    public String showUsers2(){
        int i = 10/0;
        return "index";
    }
}
