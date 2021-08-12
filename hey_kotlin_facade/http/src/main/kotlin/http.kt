import online.heyworld.kt.facade.net.Http
import java.io.InputStream

object http {
    fun get(url: String): String? {
        return Http.httpContract?.get(url)
    }

    fun getByteArray(url: String): ByteArray? {
        return Http.httpContract?.getByteArray(url)
    }

    fun getStream(url: String): InputStream? {
        return Http.httpContract?.getStream(url)
    }
}