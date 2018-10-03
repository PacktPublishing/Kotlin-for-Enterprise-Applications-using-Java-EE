package org.rao.kotlin.designpatterns.chain.handler

import org.rao.kotlin.designpatterns.chain.model.audit.AuditServiceImpl

abstract class AbstractAuditHandler : Handler {
    protected var auditService: AuditServiceImpl = AuditServiceImpl()
    protected var auditHandler: Handler? = null

    override fun addHandler(auditHandler: Handler) {
        this.auditHandler = auditHandler
    }
}
