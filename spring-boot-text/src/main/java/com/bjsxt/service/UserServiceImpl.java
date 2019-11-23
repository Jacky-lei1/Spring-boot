package com.bjsxt.service;

import com.bjsxt.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lvyelanshan
 * @create 2019-11-20 17:21
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserDaoImpl userDao;

    public void addUser(){
        userDao.addUser();
    }
}
