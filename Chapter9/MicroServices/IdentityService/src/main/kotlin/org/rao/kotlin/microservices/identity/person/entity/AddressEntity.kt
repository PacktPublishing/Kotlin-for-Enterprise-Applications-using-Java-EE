package org.rao.kotlin.microservices.identity.person.entity

import javax.persistence.Embeddable

@Embeddable
class AddressEntity {
    lateinit var street: String
    lateinit var city: String
    lateinit var state: String
    lateinit var country: String

    override fun toString(): String {
        return "AddressEntity(street='$street', city='$city', state='$state', country='$country')"
    }

}
