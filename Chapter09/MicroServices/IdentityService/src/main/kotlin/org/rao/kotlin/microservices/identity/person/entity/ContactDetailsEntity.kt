/*
package org.rao.kotlin.microservices.identity.person.entity

import javax.persistence.*

@Table(name = "contacts")
@Entity
class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    lateinit var id: String
    lateinit var number: String

    @Enumerated(EnumType.STRING)
    var type: ContactType? = null

}

enum class ContactType(val contactType: String) {
    WORK("work"), MOBILE("mobile"), HOME("home")
}
*/
