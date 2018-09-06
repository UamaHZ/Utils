package com.lvman.uamautil.arraytype;

import java.util.List;

/**
 * Created by GuJiaJia on 2018/8/3.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class ListUtils {
    /**
     * 判断List不为null,同时size!=0
     *
     * @param list 传入list
     * @return 当list有值时返回true, 否则返回false
     */
    public static boolean hasData(List list) {
        return list != null && list.size() != 0;
    }


    /**
     * 判断List是否为空
     *
     * @param list 传入list
     * @return 当list有值时返回false, 否则返回true
     */
    public static boolean isEmpty(List list) {
        return !hasData(list);
    }

}
