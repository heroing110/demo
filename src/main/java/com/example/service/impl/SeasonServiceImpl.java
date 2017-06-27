package com.example.service.impl;

import com.example.bean.Season;
import com.example.dao.SeasonRepository;
import com.example.service.SeasonService;
import com.example.util.NumberUtils;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
                switch (permission) {
                    case "2":
                        predicates.add(criteriaBuilder.equal(root.get("userId"), userid));
                    case "1":
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
    public List<Season> findByParams(String industry, String year, String season, String cityId){
        List<Season> resultList = null;
        Specification querySpecifi = new Specification<Season>() {
            @Override
            public Predicate toPredicate(Root<Season> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();

                if(!StringUtils.isEmpty(industry)){
                    predicates.add(criteriaBuilder.equal(root.get("industry"), industry));
                }

                if(!StringUtils.isEmpty(year)){
                    predicates.add(criteriaBuilder.equal(root.get("year"), year));
                }

                if(!StringUtils.isEmpty(season)){
                    predicates.add(criteriaBuilder.equal(root.get("season"), season));
                }

                if(!StringUtils.isEmpty(cityId)){
                    predicates.add(criteriaBuilder.equal(root.get("cityId"), cityId));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList =  seasonRepository.findAll(querySpecifi);
        return resultList;
    }

    @Override
    public void removeSeasonById(long l) {
        seasonRepository.removeSeasonById(l);
    }

    @Override
    public Season findSeasonById(Long id) {
        return seasonRepository.findSeasonById(id);
    }

    @Override
    public Object saveSeason(Season season) {
        Map<String,Object> resultMap = Maps.newHashMap();
        if(null==season.getId() || 0==season.getId()){
            Season resultSeason = seasonRepository.findSeasonByYearAndSeasonAndUserId(
                    season.getYear(),
                    season.getSeason(),
                    season.getUserId()
            );

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

    public List<Season> findSeasonsByUserId(Long userId){
        return this.seasonRepository.findSeasonsByUserId(userId);
    }

    @Override
    public Season findSeasonByYearAndSeasonAndUserId(String year, String season, Long userId) {
        return seasonRepository.findSeasonByYearAndSeasonAndUserId(year,season,userId);
    }

    @Override
    public Season target_season(Season season, Season seasonBefore) {
        Season target_season = new Season();
        BeanUtils.copyProperties(season, target_season);
        //第一行
        double cell12 = Double.parseDouble(season.getCell12());
        double cell13 = Double.parseDouble(season.getCell13());
        double cell14 = Double.parseDouble(season.getCell14());
        double cell15 = Double.parseDouble(season.getCell15());
        double cell10 = cell12+cell13+cell14+cell15;
        double cell11 = cell12+cell13;

        double b_cell12 = Double.parseDouble(seasonBefore.getCell12());
        double b_cell13 = Double.parseDouble(seasonBefore.getCell13());
        double b_cell14 = Double.parseDouble(seasonBefore.getCell14());
        double b_cell15 = Double.parseDouble(seasonBefore.getCell15());
        double b_cell10 = b_cell12+b_cell13+b_cell14+b_cell15;
        double b_cell11 = b_cell12+b_cell13;

        target_season.setCell10(NumberUtils.round((cell10-b_cell10)/b_cell10,2)*100+"%");
        target_season.setCell11(NumberUtils.round((cell11-b_cell11)/b_cell11,2)*100+"%");
        target_season.setCell12(NumberUtils.round((cell12-b_cell12)/b_cell12,2)*100+"%");
        target_season.setCell13(NumberUtils.round((cell13-b_cell13)/b_cell13,2)*100+"%");
        target_season.setCell14(NumberUtils.round((cell14-b_cell14)/b_cell14,2)*100+"%");
        target_season.setCell15(NumberUtils.round((cell15-b_cell15)/b_cell15,2)*100+"%");

        //第二行
        double cell22 = Double.parseDouble(season.getCell22());
        double cell23 = Double.parseDouble(season.getCell23());
        double cell24 = Double.parseDouble(season.getCell24());
        double cell25 = Double.parseDouble(season.getCell25());
        double cell20 = cell22+cell23+cell24+cell25;
        double cell21 = cell22+cell23;

        double b_cell22 = Double.parseDouble(seasonBefore.getCell22());
        double b_cell23 = Double.parseDouble(seasonBefore.getCell23());
        double b_cell24 = Double.parseDouble(seasonBefore.getCell24());
        double b_cell25 = Double.parseDouble(seasonBefore.getCell25());
        double b_cell20 = b_cell22+b_cell23+b_cell24+b_cell25;
        double b_cell21 = b_cell22+b_cell23;

        target_season.setCell20(NumberUtils.round((cell20-b_cell20)/b_cell20,2)*100+"%");
        target_season.setCell21(NumberUtils.round((cell21-b_cell21)/b_cell21,2)*100+"%");
        target_season.setCell22(NumberUtils.round((cell22-b_cell22)/b_cell22,2)*100+"%");
        target_season.setCell23(NumberUtils.round((cell23-b_cell23)/b_cell23,2)*100+"%");
        target_season.setCell24(NumberUtils.round((cell24-b_cell24)/b_cell24,2)*100+"%");
        target_season.setCell25(NumberUtils.round((cell25-b_cell25)/b_cell25,2)*100+"%");

        //第三行
        double cell32 = Double.parseDouble(season.getCell32());
        double cell33 = Double.parseDouble(season.getCell33());
        double cell34 = Double.parseDouble(season.getCell34());
        double cell35 = Double.parseDouble(season.getCell35());
        double cell30 = cell32+cell33+cell34+cell35;
        double cell31 = cell32+cell33;

        double b_cell32 = Double.parseDouble(seasonBefore.getCell32());
        double b_cell33 = Double.parseDouble(seasonBefore.getCell33());
        double b_cell34 = Double.parseDouble(seasonBefore.getCell34());
        double b_cell35 = Double.parseDouble(seasonBefore.getCell35());
        double b_cell30 = b_cell32+b_cell33+b_cell34+b_cell35;
        double b_cell31 = b_cell32+b_cell33;

        target_season.setCell30(NumberUtils.round((cell30-b_cell30)/b_cell30,2)*100+"%");
        target_season.setCell31(NumberUtils.round((cell31-b_cell31)/b_cell31,2)*100+"%");
        target_season.setCell32(NumberUtils.round((cell32-b_cell32)/b_cell32,2)*100+"%");
        target_season.setCell33(NumberUtils.round((cell33-b_cell33)/b_cell33,2)*100+"%");
        target_season.setCell34(NumberUtils.round((cell34-b_cell34)/b_cell34,2)*100+"%");
        target_season.setCell35(NumberUtils.round((cell35-b_cell35)/b_cell35,2)*100+"%");

        //第四行
        double cell42 = Double.parseDouble(season.getCell42());
        double cell43 = Double.parseDouble(season.getCell43());
        double cell44 = Double.parseDouble(season.getCell44());
        double cell45 = Double.parseDouble(season.getCell45());
        double cell40 = cell42+cell43+cell44+cell45;
        double cell41 = cell42+cell43;

        double b_cell42 = Double.parseDouble(seasonBefore.getCell42());
        double b_cell43 = Double.parseDouble(seasonBefore.getCell43());
        double b_cell44 = Double.parseDouble(seasonBefore.getCell44());
        double b_cell45 = Double.parseDouble(seasonBefore.getCell45());
        double b_cell40 = b_cell42+b_cell43+b_cell44+b_cell45;
        double b_cell41 = b_cell42+b_cell43;

        target_season.setCell40(NumberUtils.round((cell40-b_cell40)/b_cell40,2)*100+"%");
        target_season.setCell41(NumberUtils.round((cell41-b_cell41)/b_cell41,2)*100+"%");
        target_season.setCell42(NumberUtils.round((cell42-b_cell42)/b_cell42,2)*100+"%");
        target_season.setCell43(NumberUtils.round((cell43-b_cell43)/b_cell43,2)*100+"%");
        target_season.setCell44(NumberUtils.round((cell44-b_cell44)/b_cell44,2)*100+"%");
        target_season.setCell45(NumberUtils.round((cell45-b_cell45)/b_cell45,2)*100+"%");

        //第五行
        double cell52 = Double.parseDouble(season.getCell52());
        double cell53 = Double.parseDouble(season.getCell53());
        double cell54 = Double.parseDouble(season.getCell54());
        double cell55 = Double.parseDouble(season.getCell55());
        double cell50 = cell52+cell53+cell54+cell55;
        double cell51 = cell52+cell53;

        double b_cell52 = Double.parseDouble(seasonBefore.getCell52());
        double b_cell53 = Double.parseDouble(seasonBefore.getCell53());
        double b_cell54 = Double.parseDouble(seasonBefore.getCell54());
        double b_cell55 = Double.parseDouble(seasonBefore.getCell55());
        double b_cell50 = b_cell52+b_cell53+b_cell54+b_cell55;
        double b_cell51 = b_cell52+b_cell53;

        target_season.setCell50(NumberUtils.round((cell50-b_cell50)/b_cell50,2)*100+"%");
        target_season.setCell51(NumberUtils.round((cell51-b_cell51)/b_cell51,2)*100+"%");
        target_season.setCell52(NumberUtils.round((cell52-b_cell52)/b_cell52,2)*100+"%");
        target_season.setCell53(NumberUtils.round((cell53-b_cell53)/b_cell53,2)*100+"%");
        target_season.setCell54(NumberUtils.round((cell54-b_cell54)/b_cell54,2)*100+"%");
        target_season.setCell55(NumberUtils.round((cell55-b_cell55)/b_cell55,2)*100+"%");

        //第六行
        double cell62 = Double.parseDouble(season.getCell62());
        double cell63 = Double.parseDouble(season.getCell63());
        double cell64 = Double.parseDouble(season.getCell64());
        double cell65 = Double.parseDouble(season.getCell65());
        double cell60 = cell62+cell63+cell64+cell65;
        double cell61 = cell62+cell63;

        double b_cell62 = Double.parseDouble(seasonBefore.getCell62());
        double b_cell63 = Double.parseDouble(seasonBefore.getCell63());
        double b_cell64 = Double.parseDouble(seasonBefore.getCell64());
        double b_cell65 = Double.parseDouble(seasonBefore.getCell65());
        double b_cell60 = b_cell62+b_cell63+b_cell64+b_cell65;
        double b_cell61 = b_cell62+b_cell63;

        target_season.setCell60(NumberUtils.round((cell60-b_cell60)/b_cell60,2)*100+"%");
        target_season.setCell61(NumberUtils.round((cell61-b_cell61)/b_cell61,2)*100+"%");
        target_season.setCell62(NumberUtils.round((cell62-b_cell62)/b_cell62,2)*100+"%");
        target_season.setCell63(NumberUtils.round((cell63-b_cell63)/b_cell63,2)*100+"%");
        target_season.setCell64(NumberUtils.round((cell64-b_cell64)/b_cell64,2)*100+"%");
        target_season.setCell65(NumberUtils.round((cell65-b_cell65)/b_cell65,2)*100+"%");

        //第七行
        double cell72 = Double.parseDouble(season.getCell72());
        double cell73 = Double.parseDouble(season.getCell73());
        double cell74 = Double.parseDouble(season.getCell74());
        double cell75 = Double.parseDouble(season.getCell75());
        double cell70 = cell72+cell73+cell74+cell75;
        double cell71 = cell72+cell73;

        double b_cell72 = Double.parseDouble(seasonBefore.getCell72());
        double b_cell73 = Double.parseDouble(seasonBefore.getCell73());
        double b_cell74 = Double.parseDouble(seasonBefore.getCell74());
        double b_cell75 = Double.parseDouble(seasonBefore.getCell75());
        double b_cell70 = b_cell72+b_cell73+b_cell74+b_cell75;
        double b_cell71 = b_cell72+b_cell73;

        target_season.setCell70(NumberUtils.round((cell70-b_cell70)/b_cell70,2)*100+"%");
        target_season.setCell71(NumberUtils.round((cell71-b_cell71)/b_cell71,2)*100+"%");
        target_season.setCell72(NumberUtils.round((cell72-b_cell72)/b_cell72,2)*100+"%");
        target_season.setCell73(NumberUtils.round((cell73-b_cell73)/b_cell73,2)*100+"%");
        target_season.setCell74(NumberUtils.round((cell74-b_cell74)/b_cell74,2)*100+"%");
        target_season.setCell75(NumberUtils.round((cell75-b_cell75)/b_cell75,2)*100+"%");

        //第八行
        double cell82 = Double.parseDouble(season.getCell82());
        double cell83 = Double.parseDouble(season.getCell83());
        double cell84 = Double.parseDouble(season.getCell84());
        double cell85 = Double.parseDouble(season.getCell85());
        double cell80 = cell82+cell83+cell84+cell85;
        double cell81 = cell82+cell83;

        double b_cell82 = Double.parseDouble(seasonBefore.getCell82());
        double b_cell83 = Double.parseDouble(seasonBefore.getCell83());
        double b_cell84 = Double.parseDouble(seasonBefore.getCell84());
        double b_cell85 = Double.parseDouble(seasonBefore.getCell85());
        double b_cell80 = b_cell82+b_cell83+b_cell84+b_cell85;
        double b_cell81 = b_cell82+b_cell83;

        target_season.setCell80(NumberUtils.round((cell80-b_cell80)/b_cell80,2)*100+"%");
        target_season.setCell81(NumberUtils.round((cell81-b_cell81)/b_cell81,2)*100+"%");
        target_season.setCell82(NumberUtils.round((cell82-b_cell82)/b_cell82,2)*100+"%");
        target_season.setCell83(NumberUtils.round((cell83-b_cell83)/b_cell83,2)*100+"%");
        target_season.setCell84(NumberUtils.round((cell84-b_cell84)/b_cell84,2)*100+"%");
        target_season.setCell85(NumberUtils.round((cell85-b_cell85)/b_cell85,2)*100+"%");

        //第九行
        double cell92 = Double.parseDouble(season.getCell92());
        double cell93 = Double.parseDouble(season.getCell93());
        double cell94 = Double.parseDouble(season.getCell94());
        double cell95 = Double.parseDouble(season.getCell95());
        double cell90 = cell92+cell93+cell94+cell95;
        double cell91 = cell92+cell93;

        double b_cell92 = Double.parseDouble(seasonBefore.getCell92());
        double b_cell93 = Double.parseDouble(seasonBefore.getCell93());
        double b_cell94 = Double.parseDouble(seasonBefore.getCell94());
        double b_cell95 = Double.parseDouble(seasonBefore.getCell95());
        double b_cell90 = b_cell92+b_cell93+b_cell94+b_cell95;
        double b_cell91 = b_cell92+b_cell93;

        target_season.setCell90(NumberUtils.round((cell90-b_cell90)/b_cell90,2)*100+"%");
        target_season.setCell91(NumberUtils.round((cell91-b_cell91)/b_cell91,2)*100+"%");
        target_season.setCell92(NumberUtils.round((cell92-b_cell92)/b_cell92,2)*100+"%");
        target_season.setCell93(NumberUtils.round((cell93-b_cell93)/b_cell93,2)*100+"%");
        target_season.setCell94(NumberUtils.round((cell94-b_cell94)/b_cell94,2)*100+"%");
        target_season.setCell95(NumberUtils.round((cell95-b_cell95)/b_cell95,2)*100+"%");

        //第十行
        double cell102 = Double.parseDouble(season.getCell102());
        double cell103 = Double.parseDouble(season.getCell103());
        double cell104 = Double.parseDouble(season.getCell104());
        double cell105 = Double.parseDouble(season.getCell105());
        double cell100 = cell102+cell103+cell104+cell105;
        double cell101 = cell102+cell103;

        double b_cell102 = Double.parseDouble(seasonBefore.getCell102());
        double b_cell103 = Double.parseDouble(seasonBefore.getCell103());
        double b_cell104 = Double.parseDouble(seasonBefore.getCell104());
        double b_cell105 = Double.parseDouble(seasonBefore.getCell105());
        double b_cell100 = b_cell102+b_cell103+b_cell104+b_cell105;
        double b_cell101 = b_cell102+b_cell103;

        target_season.setCell100(NumberUtils.round((cell100-b_cell100)/b_cell100,2)*100+"%");
        target_season.setCell101(NumberUtils.round((cell101-b_cell101)/b_cell101,2)*100+"%");
        target_season.setCell102(NumberUtils.round((cell102-b_cell102)/b_cell102,2)*100+"%");
        target_season.setCell103(NumberUtils.round((cell103-b_cell103)/b_cell103,2)*100+"%");
        target_season.setCell104(NumberUtils.round((cell104-b_cell104)/b_cell104,2)*100+"%");
        target_season.setCell105(NumberUtils.round((cell105-b_cell105)/b_cell105,2)*100+"%");

        return target_season;
    }

}