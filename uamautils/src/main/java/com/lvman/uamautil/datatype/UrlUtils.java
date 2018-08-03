package com.lvman.uamautil.datatype;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by GuJiaJia on 2017/9/5.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */

public class UrlUtils {

    /**
     * 拼接url参数
     * @param baseUrl 基础url
     * @param params  需要作键值对拼接在url后面的Map
     * @return 一个完整的url
     */
    public static String getUrl(String baseUrl, HashMap<String, String> params) {
        // 添加url参数
        if (params != null) {
            Iterator<String> it = params.keySet().iterator();
            StringBuffer sb = null;
            while (it.hasNext()) {
                String key = it.next();
                String value = params.get(key);
                if (sb == null) {
                    sb = new StringBuffer();
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(key);
                sb.append("=");
                sb.append(value);
            }
            if(sb != null){
                baseUrl += sb.toString();
            }
        }
        return baseUrl;
    }
}
