package org.rao.kotlin.rest.organization.controller

//import org.rao.kotlin.rest.organization.service.OrganizaionService

import org.rao.kotlin.rest.organization.model.OrganizationRequest
import org.rao.kotlin.rest.organization.model.OrganizationResponse
import org.rao.kotlin.rest.organization.service.OrganizaionService
import java.net.URI
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path("/organization")
public class OrganizationController {
    @Inject
    internal var organizationService: OrganizaionService? = null

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun createOrganization(organizationRequest: OrganizationRequest): Response {

        var orgId = organizationService!!.createOrganization(organizationRequest)

        val response = "Created : ${organizationRequest.orgName}"

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

