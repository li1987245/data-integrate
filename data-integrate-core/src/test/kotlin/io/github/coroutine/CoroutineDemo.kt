package io.github.coroutine

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlin.concurrent.thread

/**
 * @Author: jinwei.li@100credit.com
 * @Date: 2018/8/30 9:23
 */
fun main(args: Array<String>) {
//    launch { // launch new coroutine in background and continue
//        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
//        println("World!") // print after delay
//    }
    thread {
        Thread.sleep(1000L)
        println("World!")
    }
    println("Hello,") // main thread continues while coroutine is delayed
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
}
