package online.heyworld.kt.easy

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject

import http

class EasyCodeManifest {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

            println(http.get("https://www.heyworld.online"))

//            val json = JSON.parseObject(EasyCodeManifest::class.java.getResourceAsStream("/user_draw_data_draft_1628159256785").bufferedReader().readText())
//            val render_element_list = json.getJSONArray("render_element_list")
//            val renderTrans = json.getJSONObject("render_extra_info").getJSONArray("render_element_transform_list")
//            val virtualSegList = mutableListOf<JSONObject>()
//            for (i in render_element_list.indices){
//                val seg = render_element_list.getJSONObject(i)
//                virtualSegList.add(seg)
//                if(i<render_element_list.lastIndex){
//                    val trans = renderTrans.getJSONObject(i)
//                    if(trans.containsKey("seg")){
//                        virtualSegList.add(trans.getJSONObject("seg"))
//                    }
//                }
//            }
//
//            var segSumTime = 0
//            virtualSegList.forEachIndexed { index, jsonObject ->
//                val t = jsonObject.getIntValue("end_time") - jsonObject.getIntValue("start_time")
//                segSumTime+=t
//                println("#$index\t$t\t${timeStr(segSumTime)}\t${segSumTime}\t frameCount:${t/1000*30}")
//            }
        }

        private fun timeStr(t:Int):String{
            return String.format("%03d:%02d:%04d",(t/1000)/60,(t/1000)%60,t%1000)
        }

    }
}