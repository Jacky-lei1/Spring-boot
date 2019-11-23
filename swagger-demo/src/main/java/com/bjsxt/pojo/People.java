package com.bjsxt.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lvyelanshan
 * @create 2019-11-23 9:42
 */
//标注在实体类上，表示Model中的属性
@ApiModel(value = "实体类：人",description = "封装了People的全部属性")
public class People {
    //类似@ApiParam，example：表示的是该属性的示例值，required = true是否是必须的
    //当这整个对象作为参数传入时，标识了hidden = true的这个属性将被隐藏
    @ApiModelProperty(value = "编号(主键)",required = true,example = "123",hidden = true)
    private Integer id;
    private String name;
    private String address;

    public People(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public People() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
