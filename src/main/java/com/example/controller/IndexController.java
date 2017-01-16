package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2017/1/16.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(value = "/*")
    public String helloWorld(ModelMap modelMap){
        //向模板中添加属性
        modelMap.put("hello","欢迎访问本网站");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
}
