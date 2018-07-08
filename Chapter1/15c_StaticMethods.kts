class Person {
    companion object Util {
      fun foo(){
      println("Static method foo() is invoked")
      }
  }
}
Person.Util.foo()
