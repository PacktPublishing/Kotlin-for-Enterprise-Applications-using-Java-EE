package org.rao.kotlin.microservices.authentication.auth

import com.sun.jersey.spi.inject.Inject
import org.rao.kotlin.microservices.authentication.store.MyIdentityStore
import javax.security.enterprise.AuthenticationStatus
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext
import javax.security.enterprise.credential.UsernamePasswordCredential
import javax.security.enterprise.identitystore.CredentialValidationResult.Status.VALID
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomAuthMechanism: HttpAuthenticationMechanism {
    @Inject
    internal var myIdentityStore = MyIdentityStore()

    override fun validateRequest(req: HttpServletRequest,
                                 res: HttpServletResponse,
                                 context: HttpMessageContext): AuthenticationStatus {
        val result = myIdentityStore.validate(
                UsernamePasswordCredential(
                        req.getHeader("UserId"),
                        req.getHeader("Password")))
        return if (result.status == VALID) {
            AuthenticationStatus.SUCCESS
        } else {
            AuthenticationStatus.SEND_FAILURE
        }
    }
    fun test() {

        println("MyAuthMechanism.test method")
    }


}
