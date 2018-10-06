package org.rao.kotlin
object NullabilityTest {
    @JvmStatic
    fun main(args: Array<String>) {
        var userList:ArrayList<String> ? = null
        var user = userList?.get(0)

        user ?.let {
            println("got the details of user")
        } ?: run {
            println("there is no user")
        }
    }
}



