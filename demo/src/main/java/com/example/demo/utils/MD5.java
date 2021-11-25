package com.example.demo.utils;

import org.springframework.util.DigestUtils;

public class MD5 {

    public static String md516(String str){
        if (str == null) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(str.getBytes()).substring(8, 24);
    }
}
