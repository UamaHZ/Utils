package com.lvman.uamautil.timetype;

import android.text.TextUtils;

import com.lvman.uamautil.datatype.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
            SimpleDateFormat sdf = new SimpleDateFormat(patternType, Locale.getDefault());
            return sdf.format(calendar.getTime());
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * 字符串转Calendar
     * @param dateStr 字符串时间
     * @param dateType 格式
     * @return calendar
     */
    public static Calendar strToCalendar(String dateStr, String dateType) {
        Calendar calendar = null;
        if (!TextUtils.isEmpty(dateStr)) {
            // 创建日期的格式化类型
            SimpleDateFormat format = new SimpleDateFormat(dateType,Locale.getDefault());
            // 创建一个Calendar类型的对象
            calendar = Calendar.getInstance();
            // forma.parse()方法会抛出异常
            try {
                //解析日期字符串，生成Date对象
                Date date = format.parse(dateStr);
                // 使用Date对象设置此Calendar对象的时间
                calendar.setTime(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return calendar;
    }

    /**
     * 时间磋转String
     *
     * @param patternType 时间格式
     */
    public static String longTimeToString(long time, String patternType) {
        SimpleDateFormat format = new SimpleDateFormat(patternType, Locale.getDefault());
        return format.format(time);
    }


    /**
     * 字符串时间获取时间戳
     * @param str String类型的时间
     * @param type 时间格式
     * @return 时间戳
     */
    public static Long stringToDateStamp(String str, String type) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type,Locale.getDefault());
            Date date = simpleDateFormat.parse(str);
            return date.getTime();
        } catch (Exception e) {
            return 0L;
        }
    }

    /**
     * 数字小于10的前面加上0.类似 5转换成05
     * @param number 数字
     * @return result
     */
    public static String numberAddZero(int number) {
        if (number < 10) {
            return StringUtils.concatString("0", String.valueOf(number));
        } else {
            return String.valueOf(number);
        }
    }

    /**
     * 字符串时间重新格式化
     * @param dateTime 字符串时间
     * @param currentType 当前字符串时间的格式
     * @param targetType 新的字符串格式
     * @return 新的字符串时间
     */
    public static String strDateFormat(String dateTime, String currentType,String targetType) {
        try {
            Calendar calendar = strToCalendar(dateTime,currentType);
            return calendar2String(calendar,targetType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
