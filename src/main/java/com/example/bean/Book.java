package com.example.bean;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;

/**
 * Created by lenovo on 2017/1/17.
 */
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer isbn;
    @Column(nullable = true)
    private String[] interests;
    @OneToOne(cascade = CascadeType.ALL)
    private BookChild bookChild;

    public Book() {
    }

    public Book(String name, Integer isbn,String[] interests,BookChild bookChild) {
        this.name = name;
        this.isbn = isbn;
        this.interests = interests;
        this.bookChild = bookChild;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
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

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public BookChild getBookChild() {
        return bookChild;
    }

    public void setBookChild(BookChild bookChild) {
        this.bookChild = bookChild;
    }
}
