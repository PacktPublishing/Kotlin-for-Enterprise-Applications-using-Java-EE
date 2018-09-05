package org.rao.kotlin.service

import com.sun.jersey.spi.inject.Inject
import org.rao.kotlin.microservices.identity.person.dao.PersonDaoImpl
import org.rao.kotlin.microservices.identity.person.entity.AddressEntity
import org.rao.kotlin.microservices.identity.person.entity.PersonEntity
import org.rao.kotlin.microservices.identity.person.model.Address
import org.rao.kotlin.microservices.identity.person.model.Person
import org.rao.kotlin.microservices.identity.person.model.PreferredLanguage
import java.util.*


class PersonServiceImpl : PersonService {
    @Inject
    private lateinit var personDao: PersonDaoImpl

    private var defaultPreferredLanguage = PreferredLanguage.EN_US.preferredLanguage
    override
    fun createPerson(createPersonRequest: Person): String {
        var person = createPersonRequest

        person.preferredLanguage = if (person.preferredLanguage == null)
            defaultPreferredLanguage
        else
            person.preferredLanguage
        person.identifier = UUID.randomUUID().toString()
        var personEntity: PersonEntity = PersonEntity(person.loginId!!)

        personEntity = personDao!!.createPerson(mapPersonToPersonEntity(person, personEntity))

        return personEntity.identifier


    }

    override fun retrievePersonByLoginId(loginId: String): Person {
        var personEntity: PersonEntity = personDao!!.retrievePersonByLoginId(loginId)
        var person = Person()
       return mapPersonEntityToPerson(personEntity, person)

    }
    override fun retrievePersonById(uuid: String): Person {
        var personEntity: PersonEntity = personDao!!.retrievePersonById(uuid)
        var person = Person()
        return mapPersonEntityToPerson(personEntity, person)
    }
    override fun updatePerson(uuid: String, updateRequest:Person): Person {

        var person = updateRequest
        var personEntity: PersonEntity = personDao!!.retrievePersonById(uuid)

        personEntity.preferredLanguage = person.preferredLanguage
        personEntity.address.city = person.address.city
        personEntity.address.state = person.address.state
        personEntity.address.street = person.address.street
        personEntity.address.country = person.address.country


        personEntity = personDao!!.updatePerson(uuid,personEntity)

        return mapPersonEntityToPerson(personEntity, person)

    }
    override fun deletePerson(uuid: String) {
        personDao!!.deletePerson(uuid)
    }

   private fun mapPersonEntityToPerson(personEntity: PersonEntity, person: Person) :Person {
        person.loginId = personEntity.loginId
        person.preferredLanguage = personEntity.preferredLanguage.toString()
       person.name = personEntity.name

       person.address = Address()
       person.address.city = personEntity.address.city
       person.address.country = personEntity.address.country
       person.address.state = personEntity.address.state
       person.address.street = personEntity.address.street

     person.orgId=personEntity.orgId
       person.identifier = personEntity.identifier
       return person
    }

    private fun mapPersonToPersonEntity(person: Person, personEntity: PersonEntity) :PersonEntity {
        personEntity.preferredLanguage = person.preferredLanguage.toString()
        personEntity.name = person.name

        personEntity.address = AddressEntity()
        personEntity.address.city = person.address.city
        personEntity.address.country = person.address.country
        personEntity.address.state = person.address.state
        personEntity.address.street = person.address.street

        personEntity.orgId = person.orgId
        personEntity.identifier = person.identifier
        return personEntity
    }
}

