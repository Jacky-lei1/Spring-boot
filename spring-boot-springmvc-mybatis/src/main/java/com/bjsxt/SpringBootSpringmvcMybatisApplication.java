package com.bjsxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bjsxt.mapper") //@MapperScan:用户扫描Mybatis的Mapper接口，根据扫描的结果生成代理对象
public class SpringBootSpringmvcMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSpringmvcMybatisApplication.class, args);
    }

}
