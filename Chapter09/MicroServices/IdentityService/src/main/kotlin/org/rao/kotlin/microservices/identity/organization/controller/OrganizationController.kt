package org.rao.kotlin.microservices.identity.organization.controller

import com.sun.jersey.spi.inject.Inject
import org.rao.kotlin.microservices.identity.exception.IdentityAlreadyExistsException
import org.rao.kotlin.microservices.identity.exception.IdentityException
import org.rao.kotlin.microservices.identity.exception.IdentityNotFoundException
import org.rao.kotlin.microservices.identity.organization.service.OrganizationServiceImpl
import org.rao.kotlin.microservices.identity.response.GenericResponse
import org.rao.kotlin.microservices.identity.util.Constants
import org.rao.kotlin.microservices.identity.util.ResponseUtil
import org.rao.kotlin.microservices.identity.util.ResponseUtil.sendErrorResponse
import org.rao.kotlin.rest.organization.model.Organization
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/identity/organization")
class OrganizationController {
    @Inject
    internal var serviceImpl: OrganizationServiceImpl? = null


    @Path("/{orgId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun retrieveOrganization(@PathParam("orgId") orgId: String): Response {
        try {
            var organizationResponse: Organization = serviceImpl!!.retrieveOrganization(orgId)
            return Response.status(200)
                    .entity(organizationResponse).build()
        } catch (e: IdentityNotFoundException) {
            return sendErrorResponse(e.message!!, Response.Status.NOT_FOUND.statusCode)
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun createOrganization(organization: Organization): Response {
        try {
            var orgId: String = serviceImpl!!.createOrganization(organization)
            var response: GenericResponse = GenericResponse()
            response.responseMessage = Constants.IDENTITY_CREATED
            return Response.status(Response.Status.CREATED)
                    .header("location", "/identity/organization/$orgId")
                    .entity(response).build()
        } catch (e: IdentityAlreadyExistsException) {
            return sendErrorResponse(e.message!!, Response.Status.CONFLICT.statusCode)
        } catch (e: IdentityException) {
            return sendErrorResponse(Constants.INTERNAL_SERVER_ERROR_MSG, Response.Status
                    .INTERNAL_SERVER_ERROR.statusCode)
        }
    }

    @Path("/{orgId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    fun updateOrganization(@PathParam("orgId") orgId: String, organization: Organization):
            Response {
        try {
            var orgainzation = serviceImpl!!.updateOrganization(orgId, organization)
            return Response.status(Response.Status.OK)
                    .entity(orgainzation)
                    .build()
        } catch (e: IdentityNotFoundException) {
            return ResponseUtil.sendErrorResponse(e.message!!, Response.Status.NOT_FOUND.statusCode)
        }
    }

    @Path("/{orgId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteOrganization(@PathParam("orgId") orgId: String): Response {
        try {
            serviceImpl!!.deleteOrganization(orgId)
            return Response.status(Response.Status.NO_CONTENT.statusCode).build()
        } catch (e: IdentityNotFoundException) {
            return sendErrorResponse(e.message!!, Response.Status.NOT_FOUND.statusCode)
        }
    }

}
