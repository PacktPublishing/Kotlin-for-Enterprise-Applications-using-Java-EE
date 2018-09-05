package org.rao.kotlin.microservices.authentication.auth

import java.io.IOException
import javax.security.auth.callback.Callback
import javax.security.auth.callback.CallbackHandler
import javax.security.auth.callback.UnsupportedCallbackException

class CallBackHandlerImpl : CallbackHandler {
    @Throws(IOException::class, UnsupportedCallbackException::class)
    override fun handle(callbacks: Array<Callback>) {

    }
}
