package org.rao.kotlin.jpa

import javax.ejb.Stateless
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

import org.rao.kotlin.jpa.entity.Identity
import org.rao.kotlin.jpa.entity.IdentityCreator
import org.rao.kotlin.jpa.entity.InputData
import org.rao.kotlin.jpa.entity.Person
import org.rao.kotlin.jpa.entity.Queries

@Stateless
class App {
    @Inject
    private lateinit var identityCreator: IdentityCreator
    @PersistenceContext(unitName = "production")
    private lateinit var entityManager: EntityManager


    fun createIdentity(inputData: InputData): Person {
        val person = identityCreator.createPerson(inputData)
        entityManager.persist(person)
        return person
    }

    fun findAllPerson(): List<Identity> {

        return entityManager!!.createNamedQuery(Queries.FIND_ALL_PERSON,
                Person::class.java).resultList
    }

}

