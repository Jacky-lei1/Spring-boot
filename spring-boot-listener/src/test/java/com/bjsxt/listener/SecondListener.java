package com.bjsxt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author lvyelanshan
 * @create 2019-11-16 14:23
 */
public class SecondListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("第二个Listener");
    }
}
