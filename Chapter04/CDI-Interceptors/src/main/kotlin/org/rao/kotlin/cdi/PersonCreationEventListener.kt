package org.rao.kotlin.cdi

import javax.enterprise.event.Observes

class PersonCreationEventListener {
    fun onPersonCreation(@Observes event: PersonCreationEvent) {
        println("new person created with id " + event.identifier)
    }
}
