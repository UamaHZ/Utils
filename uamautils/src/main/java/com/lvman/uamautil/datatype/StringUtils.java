package com.lvman.uamautil.datatype;

import android.text.TextUtils;

import java.text.DecimalFormat;

/**
 * Created by GuJiaJia on 2018/8/3.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class StringUtils {

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
}
