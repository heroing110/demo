package com.example.dao;

import com.example.bean.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by lenovo on 2017/1/17.
 */
public interface YearRepository extends JpaRepository<Year,Long>,JpaSpecificationExecutor {
    public Year findYearById(Long id);

    public Year findYearByUserId(Long user_id);

    public Year findYearByYear(String year);
}
