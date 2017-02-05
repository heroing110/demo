package com.example.service;

import com.example.bean.Year;

import java.util.List;

/**
 * Created by heying on 2017/2/1 0001.
 */
public interface YearService {

    public List<Year> findByCondition(String cityId, String userId, String permission,String companyName);

    public Year findYearById(Long id);

    public Object saveYear(Year year);
}
