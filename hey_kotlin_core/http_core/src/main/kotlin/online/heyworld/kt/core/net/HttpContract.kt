package online.heyworld.kt.core.net

import java.io.InputStream

interface HttpContract {
    fun get(url:String):String?

    fun getByteArray(url: String):ByteArray?

    fun getStream(url: String):InputStream?
}