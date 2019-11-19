package com.bjsxt.pojo;

/**
 * @author lvyelanshan
 * @create 2019-11-19 18:44
 */
public class Users {
    private Integer userid;
    private String username;
    private Integer userage;

    public Users(Integer userid, String username, Integer userage) {
        this.userid = userid;
        this.username = username;
        this.userage = userage;
    }

    public Users() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }
}
