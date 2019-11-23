package com.bjsxt.dao;

import com.bjsxt.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author lvyelanshan
 * @create 2019-11-21 15:00
 */
public interface UsersRepositorySpecification extends JpaRepository<Users,Integer>,JpaSpecificationExecutor<Users> {
}
