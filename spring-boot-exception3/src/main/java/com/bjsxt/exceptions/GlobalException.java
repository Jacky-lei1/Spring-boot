package com.bjsxt.exceptions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 *  在全局异常类中添加一个方法完成异常的统一处理，可是有个缺点
 *  无法通过ModelAndView将数据传入视图层中
 * @author lvyelanshan
 * @create 2019-11-20 15:43
 */
@Configuration
public class GlobalException {

    /**
     * 该方法必须要有一个返回值，返回值类型必须是
     * SimpleMappingExceptionResolver
     */
    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();

        Properties mappings = new Properties();
        /**
         * 参数一：异常类型，注意必须是异常类型的全名
         * 参数二：视图名称（需要跳转的视图）
         * 这种不同于@ControllerAdvice+@ExceptionHandler注解的方式，无法设置视图信息
         */
        mappings.put("java.lang.ArithmeticException","error1");
        mappings.put("java.lang.NullPointerException","error2");

        //设置异常与视图的映射信息
        resolver.setExceptionMappings(mappings);

        return resolver;
    }

}
