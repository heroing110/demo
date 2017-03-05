package com.example.service.impl;

import com.example.bean.User;
import com.example.dao.SeasonRepository;
import com.example.dao.UsersRepository;
import com.example.dao.YearRepository;
import com.example.service.UsersService;
import com.example.util.Md5Util;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
    @Autowired
    private YearRepository yearRepository;
    @Autowired
    private SeasonRepository seasonRepository;

    @Override
    public List<User> findBooksByUsernameLike(String name) {
        return usersRepository.findUsersByUsernameLike(name);
    }

    @Override
    public Map<String, Object> findUsersByUsernameAndPassword(User paramUser) throws Exception {
        User user = usersRepository.findUsersByUsernameAndPassword(paramUser.getUsername(), Md5Util.str2Md5(paramUser.getPassword()));
        Map<String, Object> map = Maps.newHashMap();
        map.put("login", user != null);
        map.put("user", user);
        return map;
    }

    public List<User> findByCondition(String q_usernamecn, String q_permission, String cityId, String permission) {
        List<User> resultList = null;
        Specification querySpecifi = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (!StringUtils.isEmpty(permission) && "1" == permission) {
                    predicates.add(criteriaBuilder.equal(root.get("cityid"), cityId));
                }

                if (!StringUtils.isEmpty(q_permission)) {
                    predicates.add(criteriaBuilder.equal(root.get("permission"), q_permission));
                }

                if (!StringUtils.isEmpty(q_usernamecn)) {
                    predicates.add(
                            criteriaBuilder.or(
                                    criteriaBuilder.like(root.get("username"), "%" + q_usernamecn + "%"),
                                    criteriaBuilder.like(root.get("usernamecn"), "%" + q_usernamecn + "%")
                            )
                    );
                }


                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList = usersRepository.findAll(querySpecifi);
        return resultList;
    }

    @Override
    public Map<String, Object> deleteUser(Long id) {
        Map<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("removed", false);
        resultMap.put("message", "该用户已存在季度或年度报表数据，无法删除");

        if (yearRepository.findYearsByUserId(id).size() == 0 && seasonRepository.findSeasonsByUserId(id).size() == 0) {
            usersRepository.delete(id);
            resultMap.put("removed", true);
            resultMap.put("message", "删除用户信息成功");
        }

        return resultMap;
    }

    @Override
    public Object saveUser(User user) {
        Map<String, Object> resultMap = Maps.newHashMap();
        if (null == user.getId() || 0 == user.getId()) {
            User resultUser = usersRepository.findUserByUsername(user.getUsername());
            if (resultUser != null) {
                resultMap.put("message", "已存在相同登录名用户");
                resultMap.put("inserted", false);
            } else {
                User newUser = usersRepository.save(user);
                if (newUser.getId() != null) {
                    resultMap.put("message", "添加用户成功");
                    resultMap.put("inserted", true);
                }
            }
        } else {
            usersRepository.save(user);
            resultMap.put("updated", true);
            resultMap.put("message", "修改用户成功");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> changePwd(String userId, Map<String, Object> update) throws Exception {
        Map<String, Object> resultMap = Maps.newHashMap();
        User user = usersRepository.getOne(Long.parseLong(userId));
        if (update.containsKey("oldPwd")) {
            String oldPwd = update.get("oldPwd") + "";
            if (!user.getPassword().equals(Md5Util.str2Md5(oldPwd))) {
                resultMap.put("updated", false);
                resultMap.put("message", "旧密码输入错误");
                return resultMap;
            }
        }

        String newPwd = update.get("newPwd") + "";
        user.setPassword(Md5Util.str2Md5(newPwd));
        usersRepository.save(user);
        resultMap.put("updated", true);
        resultMap.put("message", "密码修改成功");
        return resultMap;
    }
}
