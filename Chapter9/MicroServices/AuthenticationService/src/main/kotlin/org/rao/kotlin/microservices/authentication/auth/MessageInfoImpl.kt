package org.rao.kotlin.microservices.authentication.auth


import java.io.BufferedReader
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.security.Principal
import java.util.*
import javax.security.auth.message.MessageInfo
import javax.servlet.AsyncContext
import javax.servlet.DispatcherType
import javax.servlet.RequestDispatcher
import javax.servlet.ServletContext
import javax.servlet.ServletException
import javax.servlet.ServletInputStream
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession
import javax.servlet.http.HttpUpgradeHandler
import javax.servlet.http.Part

class MessageInfoImpl : MessageInfo {
    override fun getRequestMessage(): Any {

        return object : HttpServletRequest {
            override fun getAuthType(): String? {

                return null
            }

            override fun getCookies(): Array<Cookie> {

                return arrayOf()
            }

            override fun getDateHeader(s: String): Long {

                return 0
            }

            override fun getHeader(s: String): String? {

                return null
            }

            override fun getHeaders(s: String): Enumeration<String>? {

                return null
            }

            override fun getHeaderNames(): Enumeration<String>? {

                return null
            }

            override fun getIntHeader(s: String): Int {

                return 0
            }

            override fun getMethod(): String? {

                return null
            }

            override fun getPathInfo(): String? {

                return null
            }

            override fun getPathTranslated(): String? {

                return null
            }

            override fun getContextPath(): String? {

                return null
            }

            override fun getQueryString(): String? {

                return null
            }

            override fun getRemoteUser(): String? {

                return null
            }

            override fun isUserInRole(s: String): Boolean {

                return false
            }

            override fun getUserPrincipal(): Principal? {

                return null
            }

            override fun getRequestedSessionId(): String? {

                return null
            }

            override fun getRequestURI(): String? {

                return null
            }

            override fun getRequestURL(): StringBuffer? {

                return null
            }

            override fun getServletPath(): String? {

                return null
            }

            override fun getSession(b: Boolean): HttpSession? {

                return null
            }

            override fun getSession(): HttpSession? {

                return null
            }

            override fun changeSessionId(): String? {

                return null
            }

            override fun isRequestedSessionIdValid(): Boolean {

                return false
            }

            override fun isRequestedSessionIdFromCookie(): Boolean {

                return false
            }

            override fun isRequestedSessionIdFromURL(): Boolean {

                return false
            }

            override fun isRequestedSessionIdFromUrl(): Boolean {

                return false
            }

            @Throws(IOException::class, ServletException::class)
            override fun authenticate(httpServletResponse: HttpServletResponse): Boolean {

                return false
            }

            @Throws(ServletException::class)
            override fun login(s: String, s1: String) {

            }

            @Throws(ServletException::class)
            override fun logout() {

            }

            @Throws(IOException::class, ServletException::class)
            override fun getParts(): Collection<Part>? {

                return null
            }

            @Throws(IOException::class, ServletException::class)
            override fun getPart(s: String): Part? {

                return null
            }

            @Throws(IOException::class, ServletException::class)
            override fun <T : HttpUpgradeHandler> upgrade(aClass: Class<T>): T? {

                return null
            }

            override fun getAttribute(s: String): Any? {

                return null
            }

            override fun getAttributeNames(): Enumeration<String>? {

                return null
            }

            override fun getCharacterEncoding(): String? {

                return null
            }

            @Throws(UnsupportedEncodingException::class)
            override fun setCharacterEncoding(s: String) {

            }

            override fun getContentLength(): Int {

                return 0
            }

            override fun getContentLengthLong(): Long {

                return 0
            }

            override fun getContentType(): String? {

                return null
            }

            @Throws(IOException::class)
            override fun getInputStream(): ServletInputStream? {

                return null
            }

            override fun getParameter(s: String): String? {

                return null
            }

            override fun getParameterNames(): Enumeration<String>? {

                return null
            }

            override fun getParameterValues(s: String): Array<String> {

                return arrayOf("")
            }

            override fun getParameterMap(): Map<String, Array<String>>? {

                return null
            }

            override fun getProtocol(): String? {

                return null
            }

            override fun getScheme(): String? {

                return null
            }

            override fun getServerName(): String? {

                return null
            }

            override fun getServerPort(): Int {

                return 0
            }

            @Throws(IOException::class)
            override fun getReader(): BufferedReader? {

                return null
            }

            override fun getRemoteAddr(): String? {

                return null
            }

            override fun getRemoteHost(): String? {

                return null
            }

            override fun setAttribute(s: String, o: Any) {

            }

            override fun removeAttribute(s: String) {

            }

            override fun getLocale(): Locale? {

                return null
            }

            override fun getLocales(): Enumeration<Locale>? {

                return null
            }

            override fun isSecure(): Boolean {

                return false
            }

            override fun getRequestDispatcher(s: String): RequestDispatcher? {

                return null
            }

            override fun getRealPath(s: String): String? {

                return null
            }

            override fun getRemotePort(): Int {

                return 0
            }

            override fun getLocalName(): String? {

                return null
            }

            override fun getLocalAddr(): String? {

                return null
            }

            override fun getLocalPort(): Int {

                return 0
            }

            override fun getServletContext(): ServletContext? {

                return null
            }

            @Throws(IllegalStateException::class)
            override fun startAsync(): AsyncContext? {

                return null
            }

            @Throws(IllegalStateException::class)
            override fun startAsync(
                    servletRequest: ServletRequest, servletResponse: ServletResponse): AsyncContext? {

                return null
            }

            override fun isAsyncStarted(): Boolean {

                return false
            }

            override fun isAsyncSupported(): Boolean {

                return false
            }

            override fun getAsyncContext(): AsyncContext? {

                return null
            }

            override fun getDispatcherType(): DispatcherType? {

                return null
            }
        }
    }

    override fun getResponseMessage(): Any? {

        return null
    }

    override fun setRequestMessage(o: Any) {

    }

    override fun setResponseMessage(o: Any) {

    }

    override fun getMap(): Map<*, *>? {

        return null
    }
}
