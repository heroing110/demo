package com.example.controller;

import com.example.bean.User;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heroing110 on 2017-01-10.
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/getBookCount.shtml")
    public String getBookCount(ModelMap modelMap){
        int bookcount = bookService.getBookCount();
        modelMap.put("bookcount",bookcount);
        return "book";
    }

    @ResponseBody
    @RequestMapping(value = "/getUser.shtml")
    public User getUser(){
        User user = new User();
        user.setAge("12");
        user.setName("小明");
        return user;
    }

    @RequestMapping(value = "/*")
    public String helloWorld(ModelMap modelMap){
        //向模板中添加属性
        modelMap.put("hello","欢迎访问本网站");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

}
