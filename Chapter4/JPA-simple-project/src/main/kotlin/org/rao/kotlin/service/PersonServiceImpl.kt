package org.rao.kotlin.service

import org.rao.kotlin.dao.PersonDao
import org.rao.kotlin.entity.Person
import org.rao.kotlin.entity.PreferredLanguage
import java.util.UUID

import javax.enterprise.context.Dependent
import javax.inject.Inject


@Dependent
class PersonServiceImpl : PersonService {
    @Inject
    private lateinit var personDao: PersonDao

    @Inject
    private lateinit var defaultPreferredLanguage: PreferredLanguage

    override
    fun createPerson(createPerson: Person): Person {
        var person = createPerson

        person.preferredLanguage = if (createPerson.preferredLanguage == null)
            defaultPreferredLanguage
        else
            person.preferredLanguage
        person.identifier = UUID.randomUUID().toString()
        return personDao.createPerson(person)
    }
}

