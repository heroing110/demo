package com.example;

import com.example.bean.Year;
import com.example.service.YearService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lenovo on 2017/1/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YearRepositoryTests {
    @Autowired
    private YearService yearService;

    @Before
    public void setUp() throws Exception {
//        bookRepository.deleteAll();
    }


    @Test
    public void test() throws Exception {
        Year year = yearService.findYearById(new Long(1));
        System.out.println("year.id:" + year.getId());
    }
}