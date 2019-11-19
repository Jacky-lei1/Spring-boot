package com.bjsxt.controller;

import com.bjsxt.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Thymeleaf入门案例
 * @author lvyelanshan
 * @create 2019-11-18 19:26
 */
@Controller
public class demoController {
    @RequestMapping("/show")
    public String showIndex(Model model, HttpServletRequest request, HttpServletResponse response){
        model.addAttribute("msg","第一个Thymeleaf");
        model.addAttribute("key",new Date());
        model.addAttribute("sex","男");
        model.addAttribute("id",6);

        /*循环遍历list集合*/
        List<Users> list = new ArrayList<>();
        list.add(new Users(1,"张三",20));
        list.add(new Users(2,"李四",22));
        list.add(new Users(3,"王五",24));
        model.addAttribute("list",list);

        /*循环遍历map集合*/
        Map<String,Users> map = new HashMap<>();
        map.put("u1",new Users(1,"赵六",20));
        map.put("u2",new Users(2,"小七",22));
        map.put("u3",new Users(3,"小八",24));
        model.addAttribute("map",map);

        /*添加作用域数据*/
        //request作用域数据
        request.setAttribute("req","HttpServletRequest");
        //session作用域数据
        request.getSession().setAttribute("sess","HttpSession");
        //ServletContext作用域数据
        request.getSession().getServletContext().setAttribute("app","Application");

        return "index";
    }


    @RequestMapping("/{page}")
    public String showIndex(@PathVariable String page,Integer id,String name){
        System.out.println(id+"--"+name);
        return page;
    }
}
