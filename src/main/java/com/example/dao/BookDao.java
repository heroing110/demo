package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/1/11.
 */
@Repository
public class BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void test(){
    }
}
