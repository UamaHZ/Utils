package com.lvman.uamautil.timetype;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by GuJiaJia on 2018/8/3.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class TimeUtils {
    public static final String DAY = "DAY";
    public static final String HOUR = "HOUR";
    public static final String MINUTE = "MINUTE";
    public static final String SECOND = "SECOND";

    /**
     * 获取当前时间
     * 返回到秒
     */
    public static String getSystemTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return sDateFormat.format(new java.util.Date());
    }


    /**
     * 获取时间差，默认单位是秒
     *
     * @param timeType  时间单位
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return int类型
     */
    public static int getTimeDifference(String timeType, String startTime, String endTime) {
        if (startTime == null || endTime == null) {
            return -1;
        }
        try {
            SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            long from = simpleFormat.parse(startTime).getTime();
            long to = simpleFormat.parse(endTime).getTime();
            int type = 0;
            switch (timeType) {
                case DAY:
                    type = 1000 * 60 * 60 * 24;
                    break;
                case HOUR:
                    type = 1000 * 60 * 60;
                    break;
                case MINUTE:
                    type = 1000 * 60;
                    break;
                case SECOND:
                    type = 1000;
                    break;
                default:
                    type = 1000;
                    break;
            }
            return (int) ((to - from) / type);
        } catch (Exception e) {
            return -1;
        }
    }
}
