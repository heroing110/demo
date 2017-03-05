package com.example.controller;

import com.example.bean.Season;
import com.example.bean.Year;
import com.example.service.SeasonService;
import com.example.service.YearService;
import com.example.util.DocumentHandler;
import com.example.util.ExportExcelUtil;
import com.example.util.MapUtil;
import com.google.common.collect.Maps;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/21.
 */
@RestController
@RequestMapping("/api/export")
public class ExportExcelController {
    @Autowired
    private SeasonService seasonService;
    @Autowired
    private YearService yearService;

    @RequestMapping(value = "/downSeasonIndustry", method = RequestMethod.GET)
    public Object downloadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> resultMap = Maps.newHashMap();
        String cityId = request.getParameter("cityId");
        String industry = request.getParameter("industry");
        String season = request.getParameter("season");
        String year = request.getParameter("year");
        OutputStream os = null;
        Workbook wb = null;    //工作薄

        try {
            resultMap.put("flag", true);
            List<Season> seasonList = seasonService.findByParams(industry,year,season,cityId);

            //导出Excel文件数据
            ExportExcelUtil util = new ExportExcelUtil();
            File file = util.getExcelDemoFile("excel_template/season.xlsx");
            String sheetName = "电子商务交易情况";
            wb = util.writeNewExcel(file, sheetName, seasonList);

            String fileName = "season_data.xlsx";
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) );
            os = response.getOutputStream();
            wb.write(os);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", false);
            resultMap.put("message", "导出季度报表异常");
        } finally {
            os.flush();
            os.close();
        }
        return resultMap;
    }

    @RequestMapping(value = "/downSeason", method = RequestMethod.GET)
    public Object downloadSeason(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> resultMap = Maps.newHashMap();
        String seasonId = request.getParameter("seasonId");
        OutputStream os = null;

        try {
            resultMap.put("flag", true);
            //数据库取值
            Season season = seasonService.findSeasonById(Long.parseLong(seasonId));
            //转换成map
            Map<String,Object> map = MapUtil.convertBean(season);

            String fileName = "["+season.getCompanyName()+"]"+season.getYear()+"年第"+season.getSeason()+"度报表.doc";
            response.setContentType("application/vnd.ms-word");
            response.setHeader("Content-disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) );
            os = response.getOutputStream();

            //导出word文件数据
            DocumentHandler documentHandler = new DocumentHandler("season.ftl");
            documentHandler.createDoc(map,os);
        } catch (IOException e) {
            e.printStackTrace();
            resultMap.put("flag", false);
            resultMap.put("message", "导出季度文档异常");
        }
        return resultMap;
    }

    @RequestMapping(value = "/downSeasonBefore", method = RequestMethod.GET)
    public Object downSeasonBefore(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> resultMap = Maps.newHashMap();
        String seasonId = request.getParameter("seasonId");
        OutputStream os = null;

        try {
            resultMap.put("flag", true);
            //数据库取值
            Season season = seasonService.findSeasonById(Long.parseLong(seasonId));
            Season seasonBefore = seasonService.findSeasonByYearAndSeasonAndUserId((Integer.parseInt(season.getYear())-1)+"",season.getSeason(),season.getUserId());
            if(seasonBefore==null){
                resultMap.put("flag",false);
                resultMap.put("message","未查询到去年同季度数据！");
                return resultMap;
            }

            //计算出同比的target_season
            Season target_season = seasonService.target_season(season, seasonBefore);

            //转换成map
            Map<String,Object> map = MapUtil.convertBean(target_season);

            String fileName = "["+season.getCompanyName()+"]"+season.getYear()+"年第"+season.getSeason()+"度报表.doc";
            response.setContentType("application/vnd.ms-word");
            response.setHeader("Content-disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) );
            os = response.getOutputStream();

            //导出word文件数据
            DocumentHandler documentHandler = new DocumentHandler("season.ftl");
            documentHandler.createDoc(map,os);
        } catch (IOException e) {
            e.printStackTrace();
            resultMap.put("flag", false);
            resultMap.put("message", "导出季度文档异常");
        }
        return resultMap;
    }


    @RequestMapping(value = "/downloadYear", method = RequestMethod.GET)
    public Object downloadYear(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> resultMap = Maps.newHashMap();
        String seasonId = request.getParameter("yearId");
        OutputStream os = null;

        try {
            resultMap.put("flag", true);
            //数据库取值
            Year year = yearService.findYearById(Long.parseLong(seasonId));
            int cell52 = Integer.parseInt(year.getCell52());
            int cell53 = Integer.parseInt(year.getCell53());
            int cell54 = Integer.parseInt(year.getCell54());
            int cell62 = Integer.parseInt(year.getCell62());
            int cell63 = Integer.parseInt(year.getCell63());
            int cell64 = Integer.parseInt(year.getCell64());

            int cell51 = cell52+cell53+cell54;
            int cell61 = cell62+cell63+cell64;
            year.setCell51(cell51+"");
            year.setCell61(cell61+"");

            //转换成map
            Map<String,Object> map = MapUtil.convertBean(year);

            String fileName = "["+year.getCompanyName()+"]"+year.getYear()+"年度报表.doc";
            response.setContentType("application/vnd.ms-word");
            response.setHeader("Content-disposition", "attachment;filename="+ new String( fileName.getBytes("gb2312"), "ISO8859-1" ) );
            os = response.getOutputStream();

            //导出word文件数据
            DocumentHandler documentHandler = new DocumentHandler("year.ftl");
            documentHandler.createDoc(map,os);
        } catch (IOException e) {
            e.printStackTrace();
            resultMap.put("flag", false);
            resultMap.put("message", "导出年度文档异常");
        }
        return resultMap;
    }
}
