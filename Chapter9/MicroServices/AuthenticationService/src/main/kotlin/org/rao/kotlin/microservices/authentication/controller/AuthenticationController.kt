package org.rao.kotlin.microservices.authentication.controller

import com.sun.jersey.spi.inject.Inject
import io.jsonwebtoken.ExpiredJwtException
import org.codehaus.jettison.json.JSONObject
import org.glassfish.soteria.mechanisms.HttpMessageContextImpl
import org.rao.kotlin.microservices.authentication.auth.CallBackHandlerImpl
import org.rao.kotlin.microservices.authentication.auth.CustomAuthMechanism
import org.rao.kotlin.microservices.authentication.auth.MessageInfoImpl
import org.rao.kotlin.microservices.authentication.jwt.JWTUtil.createJwt
import org.rao.kotlin.microservices.authentication.jwt.JWTUtil.extractJwtToken
import org.rao.kotlin.microservices.authentication.jwt.JWTUtil.verifyJwt
import javax.security.auth.Subject
import javax.security.enterprise.AuthenticationStatus
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/authorize")
class AuthenticationController {

    @Inject
    internal var customAuthMechanism: CustomAuthMechanism? = null

    internal val httpMessageContextImpl: HttpMessageContextImpl = HttpMessageContextImpl(CallBackHandlerImpl(), MessageInfoImpl(), Subject())


    @POST
    @Path("/jwt/token")
    @Produces(MediaType.APPLICATION_JSON)
    fun issueJwt(@Context httpServletRequest: HttpServletRequest,
                 @Context httpServletResponse: HttpServletResponse): Response {

        val isValid = customAuthMechanism!!.validateRequest(httpServletRequest, httpServletResponse,
                httpMessageContextImpl)
        if (isValid == AuthenticationStatus.SUCCESS) {
            var jwt: String = createJwt("1234", "localhost", "sub123", 900000L)
            var resBody: JSONObject = JSONObject("{\"JWT\":$jwt}")
            return Response.status(Response.Status.OK).entity(resBody).build()

        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("invalid credentials").build()
        }
    }
    @POST
    @Path("/jwt/verify-token")
    @Produces(MediaType.APPLICATION_JSON)
    fun verifyToken(@Context httpServletRequest: HttpServletRequest,
                  @Context httpServletResponse: HttpServletResponse): Response {

        var header: String = httpServletRequest.getHeader("Authorization")
        var token: String = extractJwtToken(header);
        try{
            val expiresIn:Long = verifyJwt(token)
            return Response.status(200).entity(JSONObject("{\"token\":\"active\"," +
                    "\"expiresInSeconds\":$expiresIn }")).build()

        } catch (expiredJwtException: ExpiredJwtException) {
            return Response.status(403).entity(JSONObject("{\"token\":\"expired\"}")).build()
        } catch (securityException: SecurityException) {
            return Response.status(403).entity(JSONObject("{\"token\":\"security violation\"}"))
                    .build()
        } catch (exception: Exception) {
            return Response.status(403).entity(JSONObject("{\"token\":\"either token is invalid or" +
                    " " +
                    "something" +
                    " " +
                    "went wrong\"}")).build()
        }
    }
}
