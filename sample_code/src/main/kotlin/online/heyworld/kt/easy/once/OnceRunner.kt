package online.heyworld.kt.easy.once

import org.jaudiotagger.audio.mp3.MP3FileReader
import java.io.File
import java.io.OutputStream


class OnceRunner {

    fun mp3(){
        val path = Any().javaClass.getResource("/audio_list.txt").readText()
//    path.split("\n").forEachIndexed { index, s ->
//        println("$index\t$s")
//        if(s.isNotEmpty()){
//            Runtime.getRuntime().exec(
//                    "adb pull $s data\\audio\\${String.format("%04d",index)}.mp3"
//            )
//        }
//    }

        val audioRootFile = File("data\\\\audio")
        audioRootFile.listFiles().forEach {
            val reader = MP3FileReader()
            val audioFile = reader.read(it)
            println("${it.name}:\t${audioFile.audioHeader.trackLength}")
        }
    }
}

class CodeRunner(private val code:String,private val out: OutputStream){

    fun run(){
        val ktFile = File("temp.kt")
        ktFile.createNewFile()
        ktFile.writeText(code)
        Runtime.getRuntime().exec("kotlinc ${ktFile.absolutePath}").let {
            do {
                val byteData = it.inputStream.read()
                out.write(byteData)
            }while (true)
        }
    }
}

fun main() {
    CodeRunner("\n" +
            "    print(123)\"\")\n" +
            "",System.out).run()
}