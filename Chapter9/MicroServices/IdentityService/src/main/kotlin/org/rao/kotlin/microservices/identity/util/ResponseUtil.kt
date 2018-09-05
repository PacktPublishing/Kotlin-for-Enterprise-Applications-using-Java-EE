package org.rao.kotlin.microservices.identity.util

import org.rao.kotlin.microservices.identity.response.ErrorResponse
import javax.ws.rs.core.Response

object ResponseUtil {

    fun sendErrorResponse(errorMessage: String, statusCode:Int): Response {
        var errorResponse: ErrorResponse = ErrorResponse()
        errorResponse.responseMessage = errorMessage

        return Response.status(statusCode)
                .entity(errorResponse)
                .build();
    }
}
