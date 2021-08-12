package online.heyworld.kt.easy.test.bean

import com.alibaba.fastjson.JSON
import java.util.*

class LogItem {
    var id = ""
    var body = "{}"
    var time = ""
    var user_agent = ""
    var user_ip = ""
}


class LogItemInApp(val logItem: LogItem) {
    var expection = ""
    var bodyJSON = JSON.parseObject(logItem.body)
    fun parseException() {
        expection = String(Base64.getDecoder().decode(
                bodyJSON.getString("stack_trace")
        ))
    }
}