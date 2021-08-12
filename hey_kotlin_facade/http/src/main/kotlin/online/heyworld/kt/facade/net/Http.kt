package online.heyworld.kt.facade.net

import online.heyworld.kt.core.net.HttpContract
import java.io.InputStream

object Http : HttpContract {
    private const val IMPL_CLASS_NAME = "online.heyworld.kt.impl.http.HttpWorker"

    var httpContract : HttpContract? = null

    init {
        val instance = Class.forName(IMPL_CLASS_NAME).newInstance()
        if(instance is HttpContract){
            httpContract = instance
        }
    }

    override fun get(url: String): String? {
        return httpContract?.get(url)
    }

    override fun getByteArray(url: String): ByteArray? {
        return httpContract?.getByteArray(url)
    }

    override fun getStream(url: String): InputStream? {
        return httpContract?.getStream(url)
    }
}