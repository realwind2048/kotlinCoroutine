package ex01

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val number = 1_000_000
    threads(number)
//    ex01.coroutines(number)
}

fun threads(n: Int) {
    val threads = List(n) {
        thread {
            sleep(3000L)
            println(it)
        }
    }
    threads.forEach { it.join() }
}

fun coroutines(n: Int) = runBlocking {
    val jobs = List(n) {
        async {
            delay(3000L)
            println(it)
        }
    }
    jobs.forEach { it.join() }
}