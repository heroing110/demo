package com.example.controller;

import com.example.bean.Book;
import com.example.bean.User;
import com.example.service.BookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by heroing110 on 2017-01-10.
 */
@Controller
@RequestMapping(value = "/demo")
public class DemoController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/getBookCount.shtml",method = RequestMethod.GET)
    public String getBookCount(ModelMap modelMap){
        int bookcount = bookService.getBookCount();
        modelMap.put("bookcount",bookcount);
        return "book";
    }

    @ApiOperation(value="获取用户对象测试", notes="")
    @ResponseBody
    @RequestMapping(value = "/getUser.shtml",method = RequestMethod.GET)
    public User getUser(){
        User user = new User();
        user.setAge("12");
        user.setName("小明");
        return user;
    }

    @ApiOperation(value="获取图书列表", notes="获取图书列表")
    @ApiImplicitParam(name = "name", value = "图书名称", required = false, dataType = "String")
    @ResponseBody
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public List<Book> getBookList(@PathVariable String name){
        return bookService.findBooksByNameLike(name);
    }

}
