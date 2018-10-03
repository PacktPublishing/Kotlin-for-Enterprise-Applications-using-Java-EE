package org.rao.kotlin.designpatterns.chain.model.audit

import org.rao.kotlin.designpatterns.chain.model.identity.Identity
import java.time.Instant
import java.util.*

object AuditUtil {
    public fun prepareAuditMessage(message: String): AuditMessage {
        var auditMessage: AuditMessage = AuditMessage()

        auditMessage.auditMessage = message
        auditMessage.auditEventDate = Date.from(Instant.now())
        auditMessage.auditMessageId = UUID.randomUUID().toString()

        return auditMessage

    }

    public fun createParticipantObject(identity: Identity): ParticipantObject {
        var participantObject: ParticipantObject = ParticipantObject()
        participantObject.participantObjectId = identity.id;
        participantObject.participantObjectName = identity.name
        participantObject.participantObjectType = identity.identityType!!.name

        return participantObject

    }
}
