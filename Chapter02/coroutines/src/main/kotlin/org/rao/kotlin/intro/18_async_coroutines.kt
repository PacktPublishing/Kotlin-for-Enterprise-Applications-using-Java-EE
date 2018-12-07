package org.rao.kotlin.intro

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>) {
    println("Inside main")

    launch(CommonPool) {
        val deferred = (1..1_000_000)
                .map { n -> async { n }
        }
        var sum = deferred.sumBy { it.await() }
        println("sum ----- " + sum)
    }
    Thread.sleep(4000)
}
