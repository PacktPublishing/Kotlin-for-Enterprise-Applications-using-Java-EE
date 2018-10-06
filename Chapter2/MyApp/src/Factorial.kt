fun main(args: Array<String>) {

    val number = 5
    var factorial: Int = 1
    for (i in 1..number) {
        factorial *= i
    }
    println("Factorial of $number = $factorial")
}
