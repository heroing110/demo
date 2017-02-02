package com.example.service.impl;

import com.example.bean.User;
import com.example.dao.UsersRepository;
import com.example.service.UsersService;
import com.example.util.Md5Util;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/1/11.
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public List<User> findBooksByUsernameLike(String name) {
        return usersRepository.findUsersByUsernameLike(name);
    }

    @Override
    public Map<String,Object> findUsersByUsernameAndPassword(User paramUser) throws Exception{
        User user = usersRepository.findUsersByUsernameAndPassword(paramUser.getUsername(), Md5Util.str2Md5(paramUser.getPassword()));
        Map<String,Object> map = Maps.newHashMap();
        map.put("login",user!=null);
        map.put("user",user);
        return map;
    }
}
