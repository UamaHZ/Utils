package com.lvman.uamautil.datatype;

import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by GuJiaJia on 2018/8/3.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class StringUtils {

    /**
     * 字符转换
     *
     */
    public static String newString(String source) {
        return TextUtils.isEmpty(source) ? "" : source;
    }

    /**
     * 拼接字符串
     */
    public static String concatString(String... params) {
        StringBuilder sb = new StringBuilder();
        for (String str : params) {
            sb.append(str != null ? str : "");
        }
        return sb.toString();
    }

    //String 转 Double
    public static Double stringToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return 0.0;
        }
    }

    /**
     * 处理double类型，保留两位小数
     *
     * @param dou 传入的double值
     * @return 保留两位小数的字符串
     */
    public static String doubleToString(Double dou) {
        if (dou == null) {
            return "0.00";
        }
        DecimalFormat df = new DecimalFormat("######0.00");
        return df.format(dou);
    }

    /**
     * 字符串 转整形
     *
     * @param data 字符串
     * @return 整形
     */
    public static int StringToInt(String data) {
        int result;
        try {
            result = Integer.parseInt(data.trim());
        } catch (Exception e) {
            return 0;
        }
        return result;
    }

    /**
     * 处理double类型，取整
     *
     * @param dou 传入的double值
     * @return 整型字符串
     */
    public static String doubleToIntegerString(Double dou) {
        if (dou == null) {
            return "";
        }
        DecimalFormat df = new DecimalFormat("######0");
        return df.format(dou);
    }

    //在TextView设置中划线
    public static void setMiddleFlag(TextView textView) {
        textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰
    }

    //在TextView设置下划线
    public static void setBottomFlag(TextView textView) {
        textView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); // 设置下划线并加清晰
    }

    //取消中划线
    public static void cancelMiddleFlag(TextView textView) {
        textView.getPaint().setFlags(0);  // 取消设置的的划线
    }
}
