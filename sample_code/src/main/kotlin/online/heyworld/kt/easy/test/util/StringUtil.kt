package com.inveno.android.page.stage.util

import java.lang.StringBuilder

object StringUtil {
    // 句号（ 。）、问号（ ？）、叹号（ ！）、逗号（ ，）顿号（、）、分号（；）和冒号（：）
    private val splitSignSet = mutableSetOf(
        '.','。',
        '?','？',
        '!','！',
        ',','，',
        '、',
        ';','；',
        ':','：'

    )
    fun toLinesString(text:String):String{
        val builder = StringBuilder()
        val charArray = text.toCharArray()
        for(i in charArray.indices){
            val charItem = charArray[i]
            if(i == charArray.lastIndex){
                if(splitSignSet.contains(charItem)){

                }else{
                    builder.append(charItem)
                }
            }else{
                if(splitSignSet.contains(charItem)){
                    builder.append('\n')
                }else{
                    builder.append(charItem)
                }
            }
        }
        return builder.toString()
    }
}