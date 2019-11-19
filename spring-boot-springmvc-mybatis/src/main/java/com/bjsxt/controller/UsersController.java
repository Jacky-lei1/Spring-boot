package com.bjsxt.controller;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-11-19 18:56
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    /**
     * 添加用户
     */
    @RequestMapping("/addUser")
    public String addUser(Users users){
        this.usersService.addUser(users);
        return "ok";
    }
    /**
     * 查询所有用户
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Users> list = this.usersService.findAll();
        model.addAttribute("list",list);
        return "showUsers";
    }

    /**
     * 根据id查询用户信息
     */
    @RequestMapping("/findUserById")
    public String findUser(Integer id,Model model){
        Users users = this.usersService.findUserById(id);
        model.addAttribute("user",users);
        return "showUsersForUpdate";
    }

    /**
     * 根据id更新用户信息
     */
    @RequestMapping("/updateUser")
    public String updateUser(Users users){
        this.usersService.updateUser(users);
        return "ok";
    }

    /**
     * 根据id删除用户信息
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id){
        this.usersService.deleteUser(id);
        return "redirect:/users/findAll";
    }
}
