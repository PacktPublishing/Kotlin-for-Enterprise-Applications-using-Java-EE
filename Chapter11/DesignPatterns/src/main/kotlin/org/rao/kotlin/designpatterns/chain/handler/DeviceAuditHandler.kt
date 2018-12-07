package org.rao.kotlin.designpatterns.chain.handler

import org.rao.kotlin.designpatterns.chain.model.audit.AuditMessage
import org.rao.kotlin.designpatterns.chain.model.audit.AuditUtil
import org.rao.kotlin.designpatterns.chain.model.audit.Event
import org.rao.kotlin.designpatterns.chain.model.identity.Identity
import org.rao.kotlin.designpatterns.chain.model.identity.IdentityType

class DeviceAuditHandler : AbstractAuditHandler() {
    override fun handleRequest(identityRequest: Identity) {
        println("---------------------- DeviceAuditHandler.handleRequest() invoked " +
                "----------------------")
        if (identityRequest.identityType == IdentityType.DEVICE) {

            var auditMessage: AuditMessage = AuditUtil.prepareAuditMessage(Constants
                    .DEVICE_AUDIT_MESSAGE)

            auditMessage.participantObject = AuditUtil.createParticipantObject(identityRequest)
            var event: Event = Event()
            when (identityRequest.requestMethod) {
                "GET" -> {
                    event.code = Constants.DEVICE_READ_EVENT_CODE
                    event.displayName = Constants.DEVICE_READ_EVENT_DISPLAYNAME
                }
                "POST" -> {
                    event.code = Constants.DEVICE_CREATE_EVENT_CODE
                    event.displayName = Constants.DEVICE_CREATE_EVENT_DISPLAYNAME
                }
                "PUT" -> {
                    event.code = Constants.DEVICE_UPDATE_EVENT_CODE
                    event.displayName = Constants.DEVICE_UPDATE_EVENT_DISPLAYNAME
                }
                "DELETE" -> {
                    event.code = Constants.DEVICE_DELETE_EVENT_CODE
                    event.displayName = Constants.DEVICE_DELETE_EVENT_DISPLAYNAME
                }
            }
            auditMessage.event = event
            auditService.audit(auditMessage)


        } else {
            auditHandler!!.handleRequest(identityRequest)
        }


    }

}
