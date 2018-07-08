package org.rao.kotlin.entity


import javax.persistence.CascadeType
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.NamedQuery
import javax.persistence.OneToMany
import javax.persistence.Table
import org.rao.kotlin.entity.Queries.Companion.FIND_ALL_PERSON


@Table(name = "person")
@Entity
@NamedQuery(name = FIND_ALL_PERSON, query = "select p from Person p")
data class Person(val loginId: String) {
    @Id
    lateinit var identifier: String
    lateinit var name: String

    @Enumerated(EnumType.STRING)
    var preferredLanguage: PreferredLanguage? = null

    @OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", nullable = false, referencedColumnName = "identifier")
    lateinit var contact: List<ContactDetails>
    @Embedded
    lateinit var address: Address
}
