package com.example.dao;

import com.example.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lenovo on 2017/1/17.
 */
public interface UsersRepository extends JpaRepository<User,Long> {

    /**
     * 根据名称查询Users列表
     * @param username
     * @return List<Users>
     */
    @Query("select b from User b where b.username like %:username%")
    List<User> findUsersByUsernameLike(@Param("username") String username);

    public User findUsersByUsernameAndPassword(String username, String password);
}
