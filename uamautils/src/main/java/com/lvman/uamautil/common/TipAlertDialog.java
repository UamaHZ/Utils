package com.lvman.uamautil.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

import com.lvman.uamautil.listener.SuccessListener;

/**
 * Created by GuJiaJia on 2017/8/2.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */

public class TipAlertDialog {
    private static AlertDialog alertDialog;


    /**
     * 只有一个确定的提示框 无回调监听
     *
     * @param confirm 确定文案
     * @param content 提示文案
     */
    @SuppressLint("NewApi")
    public static void showTip(Context context, String confirm, String content) {
        if(context == null){
            return;
        }
        if(context instanceof Activity){
            if(((Activity) context).isFinishing() || ((Activity) context).isDestroyed())
                return;
        }
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        alertDialog = new AlertDialog.Builder(context)
                .setCancelable(false)
                .setMessage(content)
                .setPositiveButton(TextUtils.isEmpty(confirm) ? "确定" : confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }

    /**
     * @param confirm 确定文案
     * @param content 提示文案
     */
    public static void showTip(Context context, String confirm, String cancel, String content, final SuccessListener clickListener) {
        if(context == null){
            return;
        }
        if(context instanceof Activity){
            if(((Activity) context).isFinishing() || ((Activity) context).isDestroyed())
                return;
        }
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        alertDialog = new AlertDialog.Builder(context)
                .setCancelable(false)
                .setMessage(content)
                .setPositiveButton(TextUtils.isEmpty(confirm) ? "确定" : confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (clickListener != null) {
                            clickListener.success();
                        }
                    }
                })
                .setNegativeButton(TextUtils.isEmpty(cancel) ? "取消" : cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }

    /**
     * 只有一个确定的提示框 有回调监听
     *
     * @param confirm 确定文案
     * @param content 提示文案
     */
    public static void showTip(Context context, String confirm, String content, final SuccessListener clickListener) {
        if(context == null){
            return;
        }
        if(context instanceof Activity){
            if(((Activity) context).isFinishing() || ((Activity) context).isDestroyed())
                return;
        }
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        alertDialog = new AlertDialog.Builder(context)
                .setCancelable(false)
                .setMessage(content)
                .setPositiveButton(TextUtils.isEmpty(confirm) ? "确定" : confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (clickListener != null) {
                            clickListener.success();
                        }

                    }
                }).show();
    }

    public static void dismiss() {
        if (alertDialog != null)
            alertDialog.dismiss();
    }
}
