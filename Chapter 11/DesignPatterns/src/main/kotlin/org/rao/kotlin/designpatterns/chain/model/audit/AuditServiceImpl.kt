package org.rao.kotlin.designpatterns.chain.model.audit

class AuditServiceImpl:AuditService {
    override fun audit(auditMessage: AuditMessage) {
        println()
        println("--------------------------- audit message --------------------------- ")
        System.out.println("MessageId: ${auditMessage.auditMessageId}")
        println("Message: ${auditMessage.auditMessage!!}")
        println("ParticipantObjectId: ${auditMessage.participantObject!!.participantObjectId!!}")

        println("ParticipantObjectName: ${auditMessage.participantObject!!
                .participantObjectName!!}")
        println("AuditEventDate: ${auditMessage.auditEventDate!!}")
        println("AuditEventCode: ${auditMessage.event!!.code!!}")
        println("AuditEventDisplayName: ${auditMessage.event!!.displayName!!}")

        println("--------------------------- audit message ---------------------------")
    }
}
