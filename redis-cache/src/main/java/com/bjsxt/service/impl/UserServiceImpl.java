package com.bjsxt.service.impl;

import com.bjsxt.dao.UsersRepository;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author lvyelanshan
 * @create 2019-11-21 20:39
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Cacheable(cacheNames = "users")
    public List<Users> findUserAll() {
        return usersRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "users") //表示对当前查询的对象做缓存处理,value值表示自定义的缓存配置的策略名称
    public Users findUserById(Integer id) {
        Optional<Users> list = this.usersRepository.findById(id);
        Users users = list.get();
        return users;
    }

    @Override
    /**
     * key = "#pageable.pageSize":在缓存对象时给缓存的对象做了一个唯一标记，
     * 每次是否从缓存当中取对象，取决于是否在缓存对象中有这个标记，如果有直接把缓存的对象取出来
     * 如果没有就从数据库中进行检索
     */
    @Cacheable(cacheNames = "users")
    public Page<Users> findUserByPage(Pageable pageable) {
        return this.usersRepository.findAll(pageable);
    }

    @Override
    //删除这个key对应缓存,allEntries = true:表示方法调用后立即清空所有缓存
    @CacheEvict(cacheNames = "users",allEntries = true,beforeInvocation = true) //每次插入后为了能够重新查询(数据能够正确显示)，应该先清除上一次缓存再重新进行查询
    public void saveUsers(Users users) {
        this.usersRepository.save(users);
    }
}
