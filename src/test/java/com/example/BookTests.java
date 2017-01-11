package com.example;

import com.example.service.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lenovo on 2017/1/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTests {
    @Autowired
    private BookService bookService;

    @Before
    public void setUp() throws Exception{
        // 准备，清空user表
        bookService.deleteAll();
    }

    @Test
    public void contextLoads() throws Exception {
        // 插入5本书
        bookService.addBook("a", "1");
        bookService.addBook("b", "2");
        bookService.addBook("c", "3");
        bookService.addBook("d", "4");
        bookService.addBook("e", "5");
        // 查数据库，应该有5本书
        Assert.assertEquals(5, bookService.getBookCount().intValue());
        // 删除两本书
        bookService.deleteBook("1");
        bookService.deleteBook("2");
        // 查数据库，应该有3本书
        Assert.assertEquals(3, bookService.getBookCount().intValue());
    }
}
