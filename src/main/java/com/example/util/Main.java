package com.example.util;

import com.google.common.collect.Maps;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/22.
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Map<String,Object> dataMap = Maps.newHashMap();
        dataMap.put("name","world");

        DocumentHandler documentHandler = new DocumentHandler();
        documentHandler.createDoc(dataMap,"c:/test1.doc");
    }
}
