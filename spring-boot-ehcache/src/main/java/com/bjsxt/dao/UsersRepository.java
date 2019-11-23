package com.bjsxt.dao;

import com.bjsxt.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lvyelanshan
 * @create 2019-11-21 20:31
 */
public interface UsersRepository extends JpaRepository<Users,Integer> {

}
