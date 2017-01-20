package com.example.service;

import com.example.bean.Book;

import java.util.List;

/**
 * Created by lenovo on 2017/1/11.
 */
public interface BookService {
    /**
     * 添加一本书
     * @param name
     * @param isbn
     */
    void addBook(String name, String isbn);

    /**
     * 根据isbn删除
     * @param isbn
     */
    void deleteBook(String isbn);

    /**
     * 获取数据库中书本总数
     * @return
     */
    Integer getBookCount();

    /**
     * 删除所有数据
     */
    void deleteAll();

    List<Book> findBooksByNameLike(String name);
}
