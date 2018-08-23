package org.rao.kotlin.rest

import org.glassfish.soteria.identitystores.annotation.Credentials
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

@Path("/greet")
public class Controller {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun home(): String {
        return "hello"
    }


    @GET
    @Path("/{parameter}")
    fun greet(@PathParam("parameter") name: String): Response {

        val response = "Hello : $name"

        return Response.status(200).entity(response).build()

    }
}

