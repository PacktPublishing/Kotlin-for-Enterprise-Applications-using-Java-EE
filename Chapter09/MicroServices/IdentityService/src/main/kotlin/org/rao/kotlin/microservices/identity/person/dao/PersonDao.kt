package org.rao.kotlin.microservices.identity.person.dao

import org.rao.kotlin.microservices.identity.person.entity.PersonEntity


interface PersonDao {
    fun createPerson(person: PersonEntity): PersonEntity
    fun retrievePersonByLoginId(loginId: String): PersonEntity
    fun retrievePersonById(uuid: String): PersonEntity
    fun deletePerson(uuid: String)
    fun updatePerson(uuid: String, updateRequest: PersonEntity): PersonEntity
}
