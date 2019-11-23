package com.bjsxt.controller;

import com.bjsxt.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author lvyelanshan
 * @create 2019-11-20 10:20
 */
@Controller
public class PageController {

    /**
     * 页面跳转,在页面跳转的方法中注入一个Users对象
     * 注意：由于springMVC会将对象放入ModelAndView中传递，key的名称会使用该对象的驼峰式命名规则来作为key
     * 参数的变量名需要与对象的名称相同，首字母小写
     * @ModelAttribute("aa"):将默认首字母小写的key修改为aa，那么我们在页面中获取该对象的key也需要修改为aa
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page,@ModelAttribute("aa") Users users){
        /*此时users对象为空的*/
        return page;
    }

    /**
     * 完成用户添加，
     * @Valid :开启对User对象的数据校验
     * BindingResult:封装了校验的结果,一旦校验出错了，那么出错的信息都会封装到这个对象中
     * BindingResult会根据当前User对象的每一个属性创建一个变量，这个名称跟属性名称相同，
     * Users对象会被默认放到ModelAndView对象中传递，传递到页面中，那个addatribute中的key默认采用这个对象
     * 的驼峰式命名规则
     * 在出错后的校验结果信息中有默认的信息提示
     */
    @RequestMapping("/save")
    public String addUser(@ModelAttribute("aa") @Valid  Users users, BindingResult result){
        if(result.hasErrors()){ //当这个方法返回true的时候，表示校验不成功
            return "index";
        }
        /*此时users对象为前端传过来的值*/
        System.out.println(users);
        return "ok";
    }
}
