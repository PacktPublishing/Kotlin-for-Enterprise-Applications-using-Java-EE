package org.rao.kotlin.cdi

import java.util.UUID

class Person : Identity() {
    var preferredLanguage: PreferredLanguage? = null
    lateinit var identifier: UUID
}
