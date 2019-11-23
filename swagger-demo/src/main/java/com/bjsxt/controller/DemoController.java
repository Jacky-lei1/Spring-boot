package com.bjsxt.controller;


import com.bjsxt.pojo.People;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author lvyelanshan
 * @create 2019-11-23 9:43
 */
//@ApiIgnore//表示忽略该类
@RestController
@RequestMapping("/people")
@Api(tags = {"测试用Controller"},description = "描述信息") //这个注解用于修改UI界面中Controller名字和描述信息
public class DemoController {

    @RequestMapping("/test")
    @ApiOperation(value = "获取的内容",notes = "通过编号查询详细信息") //描述方法具体的功能和详细信息
    //@NotIncludeSwagger //自定义注解，用于过滤api生成
    //@ApiParam：给参数重新取名，也可以用@RequestParam注解来给参数重新取名，value属性用于生成参数的描述信息,required为ture表示这个参数是必须的
    public People getPeople(int id,@ApiParam(name="name123",value = "姓名",required = true) String name){
        People people = new People(10,"张三","北京");
        people.setId(id);
        people.setName(name);
//        people.setAddress("深圳");
        return people;
    }

    @ApiIgnore//表示忽略这个方法，不生成api
    @PostMapping("/test2")
    //@ApiIgnore:表示生产该方法的Api时忽略这个属性
    public People getPeople(Integer id, @ApiIgnore String name){
        return null;
    }
}
