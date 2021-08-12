package online.heyworld.kt.easy.http

import online.heyworld.kt.facade.net.Http

class HttpLauncher {
    companion object{
        fun main(){
            println(Http.get("https://heyworld.online/ip/mine"))
            println(Http.get("https://heyworld.online/ping"))
            println(Http.get("https://heyworld.online/ping"))
            println(Http.get("https://heyworld.online/ping"))
            println(Http.get("https://heyworld.online/ping"))
            println(Http.get("https://heyworld.online/ping"))
            println(Http.get("https://heyworld.online/ping"))
            println(Http.get("https://heyworld.online/ping"))
        }
    }
}

fun main(){
    HttpLauncher.main()
}