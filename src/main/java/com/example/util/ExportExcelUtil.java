package com.example.util;

import com.example.bean.Season;
import com.example.bean.User;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by lenovo on 2017/2/21.
 */
public class ExportExcelUtil {
    /**
     * 描述：根据文件路径获取项目中的文件
     * @param fileDir 文件路径
     * @return
     * @throws Exception
     */
    public File getExcelDemoFile(String fileDir) throws Exception{
        Resource resource = new ClassPathResource(fileDir);
        if(!resource.exists()){
            throw new Exception("模板文件不存在！");
        }
        return resource.getFile();
    }

    public Workbook writeNewExcel(File file, String sheetName, List<Season> lis) throws Exception{
        Workbook wb = null;
        Row row = null;
        Cell cell = null;

        Sheet sheet = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            wb = new ImportExcelUtil().getWorkbook(fis, file.getName());    //获取工作薄
            sheet = wb.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //循环插入数据
        int lastRow = sheet.getLastRowNum()+1;    //插入数据的数据ROW
        CellStyle cs = setSimpleCellStyle(wb);    //Excel单元格样式
        for (int i = 0; i < lis.size(); i++) {
            row = sheet.createRow(lastRow+i); //创建新的ROW，用于数据插入

            //按项目实际需求，在该处将对象数据插入到Excel中

            Season vo  = lis.get(i);
            vo = DataUtil.computerSeason(vo);
            if(null==vo){
                break;
            }

            //Cell赋值开始
            //序号
            cell = row.createCell(0);
            cell.setCellStyle(cs);
            cell.setCellValue(i+1);

            //企业名称
            cell = row.createCell(1);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCompanyName());

            //============电子商务交易总额（万元）
            cell = row.createCell(2);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell10());
            //总额
            cell = row.createCell(3);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell11());
            //其中；销售额
            cell = row.createCell(4);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell12());
            //其中：采购额
            cell = row.createCell(5);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell13());
            //服务类交易额（万元）
            cell = row.createCell(6);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell14());
            //电子商务服务收入（万元）
            cell = row.createCell(7);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell15());
            //===================通过自营电子商务平台交易总额（万元）
            //总额
            cell = row.createCell(8);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell20());
            //商品类交易总额
            cell = row.createCell(9);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell21());
            //其中；销售额
            cell = row.createCell(10);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell22());
            //其中：采购额
            cell = row.createCell(11);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell23());
            //服务类交易额（万元）
            cell = row.createCell(12);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell24());
            //电子商务服务收入（万元）
            cell = row.createCell(13);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell25());
            //===================通过第三方电子商务平台交易总额（万元）
            //总额
            cell = row.createCell(14);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell30());
            //商品类交易总额
            cell = row.createCell(15);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell31());
            //其中；销售额
            cell = row.createCell(16);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell32());
            //其中：采购额
            cell = row.createCell(17);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell33());
            //服务类交易额（万元）
            cell = row.createCell(18);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell34());
            //电子商务服务收入（万元）
            cell = row.createCell(19);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell35());
            //===================B2B交易总额（万元）
            //总额
            cell = row.createCell(20);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell40());
            //商品类交易额总额（万元)
            cell = row.createCell(21);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell41());
            //其中；销售额
            cell = row.createCell(22);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell42());
            //其中：采购额
            cell = row.createCell(23);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell43());
            //服务类交易额（万元）
            cell = row.createCell(24);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell44());
            //电子商务服务收入（万元）
            cell = row.createCell(25);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell45());
            //=================B2C交易总额（万元）
            //总额
            cell = row.createCell(26);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell50());
            //商品类交易总额（万元)
            cell = row.createCell(27);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell51());
            //其中；销售额
            cell = row.createCell(28);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell52());
            //其中：采购额
            cell = row.createCell(29);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell53());
            //服务类交易额（万元）
            cell = row.createCell(30);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell54());
            //电子商务服务收入（万元）
            cell = row.createCell(31);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell55());
            //=================C2C交易总额（万元）
            //总额
            cell = row.createCell(32);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell60());
            //商品类交易总额（万元)
            cell = row.createCell(33);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell61());
            //其中；销售额
            cell = row.createCell(34);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell62());
            //其中：采购额
            cell = row.createCell(35);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell63());
            //服务类交易额（万元）
            cell = row.createCell(36);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell64());
            //电子商务服务收入（万元）
            cell = row.createCell(37);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell65());
            //==================境内交易总额（万元）
            cell = row.createCell(38);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell70());
            //商品类交易总额（万元)
            cell = row.createCell(39);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell71());
            //其中；销售额
            cell = row.createCell(40);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell72());
            //其中：采购额
            cell = row.createCell(41);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell73());
            //服务类交易额（万元）
            cell = row.createCell(42);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell74());
            //电子商务服务收入（万元）
            cell = row.createCell(43);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell75());
            //======================境外交易总额（万元）
            cell = row.createCell(44);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell80());
            //商品类交易总额（万元)
            cell = row.createCell(45);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell81());
            //其中；销售额
            cell = row.createCell(46);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell82());
            //其中：采购额
            cell = row.createCell(47);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell83());
            //服务类交易额（万元）
            cell = row.createCell(48);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell84());
            //电子商务服务收入（万元）
            cell = row.createCell(49);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell85());
            //==============境外进口交易总额（万元）
            cell = row.createCell(50);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell90());

            cell = row.createCell(51);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell91());

            cell = row.createCell(52);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell92());

            cell = row.createCell(53);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell93());

            cell = row.createCell(54);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell94());

            cell = row.createCell(55);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell95());
            //境外出口交易总额（万元）
            cell = row.createCell(56);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell100());

            cell = row.createCell(57);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell101());

            cell = row.createCell(58);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell102());

            cell = row.createCell(59);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell103());

            cell = row.createCell(60);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell104());

            cell = row.createCell(61);
            cell.setCellStyle(cs);
            cell.setCellValue(vo.getCell105());

        }
        return wb;
    }

    /**
     * 描述：设置简单的Cell样式
     * @return
     */
    public  CellStyle setSimpleCellStyle(Workbook wb){
        CellStyle cs = wb.createCellStyle();

        cs.setBorderBottom(CellStyle.BORDER_THIN); //下边框
        cs.setBorderLeft(CellStyle.BORDER_THIN);//左边框
        cs.setBorderTop(CellStyle.BORDER_THIN);//上边框
        cs.setBorderRight(CellStyle.BORDER_THIN);//右边框

        cs.setAlignment(CellStyle.ALIGN_CENTER); // 居中

        return cs;
    }
}
