
fun findMaxNumber(vararg numbers : Int) =
    numbers.reduce { max , e -> if(max > e) max else e }

val numberArray = intArrayOf(25,50,75,100)
println(findMaxNumber(*numberArray))
