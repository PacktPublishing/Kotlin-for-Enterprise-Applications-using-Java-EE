package org.rao.kotlin.cdi.interceptors

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.interceptor.InterceptorBinding


@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Documented
annotation class Auditable(val value: Auditor.AuditType)
