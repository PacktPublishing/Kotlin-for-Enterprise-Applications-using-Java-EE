package org.rao.kotlin.microservices.identity.organization.service

import com.sun.jersey.spi.inject.Inject
import org.rao.kotlin.microservices.identity.organization.dao.OrganizationDaoImpl
import org.rao.kotlin.microservices.identity.organization.entity.OrganizationEntity
import org.rao.kotlin.rest.organization.model.Organization
import java.util.*

class OrganizationServiceImpl : OrganizaionService {
    @Inject
    internal var organizationDao: OrganizationDaoImpl? = null

   override fun createOrganization(organizationRequest: Organization): String {
        var organizationEntity: OrganizationEntity = OrganizationEntity(UUID.randomUUID().toString())
       mapOrganizationToOrganizationEntity(organizationRequest,organizationEntity)
        var entity: OrganizationEntity? = organizationDao!!.createOrganization(organizationEntity)
        return entity!!.orgId
    }

    override fun retrieveOrganization(orgId: String): Organization {
        var organizationEntity: OrganizationEntity = organizationDao!!.retrieveOrganization(orgId)
        var organization = Organization()
        return mapOrganizationEntityToOrganization(organizationEntity,organization)
    }
    override fun updateOrganization(orgId: String, updateRequest:Organization): Organization {
        var organization = updateRequest
        var organizationEntity: OrganizationEntity = organizationDao!!.retrieveOrganization(orgId)
        organizationEntity.description = updateRequest.description
        organizationEntity = organizationDao!!.updateOrganization(orgId, organizationEntity)
        return mapOrganizationEntityToOrganization(organizationEntity, organization)
    }

    override fun deleteOrganization(orgId: String) {
        organizationDao!!.deleteOrganization(orgId)
    }

    private fun mapOrganizationEntityToOrganization(organizationEntity:OrganizationEntity,
                                                    organization: Organization):Organization{
        organization.orgId = organizationEntity.orgId
        organization.orgName = organizationEntity.orgName
        organization.description = organizationEntity.description
        return organization
    }
    private fun mapOrganizationToOrganizationEntity(organization: Organization,
                                                    organizationEntity:OrganizationEntity):OrganizationEntity{
        organizationEntity.orgName = organization.orgName
        organizationEntity.description = organization.description
        return organizationEntity
    }

}
