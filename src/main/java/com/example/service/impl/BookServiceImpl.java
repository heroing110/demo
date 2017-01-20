package com.example.service.impl;

import com.example.bean.Book;
import com.example.dao.BookRepository;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2017/1/11.
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BookRepository bookRepository;

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

    @Override
    public List<Book> findBooksByNameLike(String name) {
        return bookRepository.findBooksByNameLike(name);
    }
}
