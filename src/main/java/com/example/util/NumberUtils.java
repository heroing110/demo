package com.example.util;

import java.math.BigDecimal;

/**
 * Created by lenovo on 2017/3/1.
 */
public class NumberUtils {

    /**
     * 四舍五入
     * @param f 小数
     * @param num 保留位数
     * @return
     */
    public static double round(double f,int num){
        BigDecimal b   =   new   BigDecimal(f);
        double   f1   =   b.setScale(num,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

}
