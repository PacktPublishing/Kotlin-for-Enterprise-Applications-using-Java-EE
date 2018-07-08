package org.rao.kotlin.cdi.interceptors

class AuditProcessor {
    fun processMessage(type: Auditor.AuditType) {
        println("Audit message type $type")
    }
}
