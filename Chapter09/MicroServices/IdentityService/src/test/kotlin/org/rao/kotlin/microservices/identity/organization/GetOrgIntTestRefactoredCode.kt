package org.rao.kotlin.microservices.identity.organization

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import org.codehaus.jettison.json.JSONObject
import org.junit.Test
import org.rao.kotlin.microservices.identity.organization.TestUtil.AUTHENTICATION_SERVICE_URL
import org.rao.kotlin.microservices.identity.organization.TestUtil.IDENTITY_SERVICE_URL
import org.rao.kotlin.microservices.identity.organization.TestUtil.ORGANIZATION_API
import org.rao.kotlin.microservices.identity.organization.TestUtil.TOKEN_API
import javax.ws.rs.HttpMethod
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.MediaType
import kotlin.test.assertNotNull

class GetOrgIntTestRefactoredCode {
    private val USERID_HEADER: String = "UserId"
    private val PASS_HEADER: String = "Password"
    private val USERID: String = "testUser"
    private val PASS: String = "testUserPass"
    private val ORG_NAME: String = "orgName"
    private val ORG_ID: String = "orgId"

    @Test
    fun testGetOrg() {
        val jwt = getToken().get("JWT").toString()

        val response = getOrg(jwt,"123")

        assertNotNull(response)
        assertNotNull(response.get(ORG_NAME))
        assertNotNull(response.get(ORG_ID))

    }

    private fun getToken(): JSONObject {

        var headers = HashMap<String, String>()
        headers.put(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        headers.put(USERID_HEADER, USERID)
        headers.put(PASS_HEADER, PASS)

        return execute("$AUTHENTICATION_SERVICE_URL$TOKEN_API", headers, HttpMethod.POST)
    }

    private fun getOrg(jwt: String, orgId: String): JSONObject {
        var headers = HashMap<String, String>()
        headers.put(HttpHeaders.AUTHORIZATION, "Bearer $jwt")
        return execute("$IDENTITY_SERVICE_URL$ORGANIZATION_API"+orgId, headers, HttpMethod.GET)
    }

    private fun execute(resourceUri: String, map: Map<String, String>, httpMethod:String):
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
