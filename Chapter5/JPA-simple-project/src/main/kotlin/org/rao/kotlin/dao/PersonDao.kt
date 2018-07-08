package org.rao.kotlin.dao

import org.rao.kotlin.entity.Person

interface PersonDao {
    fun createPerson(person: Person): Person
}
