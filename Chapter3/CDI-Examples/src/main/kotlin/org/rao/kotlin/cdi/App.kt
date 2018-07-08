package org.rao.kotlin.cdi

import javax.ejb.Stateless
import javax.enterprise.event.Event
import javax.inject.Inject

@Stateless
class App {
    @Inject
    private lateinit var identityCreator: IdentityCreator
    @Inject
    private lateinit var identityRepository: IdentityRepository
    @Inject
    private lateinit var personCreationEvent: Event<PersonCreationEvent>


    fun createResource(inputData: InputData): Identity {
        val person = identityCreator.createPerson(inputData)
        identityRepository.store(person)
        PersonCreationEvent(person.identifier)
        personCreationEvent.fire(PersonCreationEvent(person.identifier))
        return person

    }
}

