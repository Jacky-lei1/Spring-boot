package com.bjsxt;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * UserSerice测试
 * @author lvyelanshan
 * @create 2019-11-21 20:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RedisCacheApplication.class})
public class UsersServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testFindUserById(){
        //第一次查询
        System.out.println(this.userService.findUserById(1));
        //第二次查询
        System.out.println(this.userService.findUserById(1));

    }

    @Test
    public void testFindUserByPage(){
        Pageable pageable = new PageRequest(0,2);
        //第一次查询
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());

        //第二次查询
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());

        //第三次查询
        pageable = new PageRequest(0,1);
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());

    }
    @Test
    public void testFindAll(){
        //第一次查询
        System.out.println(this.userService.findUserAll().size());

        /*Users users = new Users();
        users.setAge(25);
        users.setName("lvyelanshan2");
        users.setAddress("江苏");
        this.userService.saveUsers(users);*/

        //第二次查询,取出的数据还是添加用户之前的数据
        System.out.println(this.userService.findUserAll().size());
    }
}
