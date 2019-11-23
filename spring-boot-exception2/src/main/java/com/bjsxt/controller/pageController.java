package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lvyelanshan
 * @create 2019-11-20 14:31
 */
@Controller
public class pageController {

    /*产生空指针异常*/
    @RequestMapping("/show1")
    public String showPage(){
        String str = null;
        str.length();
        return "index";
    }

    /*产生算数异常*/
    @RequestMapping("/show2")
    public String showPage2(){
        int i = 10/0;
        return "index";
    }



}
