package org.rao.kotlin.rest.organization.service

import org.rao.kotlin.rest.organization.dao.OrganizationDao
import org.rao.kotlin.rest.security.organization.entity.OrganizationEntity
import org.rao.kotlin.rest.security.organization.model.OrganizationRequest
import org.rao.kotlin.rest.security.organization.model.OrganizationResponse
import java.util.*
import javax.annotation.ManagedBean
import javax.enterprise.context.ApplicationScoped

@ManagedBean
@ApplicationScoped

open class OrganizaionService {
    internal var organizationDao: OrganizationDao = OrganizationDao()

    fun createOrganization(organizationRequest: OrganizationRequest): String {
        var organizationEntity: OrganizationEntity = OrganizationEntity(UUID.randomUUID().toString())
        organizationEntity.orgName = organizationRequest.orgName
        organizationEntity.description = organizationRequest.description

        var entity: OrganizationEntity = organizationDao.createOrganization(organizationEntity)
        return entity.orgId
    }

    fun retrieveOrganization(orgId: String): OrganizationResponse {
        var organizationEntity: OrganizationEntity = organizationDao.retrieveOrganization(orgId)

        var organizationResponse: OrganizationResponse = OrganizationResponse()
        organizationResponse.orgId = organizationEntity.orgId
        organizationResponse.orgName = organizationEntity.orgName
        organizationResponse.description = organizationEntity.description
        return organizationResponse
    }
}
