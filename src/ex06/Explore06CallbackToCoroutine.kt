package ex06

import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class CallbackService(val name: String) {
    class Response(val from: CallbackService, val message: String)

    fun request(from: String, callback: (Response) -> Unit) {
        callback(Response(this, "Hi $from! -- Yours, $name"))
    }
}

fun main(args: Array<String>) {
    val s1 = CallbackService("1")
    val s2 = CallbackService("2")

    s1.request(s2.name) { r1 ->
        println(r1.message)

        s2.request(s1.name) { r2 ->
            println(r2.message)
        }
    }









//
//    runBlocking {
//        val r1 = s1.ex06.request(s2.name)
//        println(r1.message)
//        val r2 = s2.ex06.request(s1.name)
//        println(r2.message)
//    }
}

suspend fun CallbackService.request(from: String) =
    suspendCoroutine<CallbackService.Response> { continuation ->
        request(from) { response ->
            continuation.resume(response)
        }
    }

//suspend fun CallbackService.request(from: String) =
//    suspendCoroutine<CallbackService.Response> { continuation ->
//        try {
//            request(from) { response ->
//                continuation.resume(response)
//            }
//        } catch (e: Exception) {
//            continuation.resumeWithException(e)
//        }
//
//    }

