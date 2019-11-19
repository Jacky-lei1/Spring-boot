package com.bjsxt.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author lvyelanshan
 * @create 2019-11-16 11:15
 */
//@WebFilter(filterName="FirstFilter",urlPatterns={"*.do","*.jsp"})
@WebFilter(filterName = "FirstFilter",urlPatterns = "/first")
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入Filter");
        chain.doFilter(request,response); //调用接口FilterChain的实现类ApplicationFilterChain中的doFilter方法
        System.out.println("离开Filter");
    }

}
