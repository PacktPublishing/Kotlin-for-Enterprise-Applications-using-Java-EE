package org.rao.kotlin.designpatterns.builder.model

class Person {
    var firstName: String? = null
    var lastName: String? = null
    var middleName: String? = null
    var loginId: String? = null
    var age: Int? = null
    var contactNumber: String? = null
    var address: String? = null

    constructor(firstName: String?, lastName: String?, middleName: String?, loginId: String?, age: Int?, contactNumber: String?, address: String?) {
        this.firstName = firstName
        this.lastName = lastName
        this.middleName = middleName
        this.loginId = loginId
        this.age = age
        this.contactNumber = contactNumber
        this.address = address
    }

    constructor(firstName: String?) {
        this.firstName = firstName
    }

    constructor(firstName: String?, lastName: String?) {
        this.firstName = firstName
        this.lastName = lastName
    }

    constructor(firstName: String?, lastName: String?, middleName: String?) {
        this.firstName = firstName
        this.lastName = lastName
        this.middleName = middleName
    }

    constructor(firstName: String?, lastName: String?, loginId: String?, contactNumber: String?) {
        this.firstName = firstName
        this.lastName = lastName
        this.loginId = loginId
        this.contactNumber = contactNumber
    }


}
