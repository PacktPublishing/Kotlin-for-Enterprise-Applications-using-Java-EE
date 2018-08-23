package org.rao.kotlin.rest

import org.glassfish.soteria.identitystores.annotation.Credentials

import javax.annotation.security.DeclareRoles
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application
import java.util.HashSet
import javax.enterprise.context.ApplicationScoped
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue
import javax.security.enterprise.identitystore.LdapIdentityStoreDefinition

@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = LoginToContinue(loginPage = "/login.jsf"))
@ApplicationScoped
class ApplicationConfig : Application() {
    override fun getClasses(): Set<Class<*>> {
        val classes = HashSet<Class<*>>()
        classes.add(Controller::class.java)
        return classes
    }

}



