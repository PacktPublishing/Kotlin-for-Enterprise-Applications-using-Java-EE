package org.rao.kotlin.microservices.identity.organization.dao

import org.rao.kotlin.microservices.identity.organization.entity.OrganizationEntity

interface OrganizationDao {



    fun createOrganization(organizationEntity: OrganizationEntity): OrganizationEntity?
    fun retrieveOrganization(orgId: String): OrganizationEntity
    fun updateOrganization(orgId: String, updateRequest:OrganizationEntity):
            OrganizationEntity
    fun deleteOrganization(orgId: String)
}
