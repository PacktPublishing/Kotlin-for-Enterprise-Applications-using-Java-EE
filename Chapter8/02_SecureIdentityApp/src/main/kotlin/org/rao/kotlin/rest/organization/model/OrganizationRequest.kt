package org.rao.kotlin.rest.organization.model

class OrganizationRequest {
    var orgId: String? = null
    var orgName: String? = null
    var description: String? = null

    override fun toString(): String {
        return "Organization [orgName=$orgName, description=$description]"
    }
}
