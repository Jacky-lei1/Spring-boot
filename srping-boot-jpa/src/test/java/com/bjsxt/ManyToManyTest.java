package com.bjsxt;

import com.bjsxt.dao.RolesRepository;
import com.bjsxt.pojo.Menus;
import com.bjsxt.pojo.Roles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;
import java.util.Set;

/**
 * @author lvyelanshan
 * @create 2019-11-21 19:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SrpingBootJpaApplication.class})
public class ManyToManyTest {

    @Autowired
    private RolesRepository rolesRepository;

    @Test
    public void testSave(){
        //创建角色
        Roles r = new Roles();
        r.setRolename("项目经理");

        //创建菜单对象
        Menus menus = new Menus();
        menus.setMenusname("xxxx管理系统");
        menus.setFatherid(0);

        Menus menus1 = new Menus();
        menus1.setMenusname("项目管理");
        menus1.setFatherid(1);

        //关联
        //角色关联菜单
        r.getMenus().add(menus);
        r.getMenus().add(menus1);

        //菜单关联角色
        menus.getRoles().add(r);
        menus1.getRoles().add(r);

        //保存
        this.rolesRepository.save(r);
    }

    /**
     * 查询操作
     */
    @Test
    public void testFind(){
        Optional<Roles> roles = this.rolesRepository.findById(3);
        Roles roles1 = roles.get();
        System.out.println("角色信息："+roles1);
        Set<Menus> menus = roles1.getMenus();
        for (Menus menus1:menus){
            System.out.println("菜单信息："+menus1);
        }
    }

}
