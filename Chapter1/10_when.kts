fun processInput(input: Any) {
  when(input) {
  10 -> println("It is 10")
  98,99 -> println("It is 98 or 99")
  in 101 .. 120 -> println("More than 100")
  is String -> println("This is ${input} of length ${input.length}")
  else -> println("Not known")
  }
}
processInput(10)
processInput(98)
processInput(99)
processInput(102)
processInput("hey there")
processInput(Thread())
