package org.rao.kotlin.service

import org.rao.kotlin.entity.Person

interface PersonService {
    fun createPerson(createPerson: Person): Person
}
