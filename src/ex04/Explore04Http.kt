package ex04

val ticker = "google"
fun main(args: Array<String>) {
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

fun getStockPrice(ticker: String): String {
    return "123"
}

fun getCallerIp(): String {
    return java.net.URL("https://api.ipify.org").readText()
}