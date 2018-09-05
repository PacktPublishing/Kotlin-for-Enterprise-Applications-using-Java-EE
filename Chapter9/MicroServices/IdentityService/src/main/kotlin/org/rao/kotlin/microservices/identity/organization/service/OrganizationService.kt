package org.rao.kotlin.microservices.identity.organization.service

import org.rao.kotlin.rest.organization.model.Organization

interface OrganizaionService {

    fun createOrganization(organizationRequest: Organization): String

    fun retrieveOrganization(orgId: String): Organization
    fun updateOrganization(orgId: String, updateRequest:Organization): Organization
    fun deleteOrganization(orgId: String)
}
