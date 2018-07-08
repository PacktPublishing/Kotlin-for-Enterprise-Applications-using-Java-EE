package org.rao.kotlin.cdi

import javax.inject.Inject

open class Identity {
    @Inject
    private lateinit var idGenerator: IdGenerator
}



