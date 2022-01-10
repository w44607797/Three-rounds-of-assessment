package com.guo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyDateUtils {
    private MyDateUtils(){}
    private static final SimpleDateFormat simpleDateFormat;
    static{
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    public static String getDate(long date){
        return simpleDateFormat.format(date);
    }
    public static Date getDate(String date) throws ParseException {return simpleDateFormat.parse(date);}
}
