package com.example.controller;

import com.example.bean.Season;
import com.example.bean.User;
import com.example.service.SeasonService;
import com.example.util.DocumentHandler;
import com.example.util.ExportExcelUtil;
import com.example.util.MapUtil;
import com.google.common.collect.Maps;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/21.
 */
@RestController
@RequestMapping("/api/excel")
public class ExportExcelController {
    @Autowired
    private SeasonService seasonService;

    @RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
    public Object downloadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> resultMap = Maps.newHashMap();
        String seasonId = request.getParameter("seasonId");
        OutputStream os = null;
        Workbook wb = null;    //工作薄

        try {
            resultMap.put("flag", true);
            Season season = seasonService.findSeasonById(Long.parseLong(seasonId));
            //数据库取值
            List<List<String>> lo = seasonService.getSeasonLists(season);

            //导出Excel文件数据
            ExportExcelUtil util = new ExportExcelUtil();
            File file = util.getExcelDemoFile("excel_template/season.xlsx");
            String sheetName = "电子商务交易情况";
            wb = util.writeNewExcel(file, sheetName, lo);

            String fileName = "season_data.xlsx";
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
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

    @RequestMapping(value = "/downloadWord", method = RequestMethod.GET)
    public Object downloadWord(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> resultMap = Maps.newHashMap();
        String seasonId = request.getParameter("seasonId");
        OutputStream os = null;

        try {
            resultMap.put("flag", true);
            //数据库取值
            Season season = seasonService.findSeasonById(Long.parseLong(seasonId));
            //转换成map
            Map<String,Object> map = MapUtil.convertBean(season);

            String fileName = "season_data.doc";
            response.setContentType("application/vnd.ms-word");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
            os = response.getOutputStream();

            //导出word文件数据
            DocumentHandler documentHandler = new DocumentHandler();
            documentHandler.createDoc(map,os);
        } catch (IOException e) {
            e.printStackTrace();
            resultMap.put("flag", false);
            resultMap.put("message", "导出季度文档异常");
        }
        return resultMap;
    }

}
