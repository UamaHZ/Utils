package com.lvman.uamautil.devicetype;

import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by GuJiaJia on 2018/8/29.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class ImageUtils {
    /**
     * 读取照片exif信息中的旋转角度
     * @param path 照片路径
     * @return 角度
     */
    public static int readPictureDegree(String path) {
        if (TextUtils.isEmpty(path)) {
            return 0;
        }
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (Exception e) {
            Log.i("Utils", "ImageUtils->readPictureDegree:".concat(e.getMessage()));
        }
        return degree;
    }
}
