package org.rao.kotlin.rest.organization.entity


import org.rao.kotlin.rest.organization.entity.Queries.Companion.FIND_ALL_ORGANIZATION
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQuery
import javax.persistence.Table


@Table(name = "organization")
@Entity
@NamedQuery(name = FIND_ALL_ORGANIZATION, query = "select o from Organization o")
open class OrganizationEntity(@Id val orgId:String) {
     var orgName: String?= null
     var description: String?= null

}
