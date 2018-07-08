package org.rao.kotlin.jpa.entity

import javax.inject.Inject

open class Identity {
    @Inject
    private lateinit var idGenerator: IdGenerator
}



