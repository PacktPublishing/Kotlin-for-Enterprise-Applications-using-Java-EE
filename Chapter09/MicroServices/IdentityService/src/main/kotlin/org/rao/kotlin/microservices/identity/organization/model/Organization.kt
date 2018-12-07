package org.rao.kotlin.rest.organization.model

class Organization {
    var orgId: String?= null
    var orgName: String? = null
    var description: String? = null

    override fun toString(): String {
        return "Organization [orgName=$orgName, description=$description]"
    }
}
