package com.lvman.uamautil.timetype;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by GuJiaJia on 2017/9/5.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */

public class DateUtils {
    public static final String Pattern_1 = "yyyy-MM-dd HH:mm:ss";
    public static final String Pattern_2 = "yyyy-MM-dd HH:mm";
    public static final String Pattern_3 = "yyyy-MM-dd";
    public static final String Pattern_4 = "yyyy/MM/dd HH:mm:ss";
    public static final String Pattern_5 = "yyyy/MM/dd";
    public static final String Pattern_6 = "yyyy";

    /**
     * Calendar转String
     *
     * @param calendar    传入Calendar对象
     * @param patternType 时间格式
     */
    public static String calendar2String(Calendar calendar, String patternType) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(patternType, Locale.CHINA);
            return sdf.format(calendar.getTime());
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 时间磋转String
     * @param patternType 时间格式
     */
    public static String longTimeToString(long time,String patternType) {
        SimpleDateFormat format = new SimpleDateFormat(patternType,Locale.CHINA);
        return format.format(time);
    }
}
