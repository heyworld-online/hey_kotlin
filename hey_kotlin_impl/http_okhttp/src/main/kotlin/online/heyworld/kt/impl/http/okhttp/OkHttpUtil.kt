package online.heyworld.kt.impl.http.okhttp

import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.ResponseBody
import java.io.File

class OkHttpUtil {
    companion object {
        fun downloadFile(url: String, dir: String, fileName: String) {
            val okhttp = OkHttpClient.Builder().build()
            val requestBody = Request.Builder()
                .url(url)
                .get()
                .build()
            val body = okhttp.newCall(requestBody).execute().body
            body?.let {
                it.byteStream().copyTo(File(File(dir), fileName).outputStream())
            }
        }

        fun getString(url: String):String{
            val okhttp = OkHttpClient.Builder().build()
            val requestBody = Request.Builder()
                .url(url)
                .get()
                .build()
            val body = okhttp.newCall(requestBody).execute().body
            return body?.string()?:""
        }

        fun getBody(url: String):ResponseBody?{
            val okhttp = OkHttpClient.Builder().build()
            val requestBody = Request.Builder()
                    .url(url)
                    .get()
                    .build()
            return okhttp.newCall(requestBody).execute().body
        }

        fun uploadFile(url: String, params: Map<String, String>, file: File): String {
            val okhttp = OkHttpClient.Builder().build()

            val requestBodyBuilder = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.name, file.asRequestBody())
            params.forEach { t, u ->
                requestBodyBuilder.addFormDataPart(t, u)
            }
            val requestBody = Request.Builder()
                .url(url)
                .post(requestBodyBuilder.build())
                .build()
            val body = okhttp.newCall(requestBody).execute().body
            body?.let {
                return it.string()
            }
            return "{}"
        }
    }
}