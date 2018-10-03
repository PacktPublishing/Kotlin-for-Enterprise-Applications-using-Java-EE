package org.rao.kotlin.designpatterns.chain.handler

import org.rao.kotlin.designpatterns.chain.model.audit.AuditMessage
import org.rao.kotlin.designpatterns.chain.model.audit.AuditUtil
import org.rao.kotlin.designpatterns.chain.model.audit.Event
import org.rao.kotlin.designpatterns.chain.model.identity.Identity

class DefaultAuditHandler : AbstractAuditHandler() {

    override fun handleRequest(identityRequest: Identity) {
        println("---------------------- DefaultAuditHandler.handleRequest() invoked " +
                "----------------------")
        var auditMessage: AuditMessage = AuditUtil.prepareAuditMessage(Constants.UNKNOWN_IDENTITY_TYPE_MESSAGE)

        auditMessage.participantObject = AuditUtil.createParticipantObject(identityRequest)
        var event: Event = Event()

        when (identityRequest.requestMethod) {
            "GET" -> {
                event.code = Constants.UNKNOWN_IDENTITY_TYPE
                event.displayName = Constants.UNKNOWN_IDENTITY_TYPE
            }
            "POST" -> {
                event.code = Constants.UNKNOWN_IDENTITY_TYPE
                event.displayName = Constants.UNKNOWN_IDENTITY_TYPE
            }
            "PUT" -> {
                event.code = Constants.UNKNOWN_IDENTITY_TYPE
                event.displayName = Constants.UNKNOWN_IDENTITY_TYPE
            }
            "DELETE" -> {
                event.code = Constants.UNKNOWN_IDENTITY_TYPE
                event.displayName = Constants.UNKNOWN_IDENTITY_TYPE
            }
        }
        auditMessage.event = event
        auditService.audit(auditMessage)


    }
}
