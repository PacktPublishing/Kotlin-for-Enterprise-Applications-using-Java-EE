package org.rao.kotlin.rest.organization.model

import java.util.*

class OrganizationResponse {
    var orgId: String?= null
    var orgName: String? = null
    var description: String? = null

    override fun toString(): String {
        return "Organization [orgId=$orgId, orgName=$orgName, description=$description]"
    }
}
