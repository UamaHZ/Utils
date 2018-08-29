package com.lvman.uamautil.datatype

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText
import java.util.regex.Pattern
import java.util.regex.PatternSyntaxException

/**
 * Created by guozhen.hou on 2018/6/25.
 * 正则辅助类
 */
private val phonePatterns: Pattern = Pattern.compile("^[1][0-9]{10}$")
//身份证正则：首6位0-9数字，中间年按1900-2199取值，月00-12 日按00-29&30&31 然后3位0-9数字，以及末尾-位0-9\X结尾
private val cardNumberPatterns: Pattern = Pattern.compile("^[0-9]{6}([1][9][0-9]{2}|[2][0-1][0-9]{2})([0][1-9]|[1][0-2])([0-2][0-9]|[3][0-1])[0-9]{3}([0-9]|[X])$")
//姓名正则
private val namePattern: Pattern = Pattern.compile("[^a-zA-Z0-9\u4E00-\u9FA5]")

const val TYPE_CA_NUMBER_EG = "chinese_number_english"//允许中英文，数字
const val TYPE_NUMBER = "number"//允许中英文
const val TYPE_NUMBER_X = "number_X"//允许英文数字

fun isRealPhone(str:String):Boolean{
   return !TextUtils.isEmpty(str)&&phonePatterns.matcher(str).matches()
}

fun isRealIdCard(str:String):Boolean{
    return !TextUtils.isEmpty(str)&&cardNumberPatterns.matcher(str).matches()
}

/**
 * @throws PatternSyntaxException
 */
fun stringFilter(str: String, p: Pattern): String {
    // 只允许字母、数字和汉字
    val m = p.matcher(str)
    return m.replaceAll("").trim { it <= ' ' }
}
/**
 * 用于输入时过滤不符合规则的字符
 *
 * @param editText 编辑框
 * @param type     正则类型
 */
fun setFilter(editText: EditText, type: String) {
    if (TextUtils.isEmpty(type)) return
    editText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val editable = editText.text.toString()//获取编辑框文案
            var str = editable//用str表示正则过滤后文案
            try {
                if (TYPE_CA_NUMBER_EG.equals(type, ignoreCase = true)) {//中英文数字支持，过滤
                    str = stringFilter(editable, namePattern)
                } else if (TYPE_NUMBER.equals(type, ignoreCase = true)) {//中英文支持，过滤
                    str = stringFilter(editable, Pattern.compile("[^0-9]"))
                } else if (TYPE_NUMBER_X.equals(type, ignoreCase = true)) {//英文数字过滤
                    str = stringFilter(editable, Pattern.compile("[^0-9X]"))
                }
                if (editable != str) {
                    editText.setText(str)
                    //设置新的光标所在位置
                    editText.setSelection(str.length)
                }
            } catch (p: PatternSyntaxException) {
                p.message
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        override fun afterTextChanged(s: Editable) {}
    })

}