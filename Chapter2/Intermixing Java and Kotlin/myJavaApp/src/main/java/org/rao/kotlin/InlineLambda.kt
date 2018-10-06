package org.rao.kotlin
object InlineLambda {
    val greetingLambda = { println("Greet from inline lambda") }
    @JvmStatic
    fun main(args: Array<String>) {
        greetingLambda()
    }
}



