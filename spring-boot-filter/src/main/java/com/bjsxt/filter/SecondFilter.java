package com.bjsxt.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lvyelanshan
 * @create 2019-11-16 11:30
 */
public class SecondFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤前");
        chain.doFilter(request,response);
        System.out.println("过滤后");
    }
}
