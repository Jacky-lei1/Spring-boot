package com.bjsxt.mapper;

import com.bjsxt.pojo.Users;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-11-19 18:48
 */
public interface UsersMapper {

    /**
     * 添加用户
     * @param users
     */
    void insertUser(Users users);

    /**
     * 查询所有用户
     * @return
     */
    List<Users> findAll();

    /**
     * 根据id查询用户
     */
    Users findUserById(Integer id);

    /**
     * 更新用户
     */
    void updateUser(Users users);

    /**
     * 删除用户
     */
    void deleteUser(Integer id);
}
