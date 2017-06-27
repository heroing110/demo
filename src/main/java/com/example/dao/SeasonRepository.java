package com.example.dao;

import com.example.bean.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lenovo on 2017/1/17.
 */
public interface SeasonRepository extends JpaRepository<Season,Long>,JpaSpecificationExecutor {
    public Season findSeasonById(Long id);

    public Season findSeasonByYearAndSeasonAndUserId(String year,String season,Long userId);

    public List<Season> findSeasonsByUserId(Long userId);

    @Modifying
    @Query(value = "delete from season where id =?1",nativeQuery = true)
    void removeSeasonById(Long id);
}
