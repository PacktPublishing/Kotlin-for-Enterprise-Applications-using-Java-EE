package org.rao.kotlin.rest.security.organization.util

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*
import javax.crypto.spec.SecretKeySpec

import javax.xml.bind.DatatypeConverter

object JWTUtil {
    val AUTHORIZATION_HEADER = "Authorization"
    val BEARER_TYPE = "Bearer"
    val AUDIENCE = "/jwttoken"
    val SECRET = "secret"

    public fun createJwt(id: String, issuer: String, subject: String, expiryTime: Long): String {

        val signatureAlgorithm = SignatureAlgorithm.HS256

        val currentTimeInMillis = System.currentTimeMillis()
        val date = Date(currentTimeInMillis)

        val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET)
        val signingKey = SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName())

        val builder = Jwts.builder().setId(id)
                .setIssuedAt(date)
                .setSubject(subject)
                .setIssuer(issuer)
                .setAudience(AUDIENCE)
                .signWith(signatureAlgorithm, signingKey)

        if (expiryTime >= 0) {
            val expMillis = currentTimeInMillis + expiryTime
            val exp = Date(expMillis)
            builder.setExpiration(exp)
        }

        return builder.compact()
    }


    public fun verifyJwt(token: String) {

        val claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
                .parseClaimsJws(token)
                .body
        if (!claims.audience.endsWith(AUDIENCE))
            throw SecurityException("invalid audience value")
    }

    fun extractJwtToken(authorization: String): String {
        if (Objects.isNull(authorization) || "" ==
                authorization) {
            throw SecurityException("Authorization header required.")
        }

        val parts = authorization.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (!BEARER_TYPE.equals(parts[0])) {
            throw SecurityException("Unsupported authorization header" + parts[0])
        }

        return parts[1]
    }


}
