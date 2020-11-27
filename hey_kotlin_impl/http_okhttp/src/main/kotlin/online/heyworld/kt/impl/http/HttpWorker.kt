package online.heyworld.kt.impl.http

import online.heyworld.kt.impl.http.okhttp.OkHttpUtil
import online.heyworld.kt.core.net.HttpContract
import java.io.InputStream

class HttpWorker : HttpContract {
    override fun get(url: String): String? {
        return OkHttpUtil.getBody(url)?.string()
    }

    override fun getByteArray(url: String): ByteArray? {
        return OkHttpUtil.getBody(url)?.bytes()
    }

    override fun getStream(url: String): InputStream? {
        return OkHttpUtil.getBody(url)?.byteStream()
    }
}