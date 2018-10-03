import java.util.*

object HelloWorld {
    internal fun foo() {
        val userList = ArrayList<Any>()

    }


    @JvmStatic
    fun main(args: Array<String>) {

        val obj = Any()

        val name: String = "test"
        System.gc()
        Runtime.getRuntime().gc()
        foo()
    }
}


