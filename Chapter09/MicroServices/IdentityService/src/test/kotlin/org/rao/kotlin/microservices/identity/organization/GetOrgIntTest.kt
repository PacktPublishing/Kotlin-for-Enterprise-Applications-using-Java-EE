package org.rao.kotlin.microservices.identity.organization

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import org.codehaus.jettison.json.JSONObject
import org.junit.Test
import kotlin.test.assertNotNull

class GetOrgIntTest {
    /* @JvmStatic
     fun main(args: Array<String>) {

         //println(getToken())


     }*/

  //  @Test
    fun testGetOrg() {

        var response = getOrg(getToken())
        assertNotNull(response)
        assertNotNull(response.get("orgName"))
        assertNotNull(response.get("orgId"))

    }

    private fun getToken(): String {
        val client = Client.create()

        val webResource = client
                .resource("http://localhost:8082/authentication-service/authorize/jwt/token")

        val response = webResource
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("UserId", "testUser")
                .header("Password", "testUserPass")
                .post<ClientResponse>(ClientResponse::class.java)

        val responseBody = response.getEntity(String::class.java)
        return JSONObject(responseBody).get("JWT").toString()
    }

    private fun getOrg(jwt: String): JSONObject {

        val client = Client.create()

        val webResource = client
                .resource("http://localhost:8083/identity-service/identity/organization/123")

        val response = webResource
                .accept("application/json")
                .header("Authorization", "Bearer $jwt")
                .get<ClientResponse>(ClientResponse::class.java)


        val responseBody = response.getEntity(String::class.java)
        return JSONObject(responseBody)

    }
}
