package com.bjsxt.dao;

import com.bjsxt.pojo.Users;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * 这个方式在JpaRepository接口中都可以使用
 * Repository接口测试（基于方法名称命名查询）
 * @author lvyelanshan
 * @create 2019-11-21 10:38
 */
public interface UsersRepositoryByName extends Repository<Users,Integer> {

    ///方法的名称必须要遵循驼峰式命名规则。findBy(关键字)+属性名称(首字母要
    //大写)+查询条件(首字母大写)
    List<Users> findByName(String name);

    List<Users> findByNameAndAge(String name,Integer age);

    List<Users> findByNameLike(String name);

    List<Users> findByNameStartingWith(String name);

    List<Users> findByNameEndsWith(String name);



}
