package org.rao.kotlin.designpatterns.chain

import org.rao.kotlin.designpatterns.chain.handler.DefaultAuditHandler
import org.rao.kotlin.designpatterns.chain.handler.DeviceAuditHandler
import org.rao.kotlin.designpatterns.chain.handler.GroupAuditHandler
import org.rao.kotlin.designpatterns.chain.handler.OrganizationAuditHandler
import org.rao.kotlin.designpatterns.chain.handler.PersonAuditHandler
import org.rao.kotlin.designpatterns.chain.model.identity.IdentityType
import org.rao.kotlin.designpatterns.chain.model.identity.Person
import javax.ws.rs.HttpMethod

object ChainOfResponsibilityDemo {
    @JvmStatic
    fun main(args: Array<String>) {

        val personAuditHandler = PersonAuditHandler()
        val organizationAuditHandler = OrganizationAuditHandler()
        val groupAuditHandler = GroupAuditHandler()
        val deviceAuditHandler = DeviceAuditHandler()

        organizationAuditHandler.addHandler(groupAuditHandler)
        groupAuditHandler.addHandler(deviceAuditHandler)
        deviceAuditHandler.addHandler(personAuditHandler)
        personAuditHandler.addHandler(DefaultAuditHandler())

        organizationAuditHandler.handleRequest(creaeSamplePersonRequest())
        organizationAuditHandler.handleRequest(creaeUnknownIdentityRequest())

    }
    fun creaeSamplePersonRequest(): Person {
        val identity = Person()
        identity.id = "person123"
        identity.description = "Person identity"
        identity.identityType = IdentityType.PERSON
        identity.name = "Name"
        identity.organizationId = "orgId123"
        identity.requestMethod = HttpMethod.POST
        return identity

    }
    fun creaeUnknownIdentityRequest(): Person {
        val identity = Person()
        identity.identityType = IdentityType.PERSON
        identity.id = "123"
        identity.description = "Some identity"
        identity.name = "Name"
        identity.requestMethod = HttpMethod.POST
        return identity

    }
}
