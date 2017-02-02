package com.example.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by heying on 2017/1/31 0031.
 */
public class Md5Util{
        /**利用MD5进行加密
         * @param str  待加密的字符串
         * @return  加密后的字符串
         * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
         * @throws UnsupportedEncodingException
         */
        public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
            //确定计算方法
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
            return newstr;
        }

    /**
     * 对字符串md5加密
     *
     * @param str
     * @return
     */
    public static String str2Md5(String str) throws Exception {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new Exception("MD5加密出现错误");
        }
    }
}
