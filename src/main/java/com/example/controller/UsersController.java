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


    @RequestMapping(value = "queryAll",method = RequestMethod.GET)
    public Object queryAll(String usernamecn, String permission) {
        Map<String, Object> resutMap = Maps.newHashMap();
        resutMap.put("status", 1);
        resutMap.put("message", "UsersController:queryAll异常");

        try {
            return usersService.findByCondition(usernamecn,permission);
        } catch (Exception e) {
            e.printStackTrace();
            return resutMap;
        }
    }

    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public Object delete(String userId) {
        Map<String,Object> resultMap = Maps.newHashMap();
        resultMap.put("removed",false);
        try {
            Long id = Long.parseLong(userId);
            return  usersService.deleteUser(id);
        } catch (Exception e) {
            resultMap.put("message","UsersController:delete异常");
            e.printStackTrace();
        }

        return resultMap;
    }

    @RequestMapping(value = "insert",method = RequestMethod.PUT)
    public Object insert(@RequestBody User user) {
        return usersService.saveUser(user);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Object update(@RequestBody User user) {
        return usersService.saveUser(user);
    }

    @RequestMapping(value = "changePwd",method = RequestMethod.PUT)
    public Object changePwd(String userId,@RequestBody Map<String,Object> update) {
        Map<String,Object> resultMap = Maps.newHashMap();
        try {
            return usersService.changePwd(userId,update);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("updated",false);
            resultMap.put("message","UsersController:changePwd异常");
            return resultMap;
        }
    }

    @RequestMapping(value = "allCity",method = RequestMethod.GET)
    public Object allCity() {
        Map<String,Object> resultMap = Maps.newHashMap();
        resultMap.put("1","辽宁");
        resultMap.put("2","沈阳");
        resultMap.put("3","大连");
        resultMap.put("4","鞍山");
        resultMap.put("5","抚顺");
        resultMap.put("6","本兮");
        resultMap.put("7","丹东");
        resultMap.put("8","锦州");
        resultMap.put("9","营口");
        resultMap.put("10","阜新");
        resultMap.put("11","辽阳");
        resultMap.put("12","盘锦");
        resultMap.put("13","铁岭");
        resultMap.put("14","朝阳");
        resultMap.put("15","葫芦岛");
        return resultMap;
    }
}
