class MemoryLeakDemo(val key: String) {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            try {
                val map = HashMap<MemoryLeakDemo, String>()

                while (true) {
                map.put(MemoryLeakDemo("myKey"), "testValue")

                    println("Element added to map")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
