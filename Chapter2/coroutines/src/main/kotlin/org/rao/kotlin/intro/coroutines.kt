package org.rao.kotlin.intro

import kotlinx.coroutines.experimental.launch

fun main(args: Array<String>){
    println("Inside main")


    launch{
        println("Coroutine in execution")
    }

    Thread.sleep(2000)
    println("main completed")
}

