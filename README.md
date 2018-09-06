# Utils
**工具类**
[![](https://jitpack.io/v/UamaHZ/Utils.svg)](https://jitpack.io/#UamaHZ/Utils)

## [apptype/AppUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/apptype/AppUtils.java)
* ### `getAppVersionCode(Context context)`获取app code 号
* ### `getVersionName(Context context)`： 获取app name 号(用户看到的版本号）


## [arraytype/ListUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/arraytype/ListUtils.java)
* ### `hasData(List list)`: 判断List不为null,同时size!=0
* ### `isEmpty(List list)`: 判断List是否为空


## [common/ToastUtil](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/common/ToastUtil.java)
* ### `show(Context context,String info)`:  显示自定义Toast
* ### `show(Context context,@StringRes int info)`: 显示自定义Toast


## [datatype/AssetUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/datatype/AssetUtils.java)
* ### `getFromAssets(Context c, String fileName)`: 从assets中获取Json字符串


## [datatype/CalculateUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/datatype/CalculateUtils.java)
* ### `add(double v1,double v2)`: 精确的加法运算
* ### `sub(double v1,double v2)`: 精确的减法运算
* ### `mul(double v1,double v2)`: 精确的乘法运算

## [datatype/MoneyUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/datatype/MoneyUtils.java)
* ### `withMoney(String money)`: 获取一个普通的带金额 符号的
* ### `withMoney(double money)`: 获取一个普通的带金额 符号的，保留两位小数
* ### `withSpaceMoney(String money)`: 获取一个普通的带金额 符号的,金额和符号之间有空格
* ### `withSpaceMoney(double money)`: 获取一个普通的带金额 符号的,金额和符号之间有空格，保留两位小数
* ### `withSpaceMoney(String money)`: 获取一个普通的带金额 符号的,金额和符号之间有空格
* ### `withSpaceMoney(double money)`: 获取一个普通的带金额 符号的,金额和符号之间有空格，保留两位小数
* ### `getPriceStyle(Double text, String unit)`: 显示不同大小的字符串


## [datatype/StringUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/datatype/StringUtils.java)
* ### `newString(String source)`: 创建一个非空的字符串
* ### `concatString(String... params)`: 拼接字符串
* ### `stringToDouble(String str)`: String 转 Double
* ### `doubleToString(Double dou)`: 处理double类型，保留两位小数
* ### `StringToInt(String data)`: 字符串 转整形
* ### `setMiddleFlag(TextView textView)`: 在TextView设置中划线
* ### `setBottomFlag(TextView textView)`: 在TextView设置下划线
* ### `cancelMiddleFlag(TextView textView)`: 取消中划线


## [datatype/UrlUtils](https://github.com/UamaHZ/Utils/blob/master/uamautils/src/main/java/com/lvman/uamautil/datatype/UrlUtils.java)
* ### `getUrl(String baseUrl, HashMap<String, String> params)`: 拼接url参数
