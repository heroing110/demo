package com.example.util;

import com.example.bean.User;

import java.beans.IntrospectionException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/22.
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        User user =new User();
        user.setId(new Long(1));
        user.setUsernamecn("水电费");

        Map<String,Object> map = MapUtil.convertBean(user);
        System.out.println(map);
    }
}
