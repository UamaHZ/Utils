package com.lvman.uamautil.common;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by ruchao.jiang on 2017/10/18.
 */
public class ToastUtil {

    private static Toast toast;

    public static void cancel() {
        if (toast != null) {
            toast.cancel();
        }
    }

    public static void show(Context context, String info) {
        toast = null;
        if (info == null || info.trim().length() < 1) {
            return;
        }
        if (null == toast) {
            toast = Toast.makeText(context.getApplicationContext(), info, Toast.LENGTH_SHORT);
        } else {
            toast.setText(info);
        }
        toast.show();
//		Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
    }

    public static void show(Context context, @StringRes int info) {
//        if (null == toast) {
//            toast = Toast.makeText(context, info, Toast.LENGTH_SHORT);
//
//        } else {
//            toast.setText(info);
//        }
//        toast.show();
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context, String info) {
//        if (info == null || info.trim().length() < 1) {
//            return;
//        }
//        if (null == toast) {
//            toast = Toast.makeText(context, info, Toast.LENGTH_LONG);
//        } else {
//            toast.setText(info);
//        }
//        toast.show();
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }

    public static void showLong(Context context, @StringRes int info) {
//        if (null == toast) {
//            toast = Toast.makeText(context, info, Toast.LENGTH_LONG);
//            // toast.setGravity(Gravity.CENTER, 0, 0);
//        } else {
//            toast.setText(info);
//        }
//        toast.show();
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }

    public static void showMaxLengthTip(Context context, int size) {
//        if (null == toast) {
//            toast = Toast.makeText(context, "不能超过" + size + "字", Toast.LENGTH_LONG);
//            // toast.setGravity(Gravity.CENTER, 0, 0);
//        } else {
//            toast.setText("不能超过" + size + "字");
//        }
//        toast.show();
        Toast.makeText(context, "不能超过" + size + "字", Toast.LENGTH_LONG).show();
    }

}
