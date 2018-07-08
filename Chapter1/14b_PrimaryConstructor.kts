class User(var firstName: String, val id: String) {

}
val user = User("Norman", "myId")
println("First Name = ${user.firstName}")
println("User Id = ${user.id}")
