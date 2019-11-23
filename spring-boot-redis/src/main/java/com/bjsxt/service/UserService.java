package com.bjsxt.service;

import com.bjsxt.pojo.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-11-21 20:35
 */
public interface UserService {

    List<Users> findUserAll();
    Users findUserById(Integer id);
    Page<Users> findUserByPage(Pageable pageable);
    void saveUsers(Users users);

}
