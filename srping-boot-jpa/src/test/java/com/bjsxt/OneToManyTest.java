package com.bjsxt;

import com.bjsxt.dao.UsersRepository;
import com.bjsxt.pojo.Roles;
import com.bjsxt.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

/**
 * 一对多关联关系测试
 * @author lvyelanshan
 * @create 2019-11-21 16:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SrpingBootJpaApplication.class)
public class OneToManyTest {

    @Autowired
    private UsersRepository usersRepository;


    /**
     * 一对多关联关系的添加
     */
    @Test
    public void testSave(){
        //创建一个用户
        Users users = new Users();
        users.setAddress("北京");
        users.setName("皇帝");
        users.setAge(25);
        //创建一个角色
        Roles roles = new Roles();
        roles.setRolename("超级管理员");

        //创建关联关系
        roles.getUsers().add(users); //建立角色和用户的关系，角色对应多个用户
        users.setRoles(roles); //建立用户和角色的关系

        //保存
        this.usersRepository.save(users);
    }

    /**
     * 一对多关联关系的查询
     */
    @Test
    public void testFind(){
        Optional<Users> user = this.usersRepository.findById(1);
        Users users = user.get();
        Roles roles = users.getRoles();
        System.out.println("用户信息："+users);
        System.out.println("角色信息："+roles);

    }
}
