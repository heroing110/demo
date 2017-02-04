package com.example.service;

import com.example.bean.Season;
import com.example.bean.Year;

import java.util.List;

/**
 * Created by heying on 2017/2/1 0001.
 */
public interface SeasonService {

    public List<Season> findByCondition(String cityid, String userid);

    public Season findSeasonById(Long id);

    public Season saveSeason(Season season);
}
