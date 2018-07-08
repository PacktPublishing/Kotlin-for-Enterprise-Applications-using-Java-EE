package org.rao.kotlin.entity

import javax.persistence.Embeddable

@Embeddable
class Address {
    lateinit var street: String
    lateinit var city: String
    lateinit var state: String
    lateinit var country: String

}
