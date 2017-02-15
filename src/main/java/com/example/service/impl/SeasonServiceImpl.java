package com.example.service.impl;

import com.example.bean.Season;
import com.example.dao.SeasonRepository;
import com.example.service.SeasonService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by heying on 2017/2/1 0001.
 */
@Service
@Transactional
public class SeasonServiceImpl implements SeasonService {
    @Autowired
    private SeasonRepository seasonRepository;

    public List<Season> findByCondition(String cityid, String userid, String permission, String companyName){
        List<Season> resultList = null;
        Specification querySpecifi = new Specification<Season>() {
            @Override
            public Predicate toPredicate(Root<Season> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if("2" != permission){
                    predicates.add(criteriaBuilder.equal(root.get("permission"), permission));
                }else{
                    if(null != userid){
                        predicates.add(criteriaBuilder.equal(root.get("userId"), userid));
                    }
                }
                if(null != cityid){
                    predicates.add(criteriaBuilder.equal(root.get("cityId"), cityid));
                }
                if(null != companyName){
                    predicates.add(criteriaBuilder.like(root.get("companyName"), "%"+companyName+"%"));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList =  seasonRepository.findAll(querySpecifi);
        return resultList;
    }

    @Override
    public Season findSeasonById(Long id) {
        return seasonRepository.findSeasonById(id);
    }

    @Override
    public Object saveSeason(Season season) {
        Map<String,Object> resultMap = Maps.newHashMap();
        if(null==season.getId() || 0==season.getId()){
            Season resultSeason = seasonRepository.findSeasonByYearAndSeasonAndUserId(season.getYear(),season.getSeason(),season.getUserId());
            if(resultSeason!=null){
                resultMap.put("message","已存在本季度数据");
                resultMap.put("inserted",false);
            }else{
                Season newSeason = seasonRepository.save(season);
                if(newSeason.getId()!=null){
                    resultMap.put("message","新增季度报表成功");
                    resultMap.put("inserted",true);
                }
            }
        }else{
            seasonRepository.save(season);
            resultMap.put("updated",true);
            resultMap.put("message","修改季度数据成功");
        }
        return resultMap;
    }
}