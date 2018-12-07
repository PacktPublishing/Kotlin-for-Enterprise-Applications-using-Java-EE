package org.rao.kotlin.messaging

import javax.enterprise.inject.Produces
import javax.naming.InitialContext
import javax.naming.NamingException


class InitialContextProducer {
    @Produces
    @Throws(NamingException::class)
    fun initialContext(): InitialContext {
        return InitialContext()
    }
}
