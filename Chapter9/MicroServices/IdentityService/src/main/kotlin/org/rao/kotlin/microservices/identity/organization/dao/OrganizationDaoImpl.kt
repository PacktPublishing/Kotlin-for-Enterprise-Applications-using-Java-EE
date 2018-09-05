package org.rao.kotlin.microservices.identity.organization.dao

import org.rao.kotlin.microservices.identity.exception.IdentityAlreadyExistsException
import org.rao.kotlin.microservices.identity.exception.IdentityException
import org.rao.kotlin.microservices.identity.exception.IdentityNotFoundException
import org.rao.kotlin.microservices.identity.organization.entity.OrganizationEntity
import org.rao.kotlin.microservices.identity.util.Constants
import javax.persistence.Persistence
import javax.persistence.PersistenceException

class OrganizationDaoImpl : OrganizationDao {

    internal var entityManagerFactory = Persistence.createEntityManagerFactory("local")
    internal var entityManager = entityManagerFactory.createEntityManager()

    override fun createOrganization(organizationEntity: OrganizationEntity): OrganizationEntity? {
        try {
            entityManager.transaction.begin()
            var entity = entityManager.createQuery("select o from OrganizationEntity o where o" +
                    ".orgName like:name")
                    .setParameter("name", organizationEntity.orgName).singleResult
            if(entity is OrganizationEntity){
                if( entity.orgId != null) {
                    throw IdentityAlreadyExistsException(Constants.IDENTITY_ALREADY_EXIST)
                }
            }else {
                entityManager.persist(organizationEntity)
                entityManager.transaction.commit()
                return organizationEntity
            }
        } catch (exception: PersistenceException) {
              throw IdentityException(exception.message!!)
        }
        return null
    }

    override fun retrieveOrganization(orgId: String): OrganizationEntity {
        entityManager.transaction.begin()
        var organizationEntity = entityManager.find(OrganizationEntity::class.java, orgId)
        entityManager.transaction.commit()
        if(organizationEntity!= null){
            return  organizationEntity
        } else {
            throw IdentityNotFoundException(Constants.IDENTITY_NOT_FOUND)
        }
    }

    override fun updateOrganization(orgId: String, updateRequest:OrganizationEntity):
            OrganizationEntity {
        entityManager.transaction.begin()
        var organizationEntity = entityManager.find(OrganizationEntity::class.java, orgId)
        if(organizationEntity != null) {
            organizationEntity = entityManager.merge(updateRequest)
            entityManager.transaction.commit()
            return organizationEntity
        } else {
            throw IdentityNotFoundException(Constants.IDENTITY_NOT_FOUND)
        }
    }
    override fun deleteOrganization(orgId: String) {
        entityManager.transaction.begin()
        var organizationEntity: OrganizationEntity = entityManager.find(OrganizationEntity::class.java, orgId)
        if (organizationEntity != null) {
            entityManager.remove(organizationEntity)
            entityManager.transaction.commit()
        } else {
            throw IdentityNotFoundException(Constants.IDENTITY_NOT_FOUND)
        }
    }
}
