package org.rao.kotlin.microservices.identity.person.entity


import org.rao.kotlin.microservices.identity.person.entity.Queries.Companion.FIND_ALL_PERSON
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery
import javax.persistence.Table


@Table(name = "person")
@Entity
@NamedQuery(name = FIND_ALL_PERSON, query = "select p from PersonEntity p")
class PersonEntity(@Column(name = "loginid") val loginId: String) {


    @Id
    lateinit var identifier: String

    lateinit var name: String

    @Column(name = "orgid")
    var orgId: String ?=null

    var preferredLanguage: String? = null

    @Embedded
    lateinit var address: AddressEntity



}
