# Utils [![](https://jitpack.io/v/UamaHZ/Utils.svg)](https://jitpack.io/#UamaHZ/Utils)

## [apptype/AppUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/apptype/AppUtils.java)
> `getAppVersionCode(Context context)`获取app code 号

> `getVersionName(Context context)`： 获取app name 号(用户看到的版本号）



## [arraytype/ListUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/arraytype/ListUtils.java)
> `hasData(List list)`: 判断List不为null,同时size!=0

> `isEmpty(List list)`: 判断List是否为空



## [common/ToastUtil](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/common/ToastUtil.java)
> `show(Context context,String info)`:  显示自定义Toast

> `show(Context context,@StringRes int info)`: 显示自定义Toast



## [datatype/AssetUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/datatype/AssetUtils.java)
> `getFromAssets(Context c, String fileName)`: 从assets中获取Json字符串



## [datatype/CalculateUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/datatype/CalculateUtils.java)
> `add(double v1,double v2)`: 精确的加法运算

> `sub(double v1,double v2)`: 精确的减法运算

> `mul(double v1,double v2)`: 精确的乘法运算



## [datatype/MoneyUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/datatype/MoneyUtils.java)
> `withMoney(String money)`: 获取一个普通的带金额 符号的

> `withMoney(double money)`: 获取一个普通的带金额 符号的，保留两位小数

> `withSpaceMoney(String money)`: 获取一个普通的带金额 符号的,金额和符号之间有空格

> `withSpaceMoney(double money)`: 获取一个普通的带金额 符号的,金额和符号之间有空格，保留两位小数

> `withSpaceMoney(String money)`: 获取一个普通的带金额 符号的,金额和符号之间有空格

> `withSpaceMoney(double money)`: 获取一个普通的带金额 符号的,金额和符号之间有空格，保留两位小数

> `getPriceStyle(Double text, String unit)`: 显示不同大小的字符串



## [datatype/StringUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/datatype/StringUtils.java)
> `newString(String source)`: 创建一个非空的字符串

> `concatString(String... params)`: 拼接字符串

> `stringToDouble(String str)`: String 转 Double

> `doubleToString(Double dou)`: 处理double类型，保留两位小数

> `StringToInt(String data)`: 字符串 转整形

> `setMiddleFlag(TextView textView)`: 在TextView设置中划线

> `setBottomFlag(TextView textView)`: 在TextView设置下划线

> `cancelMiddleFlag(TextView textView)`: 取消中划线



## [datatype/UrlUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/datatype/UrlUtils.java)
> `getUrl(String baseUrl, HashMap<String, String> params)`: 拼接url参数



## [devicetype/DeviceUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/devicetype/DeviceUtils.java)
> `getDisplayHeight(Context context)`: 获取屏幕高度

> `getDisplayWidth(Context context)`:  获取屏幕宽度

> `checkApkExist(Context context, String packageName)`: 判断是否安装了应用

> `copyToClipBoard(Context context, String content, CopyClipListener clipListener)`: 复制文字到系统粘贴板

> `getStatusBarHeight(Activity mActivity)`: 获取手机状态栏高度

> `openKeyboardForce(EditText mEditText, Context mContext)`: 强制打开键盘

> `closeKeyBoard(EditText mEditText, Context mContext)`: 关闭键盘

> `closeKeyBoard(Activity activity)`: 关闭键盘

> `getDeviceId(Context context)`: 获取设备id

> `isNetworkAvailable(Context context)`: 检查网络是否连通



## [devicetype/ImageUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/devicetype/ImageUtils.java)
> `readPictureDegree(String path)`: 读取照片exif信息中的旋转角度



## [devicetype/MD5Utils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/devicetype/MD5Utils.java)
> `md5(String strMd5)`: md5加密

> `byte2hex(byte[] b)`: 二行制转字符串


## [devicetype/StorageUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/devicetype/StorageUtils.java)
> `isSDCardOK()`: 判断SD卡是否可用

> `getSDCardRootPath()`: 获取SD卡跟路径。SD卡不可用时，返回null

> `isFileExist(String directorPath)`: 判断文件是否存在:部分路径

> `isFileExistByAbsolute(String absolutePath)`: 判断文件是否存在:全路径

> `createFilePackage(String directorPath)`: 创建文件夹 提示，6.0以上要手动获取存储权限



## [timetype/DateUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/timetype/DateUtils.java)
> `calendar2String(Calendar calendar, String patternType)`: Calendar转String

> `longTimeToString(long time,String patternType)`: 时间磋转String



## [timetype/TimeUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/timetype/TimeUtils.java)
> `getSystemTime()`: Calendar转String

> `getTimeDifference(String timeType, String startTime, String endTime)`: 获取时间差，默认单位是秒



## [unittype/GpsUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/unittype/GpsUtils.java)
> `gcj02_To_Bd09(double lat, double lon)`: 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 将 GCJ-02 坐标转换成 BD-09 坐标

> `bd09_To_Gcj02(double lat, double lon)`: 火星坐标系 (GCJ-02) 与百度坐标系 (BD-09) 的转换算法 * * 将 BD-09 坐标转换成GCJ-02 坐标

> `openAMap(Context mContext, String mLat, String mlon, String pointName, String appName)`: 打开高德地图

> `openBDMap(Context mContext, String location, String title)`: 打开百度地图

> `getBDLocation(String lat, String lon)`: 获取百度地图location



## [unittype/PixelUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/unittype/PixelUtils.java)
> `dp2px(Context context, float dpValue)`: 根据手机的分辨率从 dp 的单位 转成为 px(像素)

> `px2dp(Context context, float pxValue)`: 根据手机的分辨率从 px(像素) 的单位 转成为 dp

> `sp2px(Context context, float spVal)`: sp转px

> `px2sp(Context context, float pxVal)`: px转sp

