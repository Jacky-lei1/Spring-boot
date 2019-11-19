package com.bjsxt.service;

import com.bjsxt.pojo.Users;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-11-19 18:52
 */
public interface UsersService {
    /**
     * 添加用户
     */
    void addUser(Users users);

    /**
     * 查询所有用户
     */
    List<Users> findAll();

    /**
     * 根据id查询用户信息
     */
    Users findUserById(Integer id);

    /**
     * 更新用户
     */
    void updateUser(Users users);

    /**
     * 根据id删除用户
     */
    void deleteUser(Integer id);
}
