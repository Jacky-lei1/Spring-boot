package com.bjsxt.service.impl;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-11-19 18:53
 */
@Service
@Transactional //表示这个类下的所有方法都是受事物控制的
public class UsersServiceImpl implements UsersService {

    @Autowired(required = false)
    private UsersMapper usersMapper;

    @Override
    public void addUser(Users users) {
        this.usersMapper.insertUser(users);
    }

    @Override
    public List<Users> findAll() {
        return usersMapper.findAll();
    }

    @Override
    public Users findUserById(Integer id) {
        return usersMapper.findUserById(id);
    }

    @Override
    public void updateUser(Users users) {
        this.usersMapper.updateUser(users);
    }

    @Override
    public void deleteUser(Integer id) {
        this.usersMapper.deleteUser(id);
    }
}
