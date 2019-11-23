package com.bjsxt;

import com.bjsxt.service.UserServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Springboot测试类
 * @RunWith：启动器
 * SpringJUnit4ClassRunner.class：让Junit与Spring环境进行整合
 * @SpringBootTest(classes={App.class}):1、当前类为springboot的测试类
 * @SpringBootTest(classes={App,class}):2、加载springboot的启动类。启动Springboot
 * @author lvyelanshan
 * @create 2019-11-20 17:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootTextApplication.class})
public class Test {

    @Autowired
    private UserServiceImpl userService;

    @org.junit.Test
    public void testAddUser(){
        this.userService.addUser();
    }

}
