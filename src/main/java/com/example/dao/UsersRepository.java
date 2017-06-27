package com.example.dao;

import com.example.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lenovo on 2017/1/17.
 */
public interface UsersRepository extends JpaRepository<User,Long> ,JpaSpecificationExecutor {

    /**
     * 根据名称查询Users列表
     * @param username
     * @return List<Users>
     */
    @Query("select b from User b where b.username like %:username%")
    List<User> findUsersByUsernameLike(@Param("username") String username);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public User findUsersByUsernameAndPassword(String username, String password);

    /**
     * 根据登录用户名查询用户
     * @param username
     * @return
     */
    public User findUserByUsername(String username);

    /**
     * 根据id不同，用户名相同查询
     * @param id
     * @param username
     * @return
     */
    List<User> findUserByIdNotAndUsername(Long id,String username);
}
