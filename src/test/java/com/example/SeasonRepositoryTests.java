package com.example;

import com.example.bean.Season;
import com.example.dao.SeasonRepository;
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
public class SeasonRepositoryTests {
    @Autowired
    private SeasonRepository seasonRepository;

    @Before
    public void setUp() throws Exception {
//        bookRepository.deleteAll();
    }


    @Test
    public void test() throws Exception {
        Season season = seasonRepository.findSeasonById(new Long(7));
        System.out.println("season.id:" + season.getId());
    }
}