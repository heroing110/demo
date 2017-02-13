package com.example.service;

import com.example.bean.User;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/1/11.
 */
public interface UsersService {
    List<User> findBooksByUsernameLike(String name);

    public Map<String,Object> findUsersByUsernameAndPassword(User users) throws Exception;

    public List<User> findByCondition(String usernamecn, String permission);

    public Map<String,Object> deleteUser(Long id);

    public Object saveUser(User user);
}
