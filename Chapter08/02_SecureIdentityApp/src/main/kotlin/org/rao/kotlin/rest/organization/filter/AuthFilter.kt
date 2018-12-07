package org.rao.kotlin.rest.organization.filter

import org.glassfish.soteria.mechanisms.HttpMessageContextImpl
import java.io.IOException
import javax.annotation.security.DeclareRoles
import javax.inject.Inject
import javax.security.auth.Subject
import javax.security.auth.callback.CallbackHandler
import javax.security.enterprise.AuthenticationStatus
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.HttpConstraint
import javax.servlet.annotation.ServletSecurity
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebFilter(urlPatterns = arrayOf("/*"))
@DeclareRoles("admin", "user", "demo")
@ServletSecurity(HttpConstraint(rolesAllowed = arrayOf("user")))
class AuthFilter : Filter {

    @Inject
    private var handler: CallbackHandler? = null
    var messageContext: HttpMessageContext = HttpMessageContextImpl(handler, MessageInfoImpl(),
            Subject())
    @Inject
    private var myAuthMechanism: MyAuthMechanism? = null

    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig) {

    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(
            servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        val httpServletRequest = servletRequest as HttpServletRequest
        val httpServletResponse = servletResponse as HttpServletResponse
        val isValid = myAuthMechanism!!.validateRequest(httpServletRequest, httpServletResponse,
                messageContext)
        if (isValid == AuthenticationStatus.SUCCESS) {
            filterChain.doFilter(servletRequest, servletResponse)
        } else {
            servletResponse.sendError(401)
        }
    }

    override fun destroy() {

    }


}

