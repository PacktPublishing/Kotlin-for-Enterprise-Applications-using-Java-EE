
fun findMaxNumber(vararg numbers : Int) =
    numbers.reduce { max , e -> if(max > e) max else e }

val numberArray = intArrayOf(25,50,75,100)
println(findMaxNumber(4,5,*numberArray,200, 10))
