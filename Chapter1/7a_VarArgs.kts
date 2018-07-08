
fun findMaxNumber(vararg numbers : Int) =
    numbers.reduce { max , e -> if(max > e) max else e }

println(findMaxNumber(1,2,3,4))
