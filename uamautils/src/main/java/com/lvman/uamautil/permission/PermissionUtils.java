package com.lvman.uamautil.permission;

import android.Manifest;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.lvman.uamautil.common.TipAlertDialog;
import com.lvman.uamautil.listener.SuccessListener;
import com.lvman.uamautil.listener.SuccessOrFailListener;
import com.lvman.uamautils.R;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;

import java.util.List;

/**
 * Created by GuJiaJia on 2018/11/7.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class PermissionUtils {

    /**
     * 单独相机权限判断（包含存储权限）
     *
     * @param context         context
     * @param rejectTip       拒绝后的提示
     * @param successListener 授权监听
     */
    public static void checkCameraPermission(final Context context, final String rejectTip, @NonNull final SuccessListener successListener) {
        AndPermission.with(context)
                .runtime()
                .permission(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        if (successListener != null && AndPermission.hasAlwaysDeniedPermission(context, data)) {
                            successListener.success();
                        }
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        rejectPermissionTip(context, TextUtils.isEmpty(rejectTip) ? context.getString(R.string.uama_util_no_camera_and_storage_permission) : rejectTip);
                    }
                })
                .start();
    }


    /**
     * 单独存储权限检查
     *
     * @param context         context
     * @param rejectTip       拒绝后的提示
     * @param successListener 授权监听
     */
    public static void checkExternalPermission(final Context context, final String rejectTip, final SuccessListener successListener) {
        AndPermission.with(context)
                .runtime()
                .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        if (successListener != null && AndPermission.hasAlwaysDeniedPermission(context, data)) {
                            successListener.success();
                        }
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        rejectPermissionTip(context, TextUtils.isEmpty(rejectTip) ? context.getString(R.string.uama_util_read_status_permission_is_need) : rejectTip);
                    }
                })
                .start();
    }


    /**
     * 判断手机定位权限
     *
     * @param context         context
     * @param rejectTip       拒绝后的提示
     * @param successListener 授权监听
     */
    public static void checkLocationPermission(final Context context, final String rejectTip, @NonNull final SuccessListener successListener) {
        AndPermission.with(context)
                .runtime()
                .permission(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        if (successListener != null && AndPermission.hasAlwaysDeniedPermission(context, data)) {
                            successListener.success();
                        }
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        rejectPermissionTip(context, TextUtils.isEmpty(rejectTip) ? context.getString(R.string.uama_util_no_location_permission) : rejectTip);
                    }
                })
                .start();
    }

    /**
     * 读取手机状态的权限
     *
     * @param context         context
     * @param rejectTip       拒绝后的提示
     * @param successListener 授权监听
     */
    public static void checkPhoneStatePermission(final Context context, final String rejectTip, @NonNull final SuccessListener successListener) {
        AndPermission.with(context)
                .runtime()
                .permission(Manifest.permission.READ_PHONE_STATE)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        if (successListener != null && AndPermission.hasAlwaysDeniedPermission(context, data)) {
                            successListener.success();
                        }
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        rejectPermissionTip(context, TextUtils.isEmpty(rejectTip) ? context.getString(R.string.uama_util_no_read_phone_permission) : rejectTip);
                    }
                })
                .start();
    }
    /**
     * 通用的权限检查方式
     *
     * @param context         context
     * @param rejectTip       拒绝后的提示
     * @param successListener 授权监听
     * @param permission      需要检查的权限
     */
    public static void checkPermission(final Context context, final String rejectTip, final SuccessListener successListener, @NonNull String... permission) {
        AndPermission.with(context)
                .runtime()
                .permission(permission)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        if (successListener != null && AndPermission.hasAlwaysDeniedPermission(context, data)) {
                            successListener.success();
                        }
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        rejectPermissionTip(context, rejectTip);
                    }
                })
                .start();
    }

    /**
     * 通用的权限检查方式 带拒绝权限的返回监听
     *
     * @param context         context
     * @param successListener 授权监听
     * @param permission      需要检查的权限
     */
    public static void checkPermission(final Context context, final SuccessOrFailListener successListener, String... permission) {
        AndPermission.with(context)
                .runtime()
                .permission(permission)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        if (successListener != null && AndPermission.hasAlwaysDeniedPermission(context, data)) {
                            successListener.success();
                        }
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        successListener.fail();
                    }
                })
                .start();
    }

    /**
     * 拒绝或没有权限时提示
     *
     * @param context   context
     * @param rejectTip 拒绝后的提示
     */
    private static void rejectPermissionTip(final Context context, String rejectTip) {
        TipAlertDialog.showTip(context, context.getString(R.string.uama_util_setting_permission), context.getString(R.string.uama_util_cancel), rejectTip, new SuccessListener() {
            @Override
            public void success() {
                EnterPermissionSettingUtils.enterPermissionSettingPage(context);
            }
        });
    }
}
