package com.example.dao;

import com.example.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lenovo on 2017/1/17.
 */
public interface BookRepository extends JpaRepository<Book,Long> {
    /**
     * 根据名称查询Book
     * @param name
     * @return Book
     */
    Book findByName(String name);

    /**
     * 根据名称查询book列表
     * @param name
     * @return List<Book>
     */
    @Query("select b from Book b where b.name like %:name%")
    List<Book> findBooksByNameLike(@Param("name") String name);

}
