package org.rao.kotlin.filter

import com.sun.jersey.api.client.Client
import com.sun.jersey.api.client.ClientResponse
import io.jsonwebtoken.Jwts
import java.util.*
import javax.xml.bind.DatatypeConverter

object JWTVerifier {
    val AUTHORIZATION_HEADER = "Authorization"
    val BEARER_TYPE = "Bearer"
    val AUDIENCE = "/jwttoken"
    val SECRET = "secret"


    public fun verifyJwt(token: String) {
        validateToken()
        val claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
                .parseClaimsJws(token)
                .body
        if(!claims.audience.endsWith(AUDIENCE))
            throw SecurityException("invalid audience value")
    }

    fun extractJwtToken(authorization: String): String {
        if(Objects.isNull(authorization) || "" ==
                authorization) {
            throw SecurityException("Authorization required.")
        }

        val parts = authorization.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (!BEARER_TYPE.equals(parts[0])) {
            throw SecurityException("Unsupported authorization " + parts[0])
        }

        return parts[1]
    }
   fun validateToken() {
       try {

           val client = Client.create()

           val webResource = client
                   .resource("http://localhost:8082/authentication-service/authorize/jwt/verify-token")

           //  val input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}"

           val response = webResource.header("Accept","application/json")
                   .header("Content-Type", "application/json")
                   .header("Authorization",
                   "Bearer eyJhbGciOiJIUzI1NiJ9" +
                           ".eyJqdGkiOiIxMjM0IiwiaWF0IjoxNTM1NTY2NDM2LCJzdWIiOiJzdWIxMjMiLCJpc3MiOiJsb2NhbGhvc3QiLCJhdWQiOiIvand0dG9rZW4iLCJleHAiOjE1MzU1NjczMzZ9.PulP9WbCfWyBG87ruyrbJYPcuLLl98SSt6e60uypinY")
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


}
