package org.rao.kotlin.designpatterns.chain.model.audit

import java.util.*

class AuditMessage {
    var auditMessageId: String? = null
    var auditEventDate: Date? = null
    var auditMessage: String? = null
    var participantObject: ParticipantObject? = null
    var event: Event? = null

}
