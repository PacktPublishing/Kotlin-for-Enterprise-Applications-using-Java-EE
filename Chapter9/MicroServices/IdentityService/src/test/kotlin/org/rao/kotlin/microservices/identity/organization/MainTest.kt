package org.rao.kotlin.microservices.identity.organization

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import org.codehaus.jettison.json.JSONObject
import org.junit.Test
import javax.ws.rs.core.MediaType
import kotlin.test.assertNotNull

class MainTest {
    @Test
    fun testGetOrg(){

        getOrg(getToken())
        /* assertNotNull(response)
       //  assertNotNull(response.get("orgName"))
         assertNotNull(response.get("orgId"))
     */
    }
    private fun getToken():String {
        try {

            val client = Client.create()

            val webResource = client
                    .resource("http://localhost:8082/authentication-service/authorize/jwt/token")


            val response = webResource.header("Accept","application/json")
                    .header("Content-Type", "application/json")
                    .header("UserId","testUser")
                    .header("Password","testUserPass")
                    .post<ClientResponse>(ClientResponse::class.java)

            if (response.getStatus() != 200) {
                throw RuntimeException("Failed : HTTP error code : " + response.getStatus())
            }

            println("Output from Server .... \n")
            val output = response.getEntity(String::class.java)
            println(output)
            return JSONObject(output).get("JWT").toString()


        } catch (e: Exception) {
            return "exception"
        }

    }




    private fun getOrg(jwt:String){
        var headers = HashMap<String,String>()
        headers.put("Authorization","Bearer $jwt")

        /*  return execute("http://localhost:8090/identity-service/identity/organization/1234",
                  headers)*/
        try {

            val client = Client.create()

            val webResource = client
                    .resource("http://localhost:8086/identity-service/identity/organization/123")

            val response = webResource.accept("application/json")
                    .header("Authorization","Bearer $jwt")
                    .get<ClientResponse>(ClientResponse::class.java)

            if (response.getStatus() != 200) {
                throw RuntimeException("Failed : HTTP error code : " + response.getStatus())
            }

            val output = response.getEntity(String::class.java)

            println("Output from Server .... \n")
            println(output)

        } catch (e: Exception) {
            //return JSONObject()


        }

    }

    /*private fun execute(resourceUri:String, map:Map<String, String>):JSONObject{
        try {
            val client = Client.create()
            val webResource = client.resource(resourceUri).accept(MediaType.APPLICATION_JSON)
            for (entry in map) {
                webResource.header(entry.key, entry.value)
            }

            val response = webResource

                    .get<ClientResponse>(ClientResponse::class.java)

            if (response.getStatus() != 200) {
                throw RuntimeException("Failed : HTTP error code : " + response.getStatus())
            }

            val output = response.getEntity(String::class.java)

            println("Output from Server ------------------------------------.... \n")
            println(output)
            return JSONObject(output)

        } catch (e: Exception) {
            return JSONObject()
        }
    }*/



}
