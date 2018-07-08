package org.rao.kotlin.jpa

import org.rao.kotlin.dao.PersonDao
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

import org.rao.kotlin.entity.Person
import org.rao.kotlin.entity.Queries

import javax.persistence.Persistence

@Stateless
class PersonDaoImpl : PersonDao {
    @PersistenceContext(unitName = "prod")
    private var entityManager: EntityManager = Persistence.createEntityManagerFactory("prod")
            .createEntityManager()

    override
    fun createPerson(person: Person): Person {
        // val person = identityCreator.person(person)
        entityManager.transaction.begin()
        entityManager.persist(person)
        entityManager.transaction.commit()
        return person
    }

    fun findAllPerson(): List<Person> {

        return entityManager!!.createNamedQuery(Queries.FIND_ALL_PERSON,
                Person::class.java).resultList
    }

}

