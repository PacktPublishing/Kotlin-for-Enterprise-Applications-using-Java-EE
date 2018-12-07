package org.rao.kotlin.rest.security.organization.filter

import java.util.*
import java.util.Arrays.asList
import javax.annotation.ManagedBean
import javax.enterprise.context.ApplicationScoped
import javax.security.enterprise.credential.Credential
import javax.security.enterprise.credential.UsernamePasswordCredential
import javax.security.enterprise.identitystore.CredentialValidationResult
import javax.security.enterprise.identitystore.IdentityStore

@ApplicationScoped
@ManagedBean
class MyIdentityStore : IdentityStore {
     override fun validate(userCredential: Credential): CredentialValidationResult {
         return if (userCredential is UsernamePasswordCredential &&
                     userCredential.compareTo("testUser", "testUserPass")) {
             CredentialValidationResult("admin",
                     HashSet(asList("user")))
         } else CredentialValidationResult.INVALID_RESULT
    }
}
