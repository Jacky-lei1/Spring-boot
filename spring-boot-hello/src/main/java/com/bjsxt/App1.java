package com.bjsxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author lvyelanshan
 * @create 2019-11-16 10:41
 */
@SpringBootApplication
@ServletComponentScan //在springBoot启动时会扫描@WebServlet,并将该类实例化
public class App1 {
    public static void main(String[] args) {
        SpringApplication.run(App1.class,args);
    }
}
