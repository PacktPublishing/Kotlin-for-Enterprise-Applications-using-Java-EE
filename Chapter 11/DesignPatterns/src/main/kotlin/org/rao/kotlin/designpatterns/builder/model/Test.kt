package org.rao.kotlin.designpatterns.builder.model

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        /*var person = Person("Jane", "", "", "jane@test.org", 21, "4561298421", "10, Charles " +
                "Street,NY")*/
        var person = PersonBuilder()
                        .withFirstName("Jane")
                        .withLoginId("jane@test.org")
                        .withContactNumber("4561298421")
                        .build();
    }
}
