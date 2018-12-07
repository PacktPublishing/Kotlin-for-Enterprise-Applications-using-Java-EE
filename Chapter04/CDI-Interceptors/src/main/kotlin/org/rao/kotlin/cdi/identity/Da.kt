import org.rao.kotlin.cdi.interceptors.Auditor

class AuditProcessor {
    fun track(type: Auditor.AuditType) {
        println("Audit message type$type")
    }
}
