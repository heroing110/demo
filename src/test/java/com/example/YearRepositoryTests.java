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
        System.out.println("year.id:"+year.getId());
    }

    @Test
    public void test2() throws Exception {
        Year year = new Year();
        year.setCell11("1");
        Year result_year = yearService.saveYear(year);
        System.out.println("year.id:"+result_year.getId());
    }

    @Test
    public void test3() throws Exception {
        Year year = new Year();
        year.setId(new Long(3));
        year.setCell11("2");
        Year result_year = yearService.saveYear(year);
        System.out.println("year.id:"+result_year.getId());
    }
}
