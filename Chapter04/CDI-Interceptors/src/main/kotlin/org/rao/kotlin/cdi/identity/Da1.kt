import javax.interceptor.InterceptorBinding
import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import org.rao.kotlin.cdi.interceptors.Auditor

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Documented
annotation class Auditable(val value: Auditor.AuditType)
