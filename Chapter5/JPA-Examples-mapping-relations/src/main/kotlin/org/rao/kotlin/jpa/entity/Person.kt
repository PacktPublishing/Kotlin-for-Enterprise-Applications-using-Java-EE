package org.rao.kotlin.jpa.entity

import org.rao.kotlin.jpa.entity.Queries.Companion.FIND_ALL_PERSON
import java.util.UUID
import javax.persistence.*


@Table(name = "person")
@Entity
@NamedQuery(name = FIND_ALL_PERSON, query = "select p from Person p")
class Person : Identity() {
    @Id
    lateinit var identifier: UUID
    lateinit var name: PersonName
    lateinit var loginId: String

    @Enumerated(EnumType.STRING)
    var preferredLanguage: PreferredLanguage? = null

    @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", nullable = false)
    lateinit var contact: List<ContactDetails>
    @Embedded
    lateinit var address: Address

}
