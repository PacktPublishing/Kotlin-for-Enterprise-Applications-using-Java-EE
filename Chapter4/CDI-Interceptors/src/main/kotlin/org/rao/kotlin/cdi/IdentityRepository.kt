package org.rao.kotlin.cdi

import java.util.UUID

class IdentityRepository {
    fun store(person: Person) {
        person.identifier = UUID.randomUUID()

    }
}
