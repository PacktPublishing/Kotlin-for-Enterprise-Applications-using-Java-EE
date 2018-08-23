package org.rao.kotlin.rest.organization.filter

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.security.enterprise.AuthenticationStatus
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext
import javax.security.enterprise.credential.UsernamePasswordCredential
import javax.security.enterprise.identitystore.CredentialValidationResult.Status.VALID
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ApplicationScoped
class MyAuthMechanism : HttpAuthenticationMechanism {
    @Inject
    private var myIdentityStore: MyIdentityStore? = null

    override fun validateRequest(req: HttpServletRequest,
                                 res: HttpServletResponse,
                                 context: HttpMessageContext): AuthenticationStatus {
        val result = myIdentityStore!!.validate(
                UsernamePasswordCredential(
                        req.getHeader("UserId"),
                        req.getHeader("Password")))
        return if (result.status == VALID) {
            AuthenticationStatus.SUCCESS
        } else {
            AuthenticationStatus.SEND_FAILURE
        }
    }
}
