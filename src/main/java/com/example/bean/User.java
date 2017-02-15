package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lenovo on 2017/1/16.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String cityid;
    @Column
    private String permission;
    @Column
    private String usernamecn;
    @Column
    private String companyName;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUsernamecn() {
        return usernamecn;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setUsernamecn(String usernamecn) {
        this.usernamecn = usernamecn;
    }
}
