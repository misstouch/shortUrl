package com.misstouch.urlencode.utils;

import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.util.Random;

/**
 * @author hechao
 * @date create in 15:40 2019/5/11/011
 */
public class UrlEncodeUtil {

    private static final String[] chars = {"a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    public static void main(String[] args) {
        String sLongUrl = "http://www.taobao.com/market/alineiwai/chendu.php"; // 原始链接
        System.out.println("长链接:"+sLongUrl);
        String aResult = encodeUrl(sLongUrl);//将产生4组6位字符串
        // 打印出结果
        System.out.println("短链接:"+aResult);//随机取一个作为短链
    }

    public static String encodeUrl(String url) {
        Assert.notNull(url,"url can not be null");
        Assert.hasLength(url, "url can not be empty");
        String key = "";
        String md5Result = md5Hex(key + url);
        String result;
        String temp = md5Result.substring(0, 8);
        long hexLong = 0x3FFFFFFF & Long.parseLong(temp, 16);
        String outChars = "";
        for (int j=0; j<5; j++) {
            long index = 0x0000003D & hexLong;
            outChars+=chars[(int) index];;
            hexLong=hexLong>>5;
        }
        result = outChars;
        return result;
    }

    private static String md5Hex(String src){
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] b = src.getBytes();
            md.reset();
            md.update(b);
            byte[] hash = md.digest();
            String hs = "";
            String temp = "";
            for (int i=0; i<hash.length; i++) {
                temp = Integer.toHexString(hash[i] & 0xFF);
                if (temp.length() == 1) {
                    hs = hs + "0" + temp;
                } else {
                    hs = hs + temp;
                }
            }
            return hs.toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
