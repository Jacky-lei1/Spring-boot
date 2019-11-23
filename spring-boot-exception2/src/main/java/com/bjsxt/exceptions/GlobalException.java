package com.bjsxt.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 将所有的异常处理器进行统一的管理，属于全局异常处理
 * @author lvyelanshan
 * @create 2019-11-20 15:43
 */
@ControllerAdvice //表示处理全局异常
public class GlobalException {
    /**
     * 捕获异常信息，进行不同的处理（这里以算数异常为例）
     * java.lang.ArithmeticException
     * 该方法需要返回一个ModelAndView：目的是可以让我们封装异常信息以及视图的指定
     * 参数：Exception e:会将产生的异常对象注入到方法中
     *
     */
    @ExceptionHandler(value = {ArithmeticException.class})
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
    @ExceptionHandler(value = {NullPointerException.class})
    public ModelAndView NullPointerExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error2");
        return mv;
    }
}
