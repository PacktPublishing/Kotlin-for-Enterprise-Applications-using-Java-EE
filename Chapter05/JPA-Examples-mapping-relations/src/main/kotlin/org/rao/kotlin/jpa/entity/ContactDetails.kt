package org.rao.kotlin.jpa.entity

import java.util.*
import javax.persistence.*

@Table(name = "contacts")
@Entity
class ContactDetails {
    @Id
    private lateinit var id: Integer
    lateinit var number: String

    @Enumerated(EnumType.STRING)
    private var type: ContactType? = null


    @ManyToOne(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
    lateinit var person: Person


}

enum class ContactType(val contactType: String) {
    WORK("work"), MOBILE("mobile"), HOME("home")
}
