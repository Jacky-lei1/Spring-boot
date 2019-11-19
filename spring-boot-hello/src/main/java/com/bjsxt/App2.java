package com.bjsxt;

import com.bjsxt.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


/**
 * @author lvyelanshan
 * @create 2019-11-16 10:49
 */
@SpringBootApplication
public class App2 {
    public static void main(String[] args) {
        SpringApplication.run(App2.class,args);
    }

    //Springboot在初始化时会扫描这注解
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }
}
