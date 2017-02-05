package com.example.dao;

import com.example.bean.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by lenovo on 2017/1/17.
 */
public interface SeasonRepository extends JpaRepository<Season,Long>,JpaSpecificationExecutor {
    public Season findSeasonById(Long id);
}
