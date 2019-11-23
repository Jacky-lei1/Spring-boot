package com.bjsxt.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties:告诉springboot将本类中的所有属性和配置文件中相关的配置进行绑定
 * prefix = "person"：配置文件中哪个对下面的属性进行一一映射
 * 只有这个组件是容器中的组件，才能使用容器提供的功能
 * @author lvyelanshan
 * @create 2019-11-23 16:25
 */
@Component //表示将这个类视为一个容器中的组件，只有加上这个注解后@ConfigurationProperties才能够被使用
//@ConfigurationProperties(prefix = "person")
public class Person {

    //除了使用@ConfigurationProperties方式配置外，还可以使用spring底层注解@Value来从配置文件中注入值
    /**
     * <bean class"Person">
     *      <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值/#{spEL}"></property>
     * </bean>
     */
    @Value("${person.last-name}")
    private String lastName; //字符串类型
    @Value("#{11*2}") //Spring的EL表达式的方式
    private Integer age; //整型
    @Value("true")
    private Boolean boss; //布尔类型
    private Date birth; //时间类型
    private Map<String,Object> map; //Map集合键值对类型
    private List<Object> lists; // list集合类型
    private Dog dog; //对象类型


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", map=" + map +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
