package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by lenovo on 2017/2/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExcel {
    @Test
    public void test1() throws Exception {
        Resource resource = new ClassPathResource("db/*.sql");
        System.out.println(resource.getFilename());
    }
}
