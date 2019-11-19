package com.bjsxt.controller;

import com.bjsxt.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringBoot 整合jsp
 * @author lvyelanshan
 * @create 2019-11-16 16:57
 */
@Controller
public class UserController {
    /**
     * 处理请求，产生数据
     */
    @RequestMapping("/showUser")
    public String showUser(Model model){
        List<Users> list = new ArrayList<>();
        list.add(new Users(1,"张三",20));
        list.add(new Users(2,"李四",22));
        list.add(new Users(3,"王五",24));

        //需要以Model对象
        model.addAttribute("list",list);
        //跳转视图
        return "userlist";

    }

}
