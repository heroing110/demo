package com.example.controller;

import com.example.bean.Season;
import com.example.service.SeasonService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by heroing110 on 2017-01-10.
 */
@RestController
@RequestMapping(value = "/api/season")
public class SeasonController {
    @Autowired
    private SeasonService seasonService;

    @RequestMapping(method = RequestMethod.GET)
    public Object queryAll(String cityId,String userId,String permission,String companyName) {
        Map<String, Object> resutMap = Maps.newHashMap();
        resutMap.put("status", 1);
        resutMap.put("message", "YearController:queryAll异常");

        try {
            return seasonService.findByCondition(cityId,userId,permission,companyName);
        } catch (Exception e) {
            e.printStackTrace();
            return resutMap;
        }
    }

    // GET path = '/detail'
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Object queryDetail(String seasonId){
        return seasonService.findSeasonById(Long.parseLong(seasonId));
    }

    // POST path = '/insert'
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object insert(@RequestBody Season season){
        return seasonService.saveSeason(season);
    }


    // PUT path = '/update'
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Object update(@RequestBody Season season){
        return seasonService.saveSeason(season);
    }

    // PUT path = '/update'
    @RequestMapping(value = "/chart",method = RequestMethod.GET)
    public Object chart(String userId) {
        return seasonService.findSeasonsByUserId(Long.parseLong(userId));
    }

}
