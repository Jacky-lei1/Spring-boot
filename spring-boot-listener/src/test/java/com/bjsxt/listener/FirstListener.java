package com.bjsxt.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author lvyelanshan
 * @create 2019-11-16 14:19
 */
@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("第一个Listener");
    }
}
