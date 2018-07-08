val name = "Atrium"
val message = """This is an example of
  ^multiline String $name
"""
println(message.trimMargin("^"))
