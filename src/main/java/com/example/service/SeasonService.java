package com.example.service;

import com.example.bean.Season;

import java.util.List;

/**
 * Created by heying on 2017/2/1 0001.
 */
public interface SeasonService {

    public List<Season> findByCondition(String cityId, String userId, String permission, String companyName);

    public Season findSeasonById(Long id);

    public Object saveSeason(Season season);

    public List<List<String>> getSeasonLists(Season season);

    public List<Season> findSeasonsByUserId(Long id);

    public Season findSeasonByYearAndSeasonAndUserId(String year,String season,Long userId);

    public Season target_season(Season season, Season seasonBefore);

    public List<Season> findByParams(String industry, String year, String season, String cityId);
}
