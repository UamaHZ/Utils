/*
 * 杭州绿漫科技有限公司
 * Copyright (c) 16-6-27 上午10:30.
 */

package com.lvman.uamautil.devicetype;

import android.text.TextUtils;

import com.lvman.uamautil.datatype.StringUtils;


public class MD5Utils {

    public static String md5(String strMd5) {
        if (TextUtils.isEmpty(strMd5)) {
            return null;
        }
        String sRet = null;
        try {
            java.security.MessageDigest alga = java.security.MessageDigest
                    .getInstance("MD5");
            alga.update(strMd5.getBytes());
            byte[] digesta = alga.digest();
            sRet = byte2hex(digesta);
        } catch (java.security.NoSuchAlgorithmException ex) {
        }
        return sRet;
    }

    public static String byte2hex(byte[] b) // 二行制转字符串
    {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = StringUtils.concatString(hs, "0", stmp);
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1)
                hs = hs + "";
        }
        return hs;
    }

}
