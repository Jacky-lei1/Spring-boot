package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 该类下的所有的方法发生异常时根据类型的不同走的是自定义的异常控制器
 * @@ExceptionHandler
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

    /**
     * 捕获异常信息，进行不同的处理（这里以算数异常为例）
     * java.lang.ArithmeticException
     * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
     * 参数：Exception e:会将产生的异常对象注入到方法中
     *
     */
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView arithmeticExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        //将异常信息放到视图中
        mv.addObject("error",e.toString());
        //进行页面跳转
        mv.setViewName("error1");
        return mv;
    }

    /**
     * 处理空指针异常：java.lang.NullPointerException
     */
    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView NullPointerExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error2");
        return mv;
    }



}
