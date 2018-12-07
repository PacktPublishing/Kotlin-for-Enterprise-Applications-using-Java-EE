package org.rao.kotlin.microservices.identity.person.controller

import com.sun.jersey.spi.inject.Inject
import org.rao.kotlin.microservices.identity.exception.IdentityAlreadyExistsException
import org.rao.kotlin.microservices.identity.exception.IdentityException
import org.rao.kotlin.microservices.identity.exception.IdentityNotFoundException
import org.rao.kotlin.microservices.identity.person.model.Person
import org.rao.kotlin.microservices.identity.response.GenericResponse
import org.rao.kotlin.microservices.identity.util.Constants
import org.rao.kotlin.microservices.identity.util.Constants.INTERNAL_SERVER_ERROR_MSG
import org.rao.kotlin.microservices.identity.util.ResponseUtil.sendErrorResponse
import org.rao.kotlin.service.PersonServiceImpl
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/identity/person")
class PersonController {
    @Inject
    internal var serviceImpl: PersonServiceImpl? = null

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun createPerson(person: Person): Response {
        try {
            var uuid: String = serviceImpl!!.createPerson(person)
            var response: GenericResponse = GenericResponse()
            response.responseMessage = Constants.IDENTITY_CREATED

            return Response.status(Response.Status.CREATED)
                    .entity(response)
                    .header("location", uuid)
                    .build()
        } catch (e: IdentityAlreadyExistsException) {
            return sendErrorResponse(e.message!!, Response.Status.CONFLICT.statusCode)
        }catch (e: IdentityException) {
            return sendErrorResponse(INTERNAL_SERVER_ERROR_MSG, Response.Status
                    .INTERNAL_SERVER_ERROR.statusCode)
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun retrievePersonByLoginId(@QueryParam("loginId") loginId: String): Response {
        try {
            var person: Person = serviceImpl!!.retrievePersonByLoginId(loginId)
            return Response.status(Response.Status.OK)
                    .entity(person).build()
        } catch (e: IdentityNotFoundException) {
            return sendErrorResponse(e.message!!, Response.Status.NOT_FOUND.statusCode)
        }
    }

    @Path("/{uuid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun retrievePersonByUUID(@PathParam("uuid") uuid: String): Response {
        try {
            var person: Person = serviceImpl!!.retrievePersonByLoginId(uuid)
            return Response.status(Response.Status.OK)
                    .entity(person)
                    .build()
        } catch (e: IdentityNotFoundException) {
            return sendErrorResponse(e.message!!, Response.Status.NOT_FOUND.statusCode)
        }
    }
    @Path("/{uuid}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    fun updatePerson(@PathParam("uuid") uuid: String, person: Person): Response {
        try {
            var person = serviceImpl!!.updatePerson(uuid, person)
            return Response.status(Response.Status.OK)
                    .entity(person)
                    .build()
        } catch (e: IdentityNotFoundException) {
            return sendErrorResponse(e.message!!, Response.Status.NOT_FOUND.statusCode)
        }
    }

    @Path("/{uuid}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun deletePerson(@PathParam("uuid") uuid: String): Response {
        try {
            serviceImpl!!.deletePerson(uuid)
            return Response.status(Response.Status.NO_CONTENT.statusCode).build()
        } catch (e: IdentityNotFoundException) {
            return sendErrorResponse(e.message!!, Response.Status.NOT_FOUND.statusCode)
        }
    }
}
