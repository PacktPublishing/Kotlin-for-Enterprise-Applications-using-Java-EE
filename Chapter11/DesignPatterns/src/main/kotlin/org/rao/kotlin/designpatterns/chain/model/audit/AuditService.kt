package org.rao.kotlin.designpatterns.chain.model.audit

interface AuditService {
    fun audit(auditMessage: AuditMessage)
}
