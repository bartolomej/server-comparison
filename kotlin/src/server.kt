import com.sun.net.httpserver.HttpServer
import java.io.PrintWriter
import java.net.InetSocketAddress

val port = 8003;

fun main(args: Array<String>) {
    HttpServer.create(InetSocketAddress(port), 0).apply {
        println("Kotlin server started on port $port")
        createContext("/") { http ->
            http.responseHeaders.add("Content-type", "text/plain")
            http.sendResponseHeaders(200, 0)
            PrintWriter(http.responseBody).use { out ->
                val path = http.requestURI.path.substring(1)
                out.println(arrayToString(fib(path.toInt())))
            }
        }
        start()
    }
}

fun arrayToString (array: IntArray): String {
    var result = ""
    for ((index, value) in array.withIndex()) {
        result += "$index: $value\n"
    }
    return result
}

fun fib (max: Int): IntArray {
    val sequence = IntArray(max)
    sequence[0] = 0
    sequence[1] = 1
    for (i in 2 until sequence.size) {
        sequence[i] = sequence[i - 1] + sequence[i - 2]
    }
    return sequence
}