package org.rao.kotlin.service

import org.rao.kotlin.microservices.identity.person.model.Person


interface PersonService {
    fun createPerson(createPerson: Person): String
    fun retrievePersonByLoginId(loginId: String): Person
    fun retrievePersonById(uuid: String): Person
    fun deletePerson(uuid: String)
    fun updatePerson(uuid: String, updateRequest: Person): Person

}
