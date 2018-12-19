package ex05

import java.lang.Thread.sleep

fun main(args: Array<String>) {

    val tickers = listOf("google", "samsung", "buzzvil")
    measureTime {
        val prices = mutableListOf<String>()

        for (ticker in tickers) {
            prices += "price for $ticker is ${getStockPrice(ticker)}";
        }

        for (price in prices) {
            println(price)
        }
    }
}

fun getStockPrice(ticker: String): String {
    sleep(1000L)
    return "123"
}

fun measureTime(block: () -> Unit) {
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    println("${(end - start) / 1.0e9} seconds")
}

