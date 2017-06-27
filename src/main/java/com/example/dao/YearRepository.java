package com.example.dao;

import com.example.bean.User;
import com.example.bean.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lenovo on 2017/1/17.
 */
public interface YearRepository extends JpaRepository<Year,Long>,JpaSpecificationExecutor {
    public Year findYearById(Long id);

    public List<Year> findYearsByUserId(Long user_id);

    public Year findYearByYearAndUserId(String year,Long userId);

    @Modifying
    @Query(value = "delete from year where id =?1",nativeQuery = true)
    void removeYearById(Long id);
}
