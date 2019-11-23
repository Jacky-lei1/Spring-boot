package com.bjsxt.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lvyelanshan
 * @create 2019-11-21 15:56
 */
@Entity
@Table(name = "t_roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private Integer roleid;

    @Column(name = "rolename")
    private String rolename;

    //一个角色对应多个用户
    @OneToMany(mappedBy = "roles" ,fetch = FetchType.EAGER) //未来往set集合中的Users是需要和roles相同的
    private Set<Users> users = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    //@JoinTable:映射中间表
    //joinColumns:当前表中的主键所关联的中间表中的外键字段,inverseJoinColumns:中间表中另一侧的外键字段名
    @JoinTable(name = "t_roles_menus",joinColumns = @JoinColumn(name="role_id"),inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<Menus> menus = new HashSet<>();

    public Set<Menus> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menus> menus) {
        this.menus = menus;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", users=" + users +
                '}';
    }
}
