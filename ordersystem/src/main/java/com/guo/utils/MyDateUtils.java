package com.guo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtils {
    private MyDateUtils(){}
    private static final SimpleDateFormat simpleDateFormat;
    static{
        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    }
    public static String getDate(long date){
        return simpleDateFormat.format(date);
    }
}
