package ex02

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

fun process(n: Int): Int {
    println("ex02.process: " + Thread.currentThread())
    return n
}

fun main(args: Array<String>) {
    println(Thread.currentThread())

    println(process(2))

//    GlobalScope.launch {
//        println(process(2))
//    }

    sleep(1000)
}
