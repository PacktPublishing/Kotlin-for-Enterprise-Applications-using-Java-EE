package org.rao.kotlin.microservices.identity.organization.entity


import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Table(name = "organization")
@Entity
open class OrganizationEntity(@Id @Column(name = "org_id") val orgId:String) {
    @Column(name = "org_name") var orgName: String?= null
    var description: String?= null

}
