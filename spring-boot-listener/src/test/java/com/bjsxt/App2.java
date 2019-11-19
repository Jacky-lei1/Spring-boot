package com.bjsxt;

import com.bjsxt.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author lvyelanshan
 * @create 2019-11-16 14:24
 */
@SpringBootApplication
public class App2 {
    public static void main(String[] args) {
        SpringApplication.run(App2.class,args);
    }

    /**
     * 注册bean
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean<SecondListener>(new SecondListener());
        return bean;
    }
}
