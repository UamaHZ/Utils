package com.lvman.uamautil.unittype;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.lvman.uamautil.common.ToastUtil;
import com.lvman.uamautil.datatype.StringUtils;
import com.lvman.uamautil.datatype.UrlUtils;
import com.lvman.uamautil.devicetype.DeviceUtils;

import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * 坐标转换的工具类
 * <p>
 * Created by GuJiaJia on 2017/6/28.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */

public class GpsUtils {

    public static double pi = 3.1415926535897932384626;
    public static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
    public static double a = 6378245.0;
    public static double ee = 0.00669342162296594323;

    /**
     * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 将 GCJ-02 坐标转换成 BD-09 坐标
     *
     * @param lat 纬度
     * @param lon 经度
     */
    public static double[] gcj02_To_Bd09(double lat, double lon) {
        double x = lon, y = lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        double tempLon = z * Math.cos(theta) + 0.0065;
        double tempLat = z * Math.sin(theta) + 0.006;
        return new double[]{tempLat, tempLon};
    }

    /**
     * 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 * * 将 BD-09 坐标转换成GCJ-02 坐标 *
     *
     * @param lat 纬度
     * @param lon 经度
     */
    public static double[] bd09_To_Gcj02(double lat, double lon) {
        double x = lon - 0.0065, y = lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        double tempLon = z * Math.cos(theta);
        double tempLat = z * Math.sin(theta);
        return new double[]{tempLat, tempLon};
    }

    /**
     * 打开高德地图
     *
     * @param mLat      终点纬度
     * @param mlon      终点经度
     * @param pointName 目的地
     * @param appName   当前应用名称
     */
    public static void openAMap(Context mContext, String mLat, String mlon, String pointName, String appName) {
        if (TextUtils.isEmpty(mLat) || TextUtils.isEmpty(mlon)) {
            ToastUtil.show(mContext, "获取位置信息失败");
            return;
        }
        if (DeviceUtils.checkApkExist(mContext, "com.autonavi.minimap")) {
            try {
                HashMap<String, String> amap = new HashMap<>();
                amap.put("sourceApplication", appName);//第三方调用应用名称
                amap.put("poiname", pointName);//目的地
                amap.put("lat", mLat);//终点纬度
                amap.put("lon", mlon);//终点经度
                amap.put("dev", "0");//起终点是否偏移(0:lat 和 lon 是已经加密后的,不需要国测加密;1:需要国测加密)
                mContext.startActivity(new Intent().setData(Uri.parse(UrlUtils.getUrl("androidamap://viewMap", amap))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ToastUtil.show(mContext, "未安装相关软件，请下载导航应用");
        }
    }

    /**
     * 打开百度地图
     *
     * @param location at,lng (先纬度，后经度)拼接
     * @param title    打点标题
     */
    public static void openBDMap(Context mContext, String location, String title) {
        if (TextUtils.isEmpty(location) || TextUtils.isEmpty(title)) {
            ToastUtil.show(mContext, "获取位置信息失败");
            return;
        }
        if (DeviceUtils.checkApkExist(mContext, "com.baidu.BaiduMap")) {
            try {
                HashMap<String, String> hashMap = new HashMap();
                hashMap.put("location", location);
                hashMap.put("title", title);
                hashMap.put("traffic", "on");
                mContext.startActivity(new Intent().setData(Uri.parse(UrlUtils.getUrl("baidumap://map/marker", hashMap))));
            } catch (Exception e) {

            }
        } else {
            ToastUtil.show(mContext, "未安装相关软件，请下载导航应用");
        }
    }

    //获取百度地图location
    public static String getBDLocation(String lat, String lon) {
        double[] location = gcj02_To_Bd09(StringUtils.stringToDouble(lat), StringUtils.stringToDouble(lon));
        return gpsDoubleToString(location[0]) + "," + gpsDoubleToString(location[1]);
    }

    private static String gpsDoubleToString(Double dou) {
        if (dou == null) {
            return "0.000000";
        }
        DecimalFormat df = new DecimalFormat("######0.000000");
        return df.format(dou);
    }
}
