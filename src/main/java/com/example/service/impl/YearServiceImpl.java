package com.example.service.impl;

import com.example.bean.Year;
import com.example.dao.YearRepository;
import com.example.service.YearService;
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
public class YearServiceImpl implements YearService {
    @Autowired
    private YearRepository yearRepository;

    public List<Year> findByCondition(String cityid, String userid, String permission,String companyName){
        List<Year> resultList = null;
        Specification querySpecifi = new Specification<Year>() {
            @Override
            public Predicate toPredicate(Root<Year> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

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
        resultList =  yearRepository.findAll(querySpecifi);
        return resultList;
    }

    @Override
    public Year findYearById(Long id) {
        return yearRepository.findYearById(id);
    }

    @Override
    public Object saveYear(Year year) {
        Map<String,Object> resultMap = Maps.newHashMap();
        if(null==year.getId()){
            Year resultYear = yearRepository.findYearByYearAndUserId(year.getYear(),year.getUserId());
            if(resultYear!=null){
                resultMap.put("message","已存在本年度数据");
                resultMap.put("inserted",false);
            }else{
                Year newYear = yearRepository.save(year);
                if(newYear.getId()!=null){
                    resultMap.put("message","新增年度报表成功");
                    resultMap.put("inserted",true);
                }
            }
        }else{
            yearRepository.save(year);
            resultMap.put("updated",true);
            resultMap.put("message","修改年度报表成功");
        }
        return resultMap;
    }
}