package ex04_1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

val ticker = "google"
fun main(args: Array<String>) {
    GlobalScope.launch {
        try {
            val stockPrice = getStockPrice(ticker)

            try {
                val ipAddress = getCallerIp()

                println("$ticker = $stockPrice and ip address = $ipAddress")
            } catch (e: Exception) {
                println("error getting ip address")
            }
        } catch (e: Exception) {
            println("error getting stock price")
        }
    }
    println("ex06.request sent")
    sleep(3000)
}

suspend fun getStockPrice(ticker: String): String {
    return "123"
}

suspend fun getCallerIp(): String {
    return java.net.URL("https://api.ipify.org").readText()
}