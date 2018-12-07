package org.rao.kotlin.microservices.identity.person.dao

import org.rao.kotlin.microservices.identity.exception.IdentityAlreadyExistsException
import org.rao.kotlin.microservices.identity.exception.IdentityException
import org.rao.kotlin.microservices.identity.exception.IdentityNotFoundException
import org.rao.kotlin.microservices.identity.person.entity.PersonEntity
import org.rao.kotlin.microservices.identity.util.Constants
import org.rao.kotlin.microservices.identity.util.Constants.IDENTITY_NOT_FOUND
import javax.persistence.EntityManager
import javax.persistence.Persistence
import javax.persistence.PersistenceContext
import javax.persistence.PersistenceException


class PersonDaoImpl : PersonDao {
    @PersistenceContext(unitName = "local")
    private var entityManager: EntityManager = Persistence.createEntityManagerFactory("local")
            .createEntityManager()


    override
    fun createPerson(personEntity: PersonEntity): PersonEntity {
        try{
            entityManager.transaction.begin()
            entityManager.persist(personEntity)
            entityManager.transaction.commit()
            return personEntity
        }catch (exception: Exception){
            if(exception is PersistenceException){
                throw IdentityAlreadyExistsException(Constants.IDENTITY_ALREADY_EXIST)
            }else {
                throw IdentityException(exception.message!!)
            }
        }

    }


    override fun retrievePersonByLoginId(loginId: String): PersonEntity {
        entityManager.transaction.begin()

        var personEntity = entityManager
                .createQuery("select p from PersonEntity p where p.loginId = ?1",
                        PersonEntity::class.java)
                .setParameter(1, loginId)
                .singleResult

        entityManager.transaction.commit()

        return personEntity
    }

    override fun retrievePersonById(uuid: String): PersonEntity {
        entityManager.transaction.begin()

        var personEntity = entityManager.find(PersonEntity::class.java, uuid)

        entityManager.transaction.commit()
        if (personEntity != null) {
            return personEntity
        } else {
            throw IdentityNotFoundException(IDENTITY_NOT_FOUND)
        }
    }

    override fun deletePerson(uuid: String) {
        entityManager.transaction.begin()

        var personEntity = entityManager.find(PersonEntity::class.java, uuid)

        if (personEntity != null) {
            entityManager.remove(personEntity)
            entityManager.transaction.commit()
        } else {
            throw IdentityNotFoundException(IDENTITY_NOT_FOUND)
        }

    }

    override fun updatePerson(uuid: String, updateRequest: PersonEntity): PersonEntity {
        entityManager.transaction.begin()
        var personEntity = entityManager.find(PersonEntity::class.java, uuid)

        if (personEntity != null) {
            personEntity = entityManager.merge(updateRequest)
            entityManager.transaction.commit()
            return personEntity
        } else {
            throw IdentityNotFoundException(IDENTITY_NOT_FOUND)
        }
    }

}

