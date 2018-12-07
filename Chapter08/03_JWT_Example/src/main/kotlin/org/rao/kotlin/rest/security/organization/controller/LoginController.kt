package org.rao.kotlin.rest.security.organization.controller

import org.glassfish.soteria.mechanisms.HttpMessageContextImpl
import org.rao.kotlin.rest.security.organization.filter.CallBackHandlerImpl
import org.rao.kotlin.rest.security.organization.filter.MessageInfoImpl
import org.rao.kotlin.rest.security.organization.filter.MyAuthMechanism
import org.rao.kotlin.rest.security.organization.util.JWTUtil.createJwt
import javax.security.auth.Subject
import javax.security.auth.callback.CallbackHandler
import javax.security.enterprise.AuthenticationStatus
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "login", value = "/login")
class LoginController : HttpServlet() {
    private var handler: CallbackHandler = CallBackHandlerImpl();
    var messageContext: HttpMessageContext = HttpMessageContextImpl(handler, MessageInfoImpl(),
            Subject())

    override fun doPost(httpServletRequest: HttpServletRequest, httpServletResponse: HttpServletResponse) {
        val myAuthMechanism = MyAuthMechanism()
        val isValid = myAuthMechanism.validateRequest(httpServletRequest, httpServletResponse,
                messageContext)
        if (isValid == AuthenticationStatus.SUCCESS) {
            return httpServletResponse.writer.write(" JWT:" + createJwt("1234", "localhost", "sub123",
                    900000L))
        } else {
            return httpServletResponse.writer.write("invalid credentials")
        }
    }


}

