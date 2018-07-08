fun checkInput (data: String) : String? {
if(data == "Web")
  return "Web development"
return null
}
var response = checkInput ("iOS")
println(response)
response ?.let {
   println("got non null value")
} ?: run {
    println("got null")
}
