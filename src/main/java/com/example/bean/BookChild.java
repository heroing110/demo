package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lenovo on 2017/1/18.
 */
@Entity
public class BookChild {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Integer age;

    public BookChild() {
    }

    public BookChild(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
