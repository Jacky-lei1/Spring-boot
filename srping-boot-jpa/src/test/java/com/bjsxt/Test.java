package com.bjsxt;

import com.bjsxt.dao.*;
import com.bjsxt.pojo.Users;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lvyelanshan
 * @create 2019-11-21 9:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SrpingBootJpaApplication.class})
public class Test {
    @Autowired
    private UsersRepositoryByName usersRepositoryByName;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;

    @Autowired
    private UsersRepositoryCrudRepository usersRepositoryCrudRepository;

    @Autowired
    private UsersRepositoryPagingAndSorting usersRepositoryPagingAndSorting;

    @Autowired
    private UsersRepositorySpecification usersRepositorySpecification;

    @org.junit.Test
    public void testSave(){
        Users users = new Users();
        users.setName("王五");
        users.setAge(22);
        users.setAddress("上海");
        usersRepository.save(users);

    }

    /**
     * 方法名称名称查询测试
     */
    @org.junit.Test
    public void testFindByName(){
        List<Users> list = this.usersRepositoryByName.findByName("张三");
        for(Users u:list){
            System.out.println(u);
        }
    }

    /**
     * 方法名称命名查询2
     */
    @org.junit.Test
    public void testFindByNameAndAge(){
        List<Users> list = this.usersRepositoryByName.findByNameAndAge("张三", 20);
        for(Users users:list){
            System.out.println(users);
        }
    }

    /**
     * 方法名称命名查询3
     */
    @org.junit.Test
    public void testFindByNameLike(){
        List<Users> list = this.usersRepositoryByName.findByNameLike("张%");
        for(Users users:list){
            System.out.println(users);
        }
    }

    @org.junit.Test
    public void testFindByNameStartWith(){
        List<Users> list = this.usersRepositoryByName.findByNameStartingWith("张");
        for(Users users:list){
            System.out.println(users);
        }
    }

    @org.junit.Test
    public void testFindByNameEndsWith(){
        List<Users> list = this.usersRepositoryByName.findByNameEndsWith("三");
        for(Users users:list){
            System.out.println(users);
        }
    }


    /**
     * 使用@Query注解查询——HQL语句
     */
    @org.junit.Test
    public void testqueryByNameUseHQL(){
        List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseHQL("张三");
        for(Users users:list){
            System.out.println(users);
        }
    }

    /**
     * 使用@Query注解查询——SQL语句
     */
    @org.junit.Test
    public void testqueryByNameUseSQL(){
        List<Users> list = this.usersRepositoryQueryAnnotation.queryByNameUseSQL("王五");
        for(Users users:list){
            System.out.println(users);
        }

    }

    /**
     * 使用@Query注解完成DML操作
     */
    @org.junit.Test
    @Transactional//@Transactional 与@Test 一起使用时 事务是自动回滚的
    @Rollback(false) //取消自动回滚
    public void testupdateUsersNameById(){
        this.usersRepositoryQueryAnnotation.updateUsersNameById("绿野蓝杉",3);

    }

    /**
     * CrudRepository测试
     * 增加
     */
    @org.junit.Test
    public void testCrudRepositorySave(){
        Users users = new Users();
        users.setAddress("天津");
        users.setAge(18);
        users.setName("小栗");
        this.usersRepositoryCrudRepository.save(users);
    }

    /**
     * CrudRepository测试
     * 更新
     */
    @org.junit.Test
    public void testCrudRepositoryUpdate(){
        Users users = new Users();
        users.setName("小栗");
        users.setAge(20);
        users.setId(4);
        users.setAddress("沧州");
        this.usersRepositoryCrudRepository.save(users);
    }

    /**
     * CrudRepository测试
     * 根据id查询
     */
    @org.junit.Test
    public void testCrudRepositoryFindOne(){
        Optional<Users> list = this.usersRepositoryCrudRepository.findById(4);
        System.out.println(list);

    }

    /**
     * CrudRepository测试
     * 查询所有
     */
    @org.junit.Test
    public void testCrudRepositoryFindAll(){
        Iterable<Users> all = this.usersRepositoryCrudRepository.findAll();
        System.out.println(all);
    }

    /**
     * CrudRepository测试
     * 根据id删除
     */
    @org.junit.Test
    public void testCrudRepositoryDeleteById(){
        this.usersRepositoryCrudRepository.deleteById(4);
    }

    /**
     * CrudRepository测试
     * 根据对象删除(至少要给定id才能通过这种方式删除！)
     */
    @org.junit.Test
    public void testCrudRepositoryDeleteByUsers(){
        Users users = new Users();
        users.setName("王五");
        users.setId(5);
        this.usersRepositoryCrudRepository.delete(users);
    }


    /**
     * 排序测试
     */
    @org.junit.Test
    public void testPagingAndSortingRepositorySort(){
        //Order定义排序规则
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        //Sort对象封装了排序规则
        Sort sort = new Sort(order);

        //遍历排序结果
        List<Users> list =(List<Users>) usersRepositoryPagingAndSorting.findAll(sort);
        for(Users users:list){
            System.out.println(users);
        }

    }

    /**
     * 分页测试
     */
    @org.junit.Test
    public void testPagingAndSortingRepositoryPaging(){
        //Pageable:封装了分页的参数，当前页，每页显示的条数，注意:当前页是从0开始
        //PageRequest(page,size):page,当前页。size:每页显示的条数
        Pageable pageable = new PageRequest(1,2);
        Page<Users> page = this.usersRepositoryPagingAndSorting.findAll(pageable);
        System.out.println("总条数："+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());
        List<Users> list = page.getContent();
        for(Users users:list){
            System.out.println(users);
        }
    }

    /**
     * 分页+排序
     */
    @org.junit.Test
    public void testPagingAndSortingRepository(){
        //排序
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"id"));
        //分页
        Pageable pageable = new PageRequest(1,3,sort);
        Page<Users> page = this.usersRepositoryPagingAndSorting.findAll(pageable);
        System.out.println("总条数"+page.getTotalElements());
        System.out.println("总页数"+page.getTotalPages());
        List<Users> list = page.getContent();
        for(Users users:list){
            System.out.println(users);
        }

    }

    /**
     * JpaSpecification单条件测试
     */
    @org.junit.Test
    public void testJpaSpecificationExecutor1(){

        /**
         * specification<Users>用于封装查询条件
         *
         */
        Specification<Users> spec = new Specification<Users>() {

            //Predicate:封装了 单个的查询条件
            /**
             * Root<Users> root:查询对象的属性的封装。
             * CriteriaQuery<?> query：封装了我们要执行的查询中的各个部分
             的信息，select from order by
             * CriteriaBuilder cb:查询条件的构造器。定义不同的查询条件
             */
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate pre = cb.equal(root.get("name"),"绿野蓝杉");
                return pre;
            }
        };
        List<Users> list = this.usersRepositorySpecification.findAll(spec);
        for(Users users:list){
            System.out.println(users);
        }


    }

    /**
     * 多条件测试
     */
    @org.junit.Test
    public void testJpaSpecificationExcutor2(){
        /**
         * Sepcification<Users>:用于封装查询条件
         */
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                //where name='绿野蓝杉' and age=22
                List<Predicate> list = new ArrayList<>();
                list.add(cb.equal(root.get("name"),"绿野蓝杉"));
                list.add(cb.equal(root.get("age"),22));
                Predicate[] pre = new Predicate[list.size()];
                //将list集合转换成array数组
                return cb.and(list.toArray(pre));
            }
        };

        List<Users> list = this.usersRepositorySpecification.findAll(spec);
        for(Users users:list){
            System.out.println(users);
        }
    }

    /**
     * 多条件查询测试2
     */
    @org.junit.Test
    public void testJpaSpecificationExcutor3(){
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                return  cb.and(cb.equal(root.get("name"),"绿野蓝杉"),cb.equal(root.get("age"),22));
            }
        };
    }



}
