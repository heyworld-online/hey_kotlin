package online.heyworld.kt.easy.test

import com.alibaba.fastjson.JSON
import com.inveno.android.page.stage.util.StringUtil
import online.heyworld.kt.easy.test.bean.LogItem
import online.heyworld.kt.easy.test.bean.LogItemInApp
import online.heyworld.kt.easy.test.util.Rect
import online.heyworld.kt.easy.test.util.Size
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

class TestMain {
    companion object {

        private val logger: Logger = LoggerFactory.getLogger(TestMain::class.java)

        private fun computeForegroundVideoMergeSize(fg_size: Size, fg_video_rect: Rect): Size {
            var finalFgWidth = fg_size.width
            var finalFgHeight = fg_size.height
            if (finalFgWidth > fg_video_rect.width()) {
                finalFgHeight = (finalFgHeight * (fg_video_rect.width().toFloat() / finalFgWidth)).toInt()
                finalFgWidth = fg_video_rect.width()
            }

            if (finalFgHeight > fg_video_rect.height()) {
                finalFgWidth = (finalFgWidth * (fg_video_rect.height().toFloat() / finalFgHeight)).toInt()
                finalFgHeight = fg_video_rect.height()
            }
            return Size(finalFgWidth, finalFgHeight)
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val text = TestMain::class.java.getResource("/exception_0621.json").readText()
            val recordArray = JSON.parseObject(text).getJSONArray("RECORDS")
            val errorList = mutableListOf<LogItemInApp>()
            var oomCount = 0
            for (i in 0 until recordArray.size) {
                val item = recordArray.getJSONObject(i)
                val itemObj = item.toJavaObject(LogItem::class.java)
                val logItemInApp = LogItemInApp(itemObj)
                logItemInApp.parseException()
                val version = logItemInApp.bodyJSON.getString("version")
                if (logItemInApp.expection.contains("oom", true)) {
                    oomCount++
                    logger.info("found oom count:$oomCount")
                } else if (logItemInApp.expection.contains("PiecesFFmpegException", true)
                        || logItemInApp.expection.contains("OutOfM", true)
//                        || logItemInApp.expection.contains("VirtualWorldActivity", true)
                        || logItemInApp.expection.contains("TypedArray.getColorStateList", true)
                        || logItemInApp.expection.contains("DrawOrderTimeline", true)
                        || logItemInApp.expection.contains("ijkplayer", true)
                        || logItemInApp.expection.contains("mActivityProvider has not been initialized", true)
                        || logItemInApp.expection.contains("Design assumption violated", true)
                        || version.contains(".d")
                ) else if(logItemInApp.expection.contains("VirtualWorldActivity", true)){
                    if(logItemInApp.expection.contains("ConcurrentModificationException")){

                    }else{
                        errorList.add(logItemInApp)
                        File("exception_list\\exception_${itemObj.id}.text").writeText(
                                logItemInApp.expection
                        )
                    }

                } else {
//                    errorList.add(logItemInApp)
////                    File("exception_list\\${itemObj.id}.json").let {
////                        if (!it.exists()) {
////                            it.createNewFile()
////                        }
////                        it.writeText(
////                                JSON.toJSONString(logItemInApp,true)
////                        )
////                    }
//
//                    File("exception_list\\exception_${itemObj.id}.text").writeText(
//                            logItemInApp.expection
//                    )
                }
            }
            println("error count:${errorList.size}")
        }
    }
}