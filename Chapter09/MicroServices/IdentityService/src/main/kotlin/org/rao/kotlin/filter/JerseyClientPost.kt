package org.rao.kotlin.filter

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import org.codehaus.jettison.json.JSONObject
import javax.ws.rs.core.MediaType

object JerseyClientPost {

    @JvmStatic
    fun main(args: Array<String>) {

        try {

            val client = Client.create()

            val webResource = client
                    .resource("http://localhost:8080/authentication-service/authorize/jwt/verify" +
                            "-token")

          //  val input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}"

            val response = webResource.type("application/json").header("Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiJ9" +
                            ".eyJqdGkiOiIxMjM0IiwiaWF0IjoxNTM2MTQzNTUyLCJzdWIiOiJzdWIxMjMiLCJpc3MiOiJsb2NhbGhvc3QiLCJhdWQiOiIvand0dG9rZW4iLCJleHAiOjE1MzYxNDQ0NTJ9.B3gNM_TLukq09NRciO9oFyIXzRF78imILgleM_KLs44")
                    .post<ClientResponse>(ClientResponse::class.java)

            if (response.getStatus() != 200) {
                throw RuntimeException("Failed : HTTP error code : " + response.getStatus())
            }

            println("Output from Server .... \n")
            val output = response.getEntity(String::class.java)
            println(output)

        } catch (e: Exception) {

            e.printStackTrace()

        }

    }

     fun execute(resourceUri: String, map: Map<String, String>, httpMethod:String):
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
