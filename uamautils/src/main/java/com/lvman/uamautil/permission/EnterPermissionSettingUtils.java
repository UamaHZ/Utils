package com.lvman.uamautil.permission;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * Created by GuJiaJia on 2018/11/7.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class EnterPermissionSettingUtils {

    public static void enterPermissionSettingPage(Context context) {
//        gotoMIUIPermission(context);
        gotoAppDetailSettingIntent(context);
    }


    //小米的适配 MI UI 8.5,顺序第一个
    private static void gotoMIUIPermission(Context context) {
        try {
            Intent i = new Intent("miui.intent.action.APP_PERM_EDITOR_PRIVATE");
            ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            i.setComponent(componentName);
            i.putExtra("extra_pkgname", context.getPackageName());
            context.startActivity(i);
        } catch (Exception e) {
            Log.i("ailee", "MiUI-e:" + e.getMessage());
            gotoHuaWeiPermission(context);
        }
    }

    /**
     * 华为的权限管理页面
     */
    private static void gotoHuaWeiPermission(Context context) {
        try {
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");//华为权限管理
            intent.setComponent(comp);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.i("ailee", "HuaWei-e:" + e.getMessage());
            gotoNSUSPermission(context);
        }
    }

    /**
     * 华硕的权限管理页面
     */
    private static void gotoNSUSPermission(Context context) {
        try {
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName comp = new ComponentName("com.mediatek.security", "com.mediatek.security.ui.PermissionControlPageActivity");//华为权限管理
            intent.setComponent(comp);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.i("ailee", "NSUS-e:" + e.getMessage());
            gotoMeiZuPermission(context);
        }
    }

    /**
     * 魅族权限管理页面
     */
    private static void gotoMeiZuPermission(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("packageName", context.getPackageName());
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            Log.i("ailee", "NSUS-e:" + e.getMessage());
            gotoAppDetailSettingIntent(context);
        }
    }

    //跳到APP设置页面
    private static void gotoAppDetailSettingIntent(Context context) {
        try {
            Intent localIntent = new Intent();
            localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", context.getPackageName(), null));
            context.startActivity(localIntent);
        } catch (Exception e) {
            Log.i("ailee", "AppDetail-e:" + e.getMessage());
        }
    }
}
