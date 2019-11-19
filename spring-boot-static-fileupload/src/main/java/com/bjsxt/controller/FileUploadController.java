package com.bjsxt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lvyelanshan
 * @create 2019-11-16 16:04
 */
@RestController //@Controller + @Responsebody的结合体，表示该类下的方法的返回值会自动做json格式的转换
public class FileUploadController {

    /**
     * 处理文件上传
     */
    @RequestMapping("/fileUploadController")
    public Map<String,Object> fileUpLoad(MultipartFile filename) throws IOException {
        //打印了一下上传文件的名称
        System.out.println(filename.getOriginalFilename());
        //保存文件，将文件保存到指定目录下
        filename.transferTo(new File("e:/"+filename.getOriginalFilename()));
        Map<String,Object> map = new HashMap<>();
        map.put("msg","ok");
        return map;

    }


}
