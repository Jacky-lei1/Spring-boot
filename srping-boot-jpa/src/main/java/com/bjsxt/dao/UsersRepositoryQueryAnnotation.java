package com.bjsxt.dao;

import com.bjsxt.pojo.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * 基于@Query注解的查询
 * @author lvyelanshan
 * @create 2019-11-21 11:02
 */
public interface UsersRepositoryQueryAnnotation extends Repository<Users,Integer> {

    /**
     * 使用HQL语句查询——需要使用占位符
     * @param name
     * @return
     */
    @Query("from Users where name = ?1")
    List<Users> queryByNameUseHQL(String name);

    /**
     * 使用SQL语句查询
     */
    @Query(value = "select * from t_users where name=?",nativeQuery = true)
    List<Users> queryByNameUseSQL(String name);

    /**
     * 使用@Query注解进行DML操作
     */
    @Query("update Users set name= ?1 where id=?2")
    @Modifying //需要执行一个更新操作
    void updateUsersNameById(String name,Integer id);

}
