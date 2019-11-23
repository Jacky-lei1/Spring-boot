package com.bjsxt.dao;

import com.bjsxt.pojo.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author lvyelanshan
 * @create 2019-11-21 14:18
 */
public interface UsersRepositoryPagingAndSorting extends PagingAndSortingRepository<Users,Integer> {


}
