package com.example.service.impl;

import com.example.service.BookService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2017/1/11.
 */
@Service
public class BookServiceImpl implements BookService{
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addBook(String name, String isbn) {
        jdbcTemplate.update("insert into BOOK(NAME, ISBN) values(?, ?)", name, isbn);
    }

    @Override
    public void deleteBook(String isbn) {
        jdbcTemplate.update("delete from BOOK where ISBN = ?", isbn);
    }

    @Override
    public Integer getBookCount() {
        return jdbcTemplate.queryForObject("select count(1) from BOOK", Integer.class);
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("delete from BOOK");
    }
}
