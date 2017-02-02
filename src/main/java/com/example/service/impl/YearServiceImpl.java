package com.example.service.impl;

import com.example.bean.Year;
import com.example.dao.YearRepository;
import com.example.service.YearService;
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

/**
 * Created by heying on 2017/2/1 0001.
 */
@Service
@Transactional
public class YearServiceImpl implements YearService {
    @Autowired
    private YearRepository yearRepository;

    public List<Year> findByCondition(String cityid,String userid){
        List<Year> resultList = null;
        Specification querySpecifi = new Specification<Year>() {
            @Override
            public Predicate toPredicate(Root<Year> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

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
        resultList =  yearRepository.findAll(querySpecifi);
        return resultList;
    }

    @Override
    public Year findYearById(Long id) {
        return yearRepository.findYearById(id);
    }

    @Override
    public Year saveYear(Year year) {
        return yearRepository.save(year);
    }
}