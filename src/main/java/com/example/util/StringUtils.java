package com.example.util;

/**
 * Created by lenovo on 2017/3/1.
 */
public class StringUtils {
    public static String join( Object[] o , String flag ){
        StringBuffer str_buff = new StringBuffer();

        for(int i=0 , len=o.length ; i<len ; i++){
            str_buff.append( String.valueOf( o[i] ) );
            if(i<len-1)str_buff.append( flag );
        }

        return str_buff.toString();
    }
}
