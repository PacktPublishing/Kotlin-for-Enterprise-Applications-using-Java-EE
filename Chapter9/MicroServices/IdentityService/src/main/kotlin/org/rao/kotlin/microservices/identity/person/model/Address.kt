package org.rao.kotlin.microservices.identity.person.model

class Address {
    lateinit var street: String
    lateinit var city: String
    lateinit var state: String
    lateinit var country: String
    override fun toString(): String {
        return "Address(street='$street', city='$city', state='$state', country='$country')"
    }

}
