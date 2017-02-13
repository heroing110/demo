package com.example.controller;

import com.example.bean.Year;
import com.example.service.YearService;
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
@RequestMapping(value = "/api/year")
public class YearController {
    @Autowired
    private YearService yearService;

    @RequestMapping(method = RequestMethod.GET)
    public Object queryAll(String cityId,String userId,String permission,String companyName) {
        Map<String, Object> resutMap = Maps.newHashMap();
        resutMap.put("status", 1);
        resutMap.put("message", "YearController:queryAll异常");

        try {
            return yearService.findByCondition(cityId,userId,permission,companyName);
        } catch (Exception e) {
            e.printStackTrace();
            return resutMap;
        }
    }

    // GET path = '/detail'
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Object queryDetail(String yearId){
        return yearService.findYearById(Long.parseLong(yearId));
    }

    // POST path = '/insert'
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object insert(@RequestBody Year year){
        return yearService.saveYear(year);
    }


    // PUT path = '/update', params='yearId'
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Object update(@RequestBody Year year){
        return yearService.saveYear(year);
    }

}
