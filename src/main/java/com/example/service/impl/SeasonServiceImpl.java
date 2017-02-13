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
                if(null != permission){
                    predicates.add(criteriaBuilder.equal(root.get("permission"), permission));
                }else{
                    if(null != userid){
                        predicates.add(criteriaBuilder.equal(root.get("user_id"), userid));
                    }
                }
                if(null != cityid){
                    predicates.add(criteriaBuilder.equal(root.get("cityid"), cityid));
                }
                if(null != companyName){
                    predicates.add(criteriaBuilder.like(root.get("company_name"), "%"+companyName+"%"));
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
        if(null==season.getId()){
            Season resultSeason = seasonRepository.findSeasonByYearAndSeason(season.getYear(),season.getSeason());
            if(resultSeason!=null){
                resultMap.put("exist",true);
                resultMap.put("inserted",false);
            }else{
                Season newSeason = seasonRepository.save(season);
                if(newSeason.getId()!=null){
                    resultMap.put("exist",false);
                    resultMap.put("inserted",true);
                }
            }
        }else{
            seasonRepository.save(season);
            resultMap.put("updated",true);
        }
        return resultMap;
    }
}