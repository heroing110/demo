package com.example.controller;

import com.example.bean.User;
import com.example.service.UsersService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by heroing110 on 2017-01-10.
 */
@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody User user) {
        Map<String, Object> resutMap = Maps.newHashMap();
        resutMap.put("login", false);
        resutMap.put("user", null);
        try {
            return usersService.findUsersByUsernameAndPassword(user);
        } catch (Exception e) {
            e.printStackTrace();
            return resutMap;
        }
    }


}
