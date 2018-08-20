package org.rao.kotlin.rest

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

@Path("/greet")
public class HelloWorld {

    @GET
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

