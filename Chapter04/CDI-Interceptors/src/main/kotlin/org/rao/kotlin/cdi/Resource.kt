package org.rao.kotlin.cdi

import javax.inject.Inject

open class Resource {
    @Inject
    private lateinit var idGenerator: IdGenerator
}



