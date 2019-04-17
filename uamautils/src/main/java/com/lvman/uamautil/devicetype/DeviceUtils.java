package com.lvman.uamautil.devicetype;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by GuJiaJia on 2018/8/3.
 * E-mail 965939858@qq.com
 * Tel: 15050261230
 */
public class DeviceUtils {

    //获取屏幕高度
    public static int getDisplayHeight(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getApplicationContext().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    //获取屏幕宽度
    public static int getDisplayWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getApplicationContext().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    //判断是否安装了应用
    public static boolean checkApkExist(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName))
            return false;
        try {
            ApplicationInfo info = context.getPackageManager()
                    .getApplicationInfo(packageName,
                            PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public interface CopyClipListener {
        void success();

        void fail();
    }

    //复制文字到系统粘贴板
    public static void copyToClipBoard(Context context, String content, CopyClipListener clipListener) {
        ClipboardManager myClipboard;
        myClipboard = (ClipboardManager) (context.getSystemService(Context.CLIPBOARD_SERVICE));
        if (myClipboard == null) {
            if (clipListener != null) {
                clipListener.fail();
            }
            return;
        }
        ClipData myClip;
        myClip = ClipData.newPlainText("text", content);
        myClipboard.setPrimaryClip(myClip);
        if (clipListener != null) {
            clipListener.success();
        }
    }

    /**
     * 获取手机状态栏高度
     *
     * @return 像素值
     */
    public static int getStatusBarHeight(Activity mActivity) {
        if (mActivity == null) {
            return 0;
        }
        Resources resources = mActivity.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

    //强制打开键盘
    public static void openKeyboardForce(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    //关闭键盘
    public static void closeKeyBoard(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }
        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }

    //关闭键盘
    public static void closeKeyBoard(Activity activity) {
        if (activity != null && activity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputMethodManager == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    //获取设备id
    public static String getDeviceId(Context context) {
       return getDeviceUniqueId(context);
    }

    /**
     * 检查网络是否连通
     *
     * @return boolean
     * @since V1.0
     */
    public static boolean isNetworkAvailable(Context context) {
        // 创建并初始化连接对象
        ConnectivityManager connMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // 判断初始化是否成功并作出相应处理
        if (connMan != null) {
            // 调用getActiveNetworkInfo方法创建对象,如果不为空则表明网络连通，否则没连通
            NetworkInfo info = connMan.getActiveNetworkInfo();
            if (info != null) {
                return info.isAvailable();
            }
        }
        return false;
    }

    //获取设备唯一id标识
    public static String getDeviceUniqueId(Context context){
        String serial = null;
        String m_szDevIDShort = "35" +
                Build.BOARD.length()%10+ Build.BRAND.length()%10 +

                Build.CPU_ABI.length()%10 + Build.DEVICE.length()%10 +

                Build.DISPLAY.length()%10 + Build.HOST.length()%10 +

                Build.ID.length()%10 + Build.MANUFACTURER.length()%10 +

                Build.MODEL.length()%10 + Build.PRODUCT.length()%10 +

                Build.TAGS.length()%10 + Build.TYPE.length()%10 +

                Build.USER.length()%10 ; //13 位

        try {
            serial = Build.SERIAL;
            //API>=9 使用serial号
            return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
        } catch (Exception exception) {
            //serial需要一个初始化
            serial = "serial"; // 随便一个初始化
        }
        //使用硬件信息拼凑出来的15位号码
        return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
    }

    public static float getDensity(Context cx) {
        DisplayMetrics dm = cx.getApplicationContext().getResources().getDisplayMetrics();
        return dm.density;
    }
}
