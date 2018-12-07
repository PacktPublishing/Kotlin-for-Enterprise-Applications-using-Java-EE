package org.rao.kotlin.designpatterns.builder.model

class PersonBuilder {
    var firstName: String? = null
    var lastName: String? = null
    var middleName: String? = null
    var loginId: String? = null
    var age: Int? = null
    var contactNumber: String? = null
    var address: String? = null

    fun withFirstName(firstName: String): PersonBuilder {

        this.firstName = firstName
        return this
    }

    fun withLastName(lastName: String): PersonBuilder {

        this.lastName = lastName
        return this
    }

    fun withMiddleName(middleName: String): PersonBuilder {

        this.middleName = middleName
        return this
    }

    fun withLoginId(loginId: String): PersonBuilder {

        this.loginId = loginId
        return this
    }

    fun withAge(age: Int): PersonBuilder {

        this.age = age
        return this
    }

    fun withContactNumber(contactNumber: String): PersonBuilder {

        this.contactNumber = contactNumber
        return this
    }

    fun withAddress(address: String): PersonBuilder {

        this.address = address
        return this
    }

    fun build(): Person {

        return Person(firstName, lastName, middleName, loginId, age, contactNumber, address)
    }

    /* companion object {

         fun personBuilder(): PersonBuilder {

             return PersonBuilder()
         }
     }*/
}
