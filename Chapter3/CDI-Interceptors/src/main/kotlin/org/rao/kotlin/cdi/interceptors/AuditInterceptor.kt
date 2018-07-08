package org.rao.kotlin.cdi.interceptors

import javax.annotation.Priority
import javax.inject.Inject
import javax.interceptor.AroundInvoke
import javax.interceptor.Interceptor
import javax.interceptor.InvocationContext


@Interceptor
@Auditable(Auditor.AuditType.DELETE)
@Priority(Interceptor.Priority.APPLICATION)
class AuditInterceptor {
    @Inject
    private lateinit var auditor: Auditor

    @Inject
    private lateinit var auditProcessor: AuditProcessor


    @AroundInvoke
    fun handle(context: InvocationContext) {
        auditor.audit("message")
        auditProcessor
                .processMessage(context.method.getAnnotation(Auditable::class.java).value)
        context.proceed()
    }

}
