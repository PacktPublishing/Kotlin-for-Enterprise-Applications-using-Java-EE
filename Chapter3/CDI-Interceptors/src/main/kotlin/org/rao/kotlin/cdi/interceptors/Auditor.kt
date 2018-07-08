package org.rao.kotlin.cdi.interceptors

open class Auditor {
    fun audit(message: String) {
        println(message)
    }

     enum class AuditType{
        CREATE, READ, UPDATE, DELETE
    }

}
