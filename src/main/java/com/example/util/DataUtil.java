package com.example.util;

import com.example.bean.Season;
import org.springframework.util.StringUtils;

/**
 * Created by heying on 2017/7/10.
 */
public class DataUtil {
    public static Season computerSeason(Season season) {
        //第一行
        double cell12 = Double.parseDouble(!StringUtils.isEmpty(season.getCell12())?season.getCell12():"0");
        double cell13 = Double.parseDouble(!StringUtils.isEmpty(season.getCell13())?season.getCell13():"0");
        double cell14 = Double.parseDouble(!StringUtils.isEmpty(season.getCell14())?season.getCell14():"0");
        double cell15 = Double.parseDouble(!StringUtils.isEmpty(season.getCell15())?season.getCell15():"0");
        double cell10 = cell12+cell13+cell14+cell15;
        double cell11 = cell12+cell13;

        season.setCell10(cell10+"");
        season.setCell11(cell11+"");

        //第二行
        double cell22 = Double.parseDouble(!StringUtils.isEmpty(season.getCell22())?season.getCell22():"0");
        double cell23 = Double.parseDouble(!StringUtils.isEmpty(season.getCell23())?season.getCell23():"0");
        double cell24 = Double.parseDouble(!StringUtils.isEmpty(season.getCell24())?season.getCell24():"0");
        double cell25 = Double.parseDouble(!StringUtils.isEmpty(season.getCell25())?season.getCell25():"0");
        double cell20 = cell22+cell23+cell24+cell25;
        double cell21 = cell22+cell23;

        season.setCell20(cell20+"");
        season.setCell21(cell21+"");

        //第三行
        double cell32 = Double.parseDouble(!StringUtils.isEmpty(season.getCell32())?season.getCell32():"0");
        double cell33 = Double.parseDouble(!StringUtils.isEmpty(season.getCell33())?season.getCell33():"0");
        double cell34 = Double.parseDouble(!StringUtils.isEmpty(season.getCell34())?season.getCell34():"0");
        double cell35 = Double.parseDouble(!StringUtils.isEmpty(season.getCell35())?season.getCell35():"0");
        double cell30 = cell32+cell33+cell34+cell35;
        double cell31 = cell32+cell33;

        season.setCell30(cell30+"");
        season.setCell31(cell31+"");

        //第四行
        double cell42 = Double.parseDouble(!StringUtils.isEmpty(season.getCell42())?season.getCell42():"0");
        double cell43 = Double.parseDouble(!StringUtils.isEmpty(season.getCell43())?season.getCell43():"0");
        double cell44 = Double.parseDouble(!StringUtils.isEmpty(season.getCell44())?season.getCell44():"0");
        double cell45 = Double.parseDouble(!StringUtils.isEmpty(season.getCell45())?season.getCell45():"0");
        double cell40 = cell42+cell43+cell44+cell45;
        double cell41 = cell42+cell43;

        season.setCell40(cell40+"");
        season.setCell41(cell41+"");

        //第五行
        double cell52 = Double.parseDouble(!StringUtils.isEmpty(season.getCell52())?season.getCell52():"0");
        double cell53 = Double.parseDouble(!StringUtils.isEmpty(season.getCell53())?season.getCell53():"0");
        double cell54 = Double.parseDouble(!StringUtils.isEmpty(season.getCell54())?season.getCell54():"0");
        double cell55 = Double.parseDouble(!StringUtils.isEmpty(season.getCell55())?season.getCell55():"0");
        double cell50 = cell52+cell53+cell54+cell55;
        double cell51 = cell52+cell53;

        season.setCell50(cell50+"");
        season.setCell51(cell51+"");

        //第六行
        double cell62 = Double.parseDouble(!StringUtils.isEmpty(season.getCell62())?season.getCell62():"0");
        double cell63 = Double.parseDouble(!StringUtils.isEmpty(season.getCell63())?season.getCell63():"0");
        double cell64 = Double.parseDouble(!StringUtils.isEmpty(season.getCell64())?season.getCell64():"0");
        double cell65 = Double.parseDouble(!StringUtils.isEmpty(season.getCell65())?season.getCell65():"0");
        double cell60 = cell62+cell63+cell64+cell65;
        double cell61 = cell62+cell63;

        season.setCell60(cell60+"");
        season.setCell61(cell61+"");

        //第七行
        double cell72 = Double.parseDouble(!StringUtils.isEmpty(season.getCell62())?season.getCell62():"0");
        double cell73 = Double.parseDouble(!StringUtils.isEmpty(season.getCell63())?season.getCell63():"0");
        double cell74 = Double.parseDouble(!StringUtils.isEmpty(season.getCell64())?season.getCell64():"0");
        double cell75 = Double.parseDouble(!StringUtils.isEmpty(season.getCell65())?season.getCell65():"0");
        double cell70 = cell72+cell73+cell74+cell75;
        double cell71 = cell72+cell73;

        season.setCell70(cell70+"");
        season.setCell71(cell71+"");

        //第八行
        double cell82 = Double.parseDouble(!StringUtils.isEmpty(season.getCell82())?season.getCell82():"0");
        double cell83 = Double.parseDouble(!StringUtils.isEmpty(season.getCell83())?season.getCell83():"0");
        double cell84 = Double.parseDouble(!StringUtils.isEmpty(season.getCell84())?season.getCell84():"0");
        double cell85 = Double.parseDouble(!StringUtils.isEmpty(season.getCell85())?season.getCell85():"0");
        double cell80 = cell82+cell83+cell84+cell85;
        double cell81 = cell82+cell83;

        season.setCell80(cell80+"");
        season.setCell81(cell81+"");

        //第九行
        double cell92 = Double.parseDouble(!StringUtils.isEmpty(season.getCell92())?season.getCell92():"0");
        double cell93 = Double.parseDouble(!StringUtils.isEmpty(season.getCell93())?season.getCell93():"0");
        double cell94 = Double.parseDouble(!StringUtils.isEmpty(season.getCell94())?season.getCell94():"0");
        double cell95 = Double.parseDouble(!StringUtils.isEmpty(season.getCell95())?season.getCell95():"0");
        double cell90 = cell92+cell93+cell94+cell95;
        double cell91 = cell92+cell93;

        season.setCell90(cell90+"");
        season.setCell91(cell91+"");


        //第十行
        double cell102 = Double.parseDouble(!StringUtils.isEmpty(season.getCell102())?season.getCell102():"0");
        double cell103 = Double.parseDouble(!StringUtils.isEmpty(season.getCell103())?season.getCell103():"0");
        double cell104 = Double.parseDouble(!StringUtils.isEmpty(season.getCell104())?season.getCell104():"0");
        double cell105 = Double.parseDouble(!StringUtils.isEmpty(season.getCell105())?season.getCell105():"0");
        double cell100 = cell102+cell103+cell104+cell105;
        double cell101 = cell102+cell103;

        season.setCell100(cell100+"");
        season.setCell101(cell101+"");

        return season;
    }

}
