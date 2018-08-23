package org.rao.kotlin.rest.security.organization.entity


import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery
import javax.persistence.Table


@Table(name = "organization")
@Entity
open class OrganizationEntity(@Id val orgId:String) {
     var orgName: String?= null
     var description: String?= null

}
