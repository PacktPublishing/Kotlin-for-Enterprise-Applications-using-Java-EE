package org.rao.kotlin.rest.organization.dao

import org.rao.kotlin.rest.organization.entity.OrganizationEntity
import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.Persistence
import javax.persistence.PersistenceContext

@Stateless
class OrganizationDao {
    @PersistenceContext(unitName = "local")
    internal var entityManager: EntityManager = Persistence.createEntityManagerFactory("local")
            .createEntityManager()


    fun createOrganization(organizationEntity: OrganizationEntity): OrganizationEntity {
        entityManager.transaction.begin()
        entityManager.persist(organizationEntity)
        entityManager.transaction.commit()

        return organizationEntity
    }

    fun retrieveOrganization(orgId: String): OrganizationEntity {
        entityManager.transaction.begin()
        var organizationEntity: OrganizationEntity = entityManager.find(OrganizationEntity::class.java, orgId)
        entityManager.transaction.commit()

        return organizationEntity
    }


}
