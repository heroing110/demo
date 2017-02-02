package com.example;

import com.example.bean.User;
import com.example.dao.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by lenovo on 2017/1/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTests {
    @Autowired
    private UsersRepository usersRepository;

    @Before
    public void setUp() throws Exception {
//        bookRepository.deleteAll();
    }


    @Test
    public void test() throws Exception {
        List<User> usersList = usersRepository.findUsersByUsernameLike("admin");
        for (User users : usersList) {
            System.out.println("users.username:"+users.getUsername());
        }
    }

    @Test
    public void test2() throws Exception {
        User users = usersRepository.findUsersByUsernameAndPassword("admin","123456");
        System.out.println("users:"+users);
    }
}
