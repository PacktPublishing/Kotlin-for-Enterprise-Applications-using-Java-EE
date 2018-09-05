package org.rao.kotlin.microservices.authentication.store

import java.util.Arrays.asList
import javax.security.enterprise.credential.Credential
import javax.security.enterprise.credential.UsernamePasswordCredential
import javax.security.enterprise.identitystore.CredentialValidationResult
import javax.security.enterprise.identitystore.IdentityStore

class MyIdentityStore:IdentityStore {
    fun test() {

        println("MyIdentityStore.test method")
    }

    override fun validate(userCredential: Credential): CredentialValidationResult {
        return if (userCredential is UsernamePasswordCredential &&
                userCredential.compareTo("testUser", "testUserPass")) {
            CredentialValidationResult("admin",
                    HashSet(asList("user")))
        } else CredentialValidationResult.INVALID_RESULT
    }
}
