package com.bjsxt.dao;

import com.bjsxt.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 编写接口，第一个是实体类，第二个是主键类型
 * @author lvyelanshan
 * @create 2019-11-21 9:51
 */
public interface UsersRepository extends JpaRepository<Users,Integer> {


}
