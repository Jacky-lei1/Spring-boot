package com.bjsxt.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author lvyelanshan
 * @create 2019-11-20 10:18
 */
public class Users implements Serializable {
    /*message：表示自定义错误信息*/
    @NotBlank(message = "用户名不能为空") //非空校验：判断字符串是否为空或者空串(去掉首尾空格)
    @Length(min = 2,max = 6,message = "长度在[2,6]之间") //长度校验：最小不能小于1位，最大不能超过三位
    private String name;

    @NotEmpty(message = "密码不能为空") //非空校验:判断字符串是否为空或者空串
    private String password;

    @Min(value = 15) //判断数值最小值
    @Max(value = 150) //判断数值的最大值
    private Integer age;

    @Email //邮箱校验
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users(String name, String password, Integer age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
