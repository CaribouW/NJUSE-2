package com.example.main.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于日期和字符串之间的转换
 */
@Component
public class DateUtils {
    /**
     * 日期转换成字符串
     *
     * @param date
     * @return str :精确到天
     */
    public String dateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 日期转成字符串
     *
     * @param date:The target date
     * @return str: 精确到秒
     */
    public String dateToStrDay(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 日期转成字符串
     *
     * @param date    :日期
     * @param pattern :自定义时间戳
     * @return str:目标字符串
     */
    public String dateToStr(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public Date strToDate(String str, String pattern) {

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public double subtractDate(Date from, Date to) {
        long fromL = from.getTime();   // getTime()返回到毫秒
        long toL = to.getTime();
        return (double) ((toL - fromL) / (1000 * 60));
    }
}
