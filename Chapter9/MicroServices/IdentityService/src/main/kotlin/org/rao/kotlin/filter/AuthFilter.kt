package org.rao.kotlin.filter

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import io.jsonwebtoken.ExpiredJwtException
import org.codehaus.jettison.json.JSONObject
import org.rao.kotlin.filter.JWTVerifier.extractJwtToken
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
import javax.ws.rs.HttpMethod
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.MediaType

@WebFilter(urlPatterns = arrayOf("/identity/organization/*"))
class AuthFilter : Filter {

    val AUTHENTICATION_SERVICE_URL = "http://localhost:8080/authentication-service"

    val VERIFY_TOKEN_API = "/authorize/jwt/verify-token"



    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig) {

    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(
            servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain:
            FilterChain) {
        val httpServletRequest = servletRequest as HttpServletRequest
        val httpServletResponse = servletResponse as HttpServletResponse

        var header: String = httpServletRequest.getHeader("Authorization")
        var token: String = extractJwtToken(header);

        var headers = HashMap<String, String>()
        headers.put(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        headers.put(HttpHeaders.AUTHORIZATION, "Bearer $token")
        try{
            execute("$AUTHENTICATION_SERVICE_URL$VERIFY_TOKEN_API",headers, HttpMethod.POST)
            filterChain.doFilter(servletRequest, servletResponse)
        } catch (expiredJwtException: ExpiredJwtException) {
            httpServletResponse.sendError(403)
        } catch (securityException: SecurityException) {
            httpServletResponse.sendError(403)
        } catch (exception: Exception) {
            httpServletResponse.sendError(403)
        }
    }

    override fun destroy() {

    }
    fun execute(resourceUri: String, map: Map<String, String>, httpMethod:String):
            JSONObject {
        val client = Client.create()
        val webResource = client.resource(resourceUri)
                .accept(MediaType.APPLICATION_JSON)
        for (entry in map) {
            webResource.header(entry.key, entry.value)
        }

        val response: ClientResponse = webResource
                .method(httpMethod, ClientResponse::class.java)

        val responseBody = response.getEntity(String::class.java)

        return JSONObject(responseBody)
    }

}

