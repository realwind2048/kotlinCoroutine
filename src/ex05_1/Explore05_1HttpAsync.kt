package ex05_1

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

fun main(args: Array<String>) {
    val tickers = listOf("google", "samsung", "buzzvil")
    GlobalScope.launch {
        measureTime {
            val prices = mutableListOf<Deferred<String>>()

            for(ticker in tickers) {
                prices += async {"price for $ticker is ${getStockPrice(ticker)}" }
            }

            for(price in prices) {
                println(price.await())
            }
        }
    }

    sleep(5000L)
}

fun getStockPrice(ticker: String): String {
    sleep(1000L)
    return "123"
}

suspend fun measureTime(block: suspend () -> Unit) {
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println("${(end - start)/1.0e9} seconds")
}

