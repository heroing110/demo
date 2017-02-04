package com.example.service.impl;

import com.example.bean.Season;
import com.example.bean.Year;
import com.example.dao.SeasonRepository;
import com.example.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/2/3.
 */
public class SeasonServiceImpl implements SeasonService{
    @Autowired
    public SeasonRepository seasonRepository;

    @Override
    public List<Season> findByCondition(String cityid, String userid) {
        List<Season> resultList = null;
        Specification querySpecifi = new Specification<Season>() {
            @Override
            public Predicate toPredicate(Root<Season> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if(null != cityid){
                    predicates.add(criteriaBuilder.equal(root.get("cityid"), cityid));
                }
                if(null != userid){
                    predicates.add(criteriaBuilder.equal(root.get("user_id"), userid));
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
    public Season saveSeason(Season season) {
        return seasonRepository.save(season);
    }
}
