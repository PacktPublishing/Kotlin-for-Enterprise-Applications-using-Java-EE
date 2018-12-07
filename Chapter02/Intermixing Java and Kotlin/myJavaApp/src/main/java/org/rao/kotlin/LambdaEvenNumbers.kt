package org.rao.kotlin

object LambdaEvenNumbers {
   // val greetingLambda = { println(" dsfsd Greet from inline lambda") }
    @JvmStatic
    fun main(args: Array<String>) {
        listOf(0,1,2,3,4,5,6,7,8,9)
                .filter{ e -> e % 2 == 0}
                .forEach{ e -> println(e)}
    }
}



