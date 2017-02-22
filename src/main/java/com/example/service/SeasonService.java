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
}
