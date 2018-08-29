package com.lvman.uamautil.devicetype;

import android.os.Environment;

import java.io.File;

/**
 * Created by GuJiaJia on 2018/8/29.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class StorageUtils {

    /**
     * 判断SD卡是否可用
     *
     * @return boolean
     */
    public static boolean isSDCardOK() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取SD卡跟路径。SD卡不可用时，返回null
     */
    public static String getSDCardRootPath() {
        if (isSDCardOK()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return null;
    }

    // 判断文件是否存在:部分路径
    public static boolean isFileExist(String directorPath) {
        File file = new File(directorPath);
        return file.exists();
    }

    //全路径
    public static boolean isFileExistByAbsolute(String absolutePath) {
        File file = new File(absolutePath);
        return file.exists();
    }

    /**
     * create multiple director
     * 创建文件夹 提示，6.0以上要手动获取存储权限
     *
     * @param directorPath 文件夹路径(全路径）
     * @return 是否创建成功
     */
    public static boolean createFilePackage(String directorPath) {
        //已经存在该文件
        if (isFileExist(directorPath))
            return true;
        File fileDir = new File(directorPath);
        return fileDir.mkdirs();
    }
}
