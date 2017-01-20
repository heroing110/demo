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
    private String name;

    public BookChild() {
    }

    public BookChild(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
