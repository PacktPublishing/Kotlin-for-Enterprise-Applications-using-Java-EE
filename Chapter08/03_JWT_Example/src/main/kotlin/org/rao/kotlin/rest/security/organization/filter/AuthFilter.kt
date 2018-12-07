package org.rao.kotlin.rest.security.organization.filter

import io.jsonwebtoken.ExpiredJwtException
import org.rao.kotlin.rest.security.organization.util.JWTUtil.extractJwtToken
import org.rao.kotlin.rest.security.organization.util.JWTUtil.verifyJwt
import java.io.IOException
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebFilter(urlPatterns = arrayOf("/organization/*"))
class AuthFilter : Filter {


    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig) {

    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(
            servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        val httpServletRequest = servletRequest as HttpServletRequest
        val httpServletResponse = servletResponse as HttpServletResponse

        var header: String = httpServletRequest.getHeader("Authorization")
        var token: String = extractJwtToken(header);
       try{
           verifyJwt(token)
       } catch (expiredJwtException: ExpiredJwtException) {
           httpServletResponse.sendError(403)
       } catch (securityException: SecurityException) {
           httpServletResponse.sendError(403)
       } catch (exception: Exception) {
           httpServletResponse.sendError(403)
       }
        filterChain.doFilter(servletRequest, servletResponse)
    }

    override fun destroy() {

    }


}

