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
@RestController
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

    @ApiOperation(value="获取图书列表", notes="获取图书列表")
    @ApiImplicitParam(name = "name", value = "图书名称", required = false, dataType = "String",paramType = "query")
    @ResponseBody
    @RequestMapping(value = "/getBookList")
    public List<Book> getBookList(String name){
        System.out.println("----------name:"+name);
        return bookService.findBooksByNameLike(name);
    }

    @ApiOperation(value="updateinfo", notes="updateinfo")
    @ApiImplicitParam(name = "list", value = "UserList", required = true)
    @RequestMapping(value="/updateinfo",method = RequestMethod.POST)
    public Object updateinfo(@RequestBody List<User> list) {
        System.out.println("updateinfo-------------------list:"+list);
        return list;
    }

}
