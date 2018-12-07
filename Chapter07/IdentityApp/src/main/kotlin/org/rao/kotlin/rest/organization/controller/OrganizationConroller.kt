package org.rao.kotlin.rest.organization.controller

import org.rao.kotlin.rest.organization.model.OrganizationRequest
import org.rao.kotlin.rest.organization.model.OrganizationResponse
import org.rao.kotlin.rest.organization.service.OrganizaionService
//import org.rao.kotlin.rest.organization.service.OrganizaionService
import java.net.URI
import javax.inject.Inject
import javax.ws.rs.*

import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path("/organization")
public class OrganizationController {
    @Inject
    internal var organizationService: OrganizaionService? = null


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun createOrganization(organizationRequest: OrganizationRequest): Response {

        val response = "Created : ${organizationRequest.orgName}"
        var orgId = organizationService!!.createOrganization(organizationRequest)

        return Response.status(201)
                .location(URI(orgId))
                .entity(response).build()

    }

    @Path("/{orgId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun retrieveOrganization(@PathParam("orgId") orgId: String): Response {
        var organizationResponse: OrganizationResponse = organizationService!!
                                                           .retrieveOrganization(orgId)
        return Response.status(200)
                .entity(organizationResponse).build()
    }
}

