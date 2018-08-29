package com.lvman.uamautil.datatype;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.RelativeSizeSpan;

import java.text.DecimalFormat;

/**
 * Created by GuJiaJia on 2017/6/26.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */

public class MoneyUtils {

    //获取一个普通的带金额 符号的
    public static String withMoney(String money) {
        if (TextUtils.isEmpty(money)) {
            return "¥";
        }
        return "¥".concat(money);
    }

    //获取一个普通的带金额 符号的，保留两位小数
    public static String withMoney(double money) {
        DecimalFormat df = new DecimalFormat("######0.00");
        return "¥".concat(df.format(money));
    }

    //获取一个普通的带金额 符号的,金额和符号之间有空格
    public static String withSpaceMoney(String money) {
        if (TextUtils.isEmpty(money)) {
            return "¥";
        }
        return "¥ ".concat(money);
    }

    //获取一个普通的带金额 符号的,金额和符号之间有空格，保留两位小数
    public static String withSpaceMoney(double money) {
        DecimalFormat df = new DecimalFormat("######0.00");
        return "¥ ".concat(df.format(money));
    }

    /**
     * 显示不同大小的字符串
     *
     * @param unit 單位
     * @param text
     * @return
     */
    public static SpannableStringBuilder getPriceStyle(Double text, String unit) {
        if (unit == null) {
            unit = "";
        }
        String price;
        SpannableStringBuilder spannable;
        price = StringUtils.doubleToString(text);
        String priceStr = "¥".concat(price).concat(unit);
        spannable = new SpannableStringBuilder(priceStr);//用于可变字符串
        CharacterStyle span_1 = new RelativeSizeSpan(1.5f);
        spannable.setSpan(span_1, 1, String.valueOf(text.intValue()).length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }
}
