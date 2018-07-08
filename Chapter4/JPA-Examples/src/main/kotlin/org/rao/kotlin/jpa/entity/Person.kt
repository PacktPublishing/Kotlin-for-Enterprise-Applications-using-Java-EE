package org.rao.kotlin.jpa.entity

import org.rao.kotlin.jpa.entity.Queries.Companion.FIND_ALL_PERSON
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery
import javax.persistence.Table




@Table
@Entity
@NamedQuery(name = FIND_ALL_PERSON, query = "select p from Person p")
class Person : Identity() {
    @Id
    lateinit var identifier: UUID
    lateinit var name: PersonName
    lateinit var loginId: String
    lateinit var address: Address
    var preferredLanguage: PreferredLanguage? = null

}
