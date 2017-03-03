package com.example.util;

import java.io.*;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.context.annotation.Bean;

/**
 * Created by lenovo on 2017/2/22.
 */
public class DocumentHandler {
    private Configuration configuration = null;
    private String template;

    public DocumentHandler(String template) {
        this.template = template;
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
    }

    public void createDoc(Map<String,Object> dataMap,OutputStream os) throws IOException {
        //dataMap 要填入模本的数据文件
        //设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，
        //这里我们的模板是放在template包下面
        configuration.setClassForTemplateLoading(this.getClass(), "/word_template");
        Template t = null;
        Writer out = null;

        try {
            //test.ftl为要装载的模板
            t = configuration.getTemplate(template);
            //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。
            OutputStreamWriter oWriter = new OutputStreamWriter(os,"UTF-8");
//            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
            out = new BufferedWriter(oWriter);
            t.process(dataMap, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            os.flush();
            os.close();
        }

        //System.out.println("---------------------------");
    }
}
