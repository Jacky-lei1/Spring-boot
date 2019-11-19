package com.bjsxt.controller;

import com.bjsxt.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-11-16 19:25
 */
@Controller
public class UserController {

    @RequestMapping("/showUser")
    public String showUsers(Model model){
        List<Users> list = new ArrayList<>();
        list.add(new Users(1,"张三",18));
        list.add(new Users(2,"李四",20));
        list.add(new Users(3,"王五",24));

        model.addAttribute("list",list);
        //视图跳转
        return "userList";
    }




}
