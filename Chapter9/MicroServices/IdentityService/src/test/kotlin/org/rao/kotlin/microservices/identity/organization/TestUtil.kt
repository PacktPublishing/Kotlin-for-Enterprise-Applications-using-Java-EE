package org.rao.kotlin.microservices.identity.organization

import javax.ws.rs.core.Response
import org.rao.kotlin.microservices.identity.util.Constants

object TestUtil {
    val AUTHENTICATION_SERVICE_URL = "http://localhost:8082/authentication-service"
    val IDENTITY_SERVICE_URL = "http://localhost:8083/identity-service"

    val TOKEN_API = "/authorize/jwt/token"
    val ORGANIZATION_API = "/identity/organization/"


    fun getResponseForIdentityCreation(uuid: String): Response {
        return Response.status(Response.Status.CREATED)
                .entity(Constants.IDENTITY_CREATED)
                .header("location", uuid)
                .build()
    }
}
