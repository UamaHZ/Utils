package com.lvman.uamautil.datatype;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by GuJiaJia on 2018/9/6.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class AssetUtils {

    //从assets中获取Json字符串
    public static String getFromAssets(Context c, String fileName) {
        StringBuilder Result = new StringBuilder();
        try {
            InputStreamReader inputReader = new InputStreamReader(c.getResources().getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";

            while ((line = bufReader.readLine()) != null) {
                Result.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Result.toString();
    }
}
