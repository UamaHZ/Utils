package com.lvman.uamautil.datatype;

/**
 * Created by GuJiaJia on 2018/8/3.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class StringUtils {

    /**
     * 获取一个前面带金额符号的
     *
     * @param money 传入的字符串
     * @return “¥XX"
     */
    public static String withMoney(String money) {
        if (money == null) {
            return "¥";
        }
        return "¥" + money;
    }
}
