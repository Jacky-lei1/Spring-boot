package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这个Controller下的所有的方法发生异常时不走ExceptionHandler（异常处理器）
 * 而是走默认的BasicExceptionController并统一请求转发到/error页面下，
 * 这个error.html页面如果没有自定义则走的是是springboot默认提供的。
 * 因为这些异常处理器在其他的Controller中
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
