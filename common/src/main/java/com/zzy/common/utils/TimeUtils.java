package com.zzy.common.utils;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author zzy
 * @date 2018/9/18
 */

public class TimeUtils {

    public static int getCurrentYear(){
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));    //获取东八区时间
        int year = c.get(Calendar.YEAR);
        return year;
    }
}
