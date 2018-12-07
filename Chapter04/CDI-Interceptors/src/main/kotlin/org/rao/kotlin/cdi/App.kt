package org.rao.kotlin.cdi

import org.rao.kotlin.cdi.interceptors.Auditable
import org.rao.kotlin.cdi.interceptors.Auditor
import javax.ejb.Stateless
import javax.inject.Inject

@Stateless
class App {
    @Inject
    private lateinit var identityCreator: IdentityCreator
    @Inject
    private lateinit var identityRepository: IdentityRepository

    @Auditable(Auditor.AuditType.CREATE)
    fun createResource(inputData: InputData): Resource {
        val person = identityCreator.createPerson(inputData)
        identityRepository.store(person)
        return person
    }
}

