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

    public List<List<String>> getSeasonLists(Season season) {
        List<List<String>> lo = new ArrayList<List<String>>();

        //第一行
        List<String> vo = new ArrayList<>();
        vo.add(season.getCompanyName()); //单位名称
        vo.add(season.getYear()); //年度
        vo.add(season.getSeason()); //季度
        vo.add(season.getCell161()); //填表人
        vo.add(season.getCell162());//职务
        vo.add(season.getCell163());//联系电话
        vo.add(season.getCell164());//手机
        vo.add(season.getCell165());//填报日期
        vo.add("电子商务交易额");

        int cell12 = Integer.parseInt(season.getCell12());
        int cell13 = Integer.parseInt(season.getCell12());
        int cell14 = Integer.parseInt(season.getCell12());
        int cell15 = Integer.parseInt(season.getCell12());

        vo.add((cell12+cell13+cell14+cell15)+"");
        vo.add((cell12+cell13)+"");
        vo.add(cell12+"");
        vo.add(cell13+"");
        vo.add(cell14+"");
        vo.add(cell15+"");

        vo.add(season.getCell111());
        vo.add(season.getCell112());
        vo.add(season.getCell113());
        vo.add(season.getCell114());

        vo.add(season.getO2oRadio().equals("1")?"是":"否");
        vo.add(season.getMobileRadio().equals("1")?"是":"否");
        vo.add(season.getCell141());
        vo.add(season.getCell142());
        vo.add(season.getCell151());
        vo.add(season.getCell152());
        lo.add(vo);
        //第一行结束

        //第二行
        List<String> vo2 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo2.add("");
        }
        vo2.add("一、按交易平台分");
        for (int i = 0; i < 6; i++) {
            vo2.add("—");
        }
        lo.add(vo2);
        //第二行结束

        //第三行
        List<String> vo3 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo3.add("");
        }
        vo3.add("1.通过自营电子商务平台");
        int cell22 = Integer.parseInt(season.getCell22());
        int cell23 = Integer.parseInt(season.getCell23());
        int cell24 = Integer.parseInt(season.getCell24());
        int cell25 = Integer.parseInt(season.getCell25());

        vo3.add((cell22+cell23+cell24+cell25)+"");
        vo3.add((cell22+cell23)+"");
        vo3.add(cell22+"");
        vo3.add(cell23+"");
        vo3.add(cell24+"");
        vo3.add(cell25+"");

        lo.add(vo3);
        //第三行结束

        //第四行
        List<String> vo4 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo4.add("");
        }
        vo4.add("2.通过第三方电子商务平台");
        int cell32 = Integer.parseInt(season.getCell32());
        int cell33 = Integer.parseInt(season.getCell33());
        int cell34 = Integer.parseInt(season.getCell34());
        int cell35 = Integer.parseInt(season.getCell35());

        vo4.add((cell32+cell33+cell34+cell35)+"");
        vo4.add((cell32+cell33)+"");
        vo4.add(cell32+"");
        vo4.add(cell33+"");
        vo4.add(cell34+"");
        vo4.add(cell35+"");

        lo.add(vo4);
        //第四行结束

        //第五行
        List<String> vo5 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo5.add("");
        }
        vo5.add("二、按交易方式分");
        for (int i = 0; i < 6; i++) {
            vo5.add("—");
        }
        lo.add(vo5);
        //第五行结束

        //第六行
        List<String> vo6 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo6.add("");
        }
        vo6.add("1.B2B");
        int cell42 = Integer.parseInt(season.getCell42());
        int cell43 = Integer.parseInt(season.getCell43());
        int cell44 = Integer.parseInt(season.getCell44());
        int cell45 = Integer.parseInt(season.getCell45());

        vo6.add((cell42+cell43+cell44+cell45)+"");
        vo6.add((cell42+cell43)+"");
        vo6.add(cell42+"");
        vo6.add(cell43+"");
        vo6.add(cell44+"");
        vo6.add(cell45+"");

        lo.add(vo6);
        //第六行结束

        //第七行
        List<String> vo7 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo7.add("");
        }
        vo7.add("2.B2C");
        int cell52 = Integer.parseInt(season.getCell52());
        int cell53 = Integer.parseInt(season.getCell53());
        int cell54 = Integer.parseInt(season.getCell54());
        int cell55 = Integer.parseInt(season.getCell55());

        vo7.add((cell52+cell53+cell54+cell55)+"");
        vo7.add((cell52+cell53)+"");
        vo7.add(cell52+"");
        vo7.add(cell53+"");
        vo7.add(cell54+"");
        vo7.add(cell55+"");

        lo.add(vo7);
        //第七行结束

        //第八行
        List<String> vo8 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo8.add("");
        }
        vo8.add("3.C2C");
        int cell62 = Integer.parseInt(season.getCell62());
        int cell63 = Integer.parseInt(season.getCell63());
        int cell64 = Integer.parseInt(season.getCell64());
        int cell65 = Integer.parseInt(season.getCell65());

        vo8.add((cell62+cell63+cell64+cell65)+"");
        vo8.add((cell62+cell63)+"");
        vo8.add(cell62+"");
        vo8.add(cell63+"");
        vo8.add(cell64+"");
        vo8.add(cell65+"");

        lo.add(vo8);
        //第八行结束

        //第九行
        List<String> vo9 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo9.add("");
        }
        vo9.add("三、按地域分");
        for (int i = 0; i < 6; i++) {
            vo9.add("—");
        }
        lo.add(vo9);
        //第九行结束

        //第十行
        List<String> vo10 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo10.add("");
        }
        vo10.add("1.境内");
        int cell72 = Integer.parseInt(season.getCell72());
        int cell73 = Integer.parseInt(season.getCell73());
        int cell74 = Integer.parseInt(season.getCell74());
        int cell75 = Integer.parseInt(season.getCell75());

        vo10.add((cell72+cell73+cell74+cell75)+"");
        vo10.add((cell72+cell73)+"");
        vo10.add(cell72+"");
        vo10.add(cell73+"");
        vo10.add(cell74+"");
        vo10.add(cell75+"");

        lo.add(vo10);
        //第十行结束

        //第十一行
        List<String> vo11 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo11.add("");
        }
        vo11.add("2.境外（跨境电子商务交易）");
        int cell82 = Integer.parseInt(season.getCell82());
        int cell83 = Integer.parseInt(season.getCell83());
        int cell84 = Integer.parseInt(season.getCell84());
        int cell85 = Integer.parseInt(season.getCell85());

        vo11.add((cell82+cell83+cell84+cell85)+"");
        vo11.add((cell82+cell83)+"");
        vo11.add(cell82+"");
        vo11.add(cell83+"");
        vo11.add(cell84+"");
        vo11.add(cell85+"");

        lo.add(vo11);
        //第十一行结束

        //第十二行
        List<String> vo12 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo12.add("");
        }
        vo12.add("进口");
        int cell92 = Integer.parseInt(season.getCell92());
        int cell93 = Integer.parseInt(season.getCell93());
        int cell94 = Integer.parseInt(season.getCell94());
        int cell95 = Integer.parseInt(season.getCell95());

        vo12.add((cell92+cell93+cell94+cell95)+"");
        vo12.add((cell92+cell93)+"");
        vo12.add(cell92+"");
        vo12.add(cell93+"");
        vo12.add(cell94+"");
        vo12.add(cell95+"");

        lo.add(vo12);
        //第十二行结束

        //第十三行
        List<String> vo13 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            vo13.add("");
        }
        vo13.add("出口");
        int cell102 = Integer.parseInt(season.getCell102());
        int cell103 = Integer.parseInt(season.getCell103());
        int cell104 = Integer.parseInt(season.getCell104());
        int cell105 = Integer.parseInt(season.getCell105());

        vo13.add((cell102+cell103+cell104+cell105)+"");
        vo13.add((cell102+cell103)+"");
        vo13.add(cell102+"");
        vo13.add(cell103+"");
        vo13.add(cell104+"");
        vo13.add(cell105+"");

        lo.add(vo13);
        //第十三行结束
        return lo;
    }
}