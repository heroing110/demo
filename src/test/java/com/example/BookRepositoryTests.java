package com.example;

import com.example.bean.Book;
import com.example.bean.BookChild;
import com.example.dao.BookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2017/1/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTests {
    @Autowired
    private BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {
//        bookRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {
        bookRepository.save(new Book("book1",1,new String[]{"1","2"},new BookChild("child1")));
        bookRepository.save(new Book("book2",2,new String[]{"1","2"},new BookChild("child1")));
//        bookRepository.save(new Book("book2",2));
//        bookRepository.save(new Book("book3",3));
//        bookRepository.save(new Book("book4",4));
//        bookRepository.save(new Book("book5",5));

//        List<Book> list = bookRepository.findAll();
//        for (Book book : list) {
//            System.out.println("name:"+book.getName());
//            System.out.println("interests:"+ Arrays.toString(book.getInterests()));
//            System.out.println("bookChildren.name:"+book.getBookChild().getName());
//        }
        // 测试findAll, 查询所有记录
//        Assert.assertEquals(5, bookRepository.findAll().size());
//        // 测试findByName, 查询姓名为FFF的User
//        Assert.assertEquals(2, bookRepository.findByName("book2").getIsbn().longValue());
//        // 测试删除姓名为AAA的User
//        bookRepository.delete(bookRepository.findByName("book5"));
//        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
//        Assert.assertEquals(4, bookRepository.findAll().size());
    }

    @Test
    public void test2() throws Exception {
        List<Book> bookList = bookRepository.findBooksByNameLike("book");
        for (Book book : bookList) {
            System.out.println("book.name:"+book.getName());
        }
    }
}
