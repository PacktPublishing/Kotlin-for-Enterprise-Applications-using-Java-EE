package org.rao.kotlin.designpatterns.chain.handler

import org.rao.kotlin.designpatterns.chain.model.audit.AuditMessage
import org.rao.kotlin.designpatterns.chain.model.audit.AuditUtil
import org.rao.kotlin.designpatterns.chain.model.audit.Event
import org.rao.kotlin.designpatterns.chain.model.audit.ParticipantObject
import org.rao.kotlin.designpatterns.chain.model.identity.Identity
import org.rao.kotlin.designpatterns.chain.model.identity.IdentityType

class PersonAuditHandler : AbstractAuditHandler() {

    internal var participantObject: ParticipantObject = ParticipantObject()

    override fun handleRequest(identityRequest: Identity) {
        println("---------------------- PersonAuditHandler.handleRequest() invoked " +
                "----------------------")
        if (identityRequest.identityType == IdentityType.PERSON) {
            var auditMessage: AuditMessage = AuditUtil.prepareAuditMessage(Constants.PERSON_AUDIT_MESSAGE)
            auditMessage.participantObject = AuditUtil.createParticipantObject(identityRequest)
            var event: Event = Event()

            when (identityRequest.requestMethod) {
                "GET" -> {
                    event.code = Constants.PERSON_READ_EVENT_CODE
                    event.displayName = Constants.PERSON_READ_EVENT_DISPLAYNAME
                }
                "POST" -> {
                    event.code = Constants.PERSON_CREATE_EVENT_CODE
                    event.displayName = Constants.PERSON_CREATE_EVENT_DISPLAYNAME
                }
                "PUT" -> {
                    event.code = Constants.PERSON_UPDATE_EVENT_CODE
                    event.displayName = Constants.PERSON_UPDATE_EVENT_DISPLAYNAME
                }
                "DELETE" -> {
                    event.code = Constants.PERSON_DELETE_EVENT_CODE
                    event.displayName = Constants.PERSON_DELETE_EVENT_DISPLAYNAME
                }
            }
            auditMessage.event = event
            auditService.audit(auditMessage)
        } else {
            auditHandler!!.handleRequest(identityRequest)
        }
    }

}



