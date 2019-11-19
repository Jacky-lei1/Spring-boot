package com.bjsxt;

import com.bjsxt.filter.SecondFilter;
import com.bjsxt.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


/**
 * @author lvyelanshan
 * @create 2019-11-16 11:35
 */
@SpringBootApplication
public class App2 {
    public static void main(String[] args) {
        SpringApplication.run(App2.class,args);
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new SecondServlet());
        servletRegistrationBean.addUrlMappings("/second");
        return servletRegistrationBean;
    }

    @Bean
    FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new SecondFilter());
        filterRegistrationBean.addUrlPatterns("/second");
        return filterRegistrationBean;
    }
}
